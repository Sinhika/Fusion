package mod.alexndr.fusion.recipe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import mod.alexndr.fusion.init.ModRecipeTypes;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.fml.server.ServerLifecycleHooks;
import net.minecraftforge.items.wrapper.RecipeWrapper;
import net.minecraftforge.registries.ForgeRegistryEntry;

public class FusionRecipe implements IFusionRecipe
{
    private final ResourceLocation id;
    private final ItemStack output;
    private final NonNullList<Ingredient> inputs;
    private final Ingredient catalyst;
    private final int cook_time;
    private final float experience;
    
    private final int INPUT1_SLOT = 0;
    private final int INPUT2_SLOT = 1;
    private final int CATALYST_SLOT = 2;
 
    private static Set<ItemStack> legal_inputs = new HashSet<ItemStack>();
    private static Set<ItemStack> legal_catalysts = new HashSet<ItemStack>();
    
    public FusionRecipe(ResourceLocation id, ItemStack output,  int cook_time, float experience,
                        Ingredient catalyst, Ingredient... inputs)
    {
        this.id = id;
        this.output = output;
        this.inputs = NonNullList.from(null, inputs);
        this.catalyst = catalyst;
        this.cook_time = cook_time;
        this.experience = experience;
    }

    private static void initLegalisms()
    {
        Iterable<IRecipe<?>> recipes = 
                ServerLifecycleHooks.getCurrentServer().getRecipeManager().getRecipes();
        for (IRecipe<?> recipe: recipes)
        {
            // we only want Fusion recipes.
             if (recipe.getType() != ModRecipeTypes.FUSION_TYPE) {
                 continue;
             }
             legal_catalysts.add(((FusionRecipe) recipe).getCatalyst().getMatchingStacks()[0]);
             NonNullList<Ingredient> ingrs = recipe.getIngredients();
             for (Ingredient ingr: ingrs)
             {
                 legal_inputs.addAll(Arrays.asList(ingr.getMatchingStacks()));
             } // end-for
        } // end-for
    } // end initLegalisms

    public static boolean isInput(ItemStack stack)
    {
        if (legal_inputs.isEmpty()) {
            initLegalisms();
        }
        return legal_inputs.contains(stack);
    }
   
    public static boolean isCatalyst(ItemStack stack)
    {
        if (legal_catalysts.isEmpty()) {
            initLegalisms();
        }
        return legal_catalysts.contains(stack);
    }
    
    /**
     * Used to check if a recipe matches current crafting inventory
     */
    @Override
    public boolean matches(RecipeWrapper inv, World worldIn)
    {
        List<Ingredient> ingredientsMissing = new ArrayList<>(inputs);
        
        // check inputs, could be in either slot...
        for (int ii = INPUT1_SLOT; ii <= INPUT2_SLOT; ii++)
        {
            ItemStack input = inv.getStackInSlot(ii);
            if (input.isEmpty()) {
                break;
            }
            int stackIndex = -1;
            for (int jj = 0; jj < ingredientsMissing.size(); jj++)
            {
                Ingredient ingr = ingredientsMissing.get(jj);
                if (ingr.test(input)) {
                    stackIndex = jj;
                    break;
                }
            }
            if (stackIndex != -1) {
                ingredientsMissing.remove(stackIndex);
            } 
            else {
                return false;
            }
        } // end-for ii
        
        // check catalyst
        ItemStack cata = inv.getStackInSlot(CATALYST_SLOT);
        if (this.catalyst.test(cata)) {
            return ingredientsMissing.isEmpty();
        }
        else {
            return false;
        }
    } // end matches()

    /**
     * Returns an Item that is the result of this recipe
     */
    @Override
    public ItemStack getCraftingResult(RecipeWrapper inv)
    {
        return getRecipeOutput().copy();
    }

    /**
     * Get the result of this recipe, usually for display purposes (e.g. recipe book). If your recipe has more than one
     * possible result (e.g. it's dynamic and depends on its inputs), then return an empty stack.
     */
    @Override
    public ItemStack getRecipeOutput()
    {
        return this.output;
    }
    
    public Ingredient getCatalyst()
    {
        return this.catalyst;
    } // end class FusionRecipe

    
    @Override
    public NonNullList<Ingredient> getIngredients()
    {
        return inputs;
    }

    @Override
    public ResourceLocation getId()
    {
        return this.id;
    }

    public int getCookTime()
    {
        return this.cook_time;
    }
    
    public float getExperience()
    {
        return this.experience;
    }
    
    @Override
    public IRecipeSerializer<?> getSerializer()
    {
        return ModRecipeTypes.FUSION_SERIALIZER;
    }

    
    public static class FusionRecipeSerializer extends ForgeRegistryEntry<IRecipeSerializer<?>>
    implements IRecipeSerializer<FusionRecipe>
    {

        @Override
        public FusionRecipe read(ResourceLocation recipeId, JsonObject json)
        {
            ItemStack output = CraftingHelper.getItemStack(JSONUtils.getJsonObject(json, "output"), 
                                                           true);
            JsonArray ingrs = JSONUtils.getJsonArray(json, "inputs");
            List<Ingredient> inputs = new ArrayList<>();
            for (JsonElement e : ingrs) {
                inputs.add(Ingredient.deserialize(e));
            }
            Ingredient catalyst = Ingredient.fromStacks(CraftingHelper.getItemStack(
                                                    JSONUtils.getJsonObject(json, "catalyst"),true));
            
            int cook_time = JSONUtils.getInt(json, "cookingtime");
            float experience = JSONUtils.getFloat(json, "experience");
            
            return new FusionRecipe(recipeId, output, cook_time, experience, catalyst,
                                     inputs.toArray(new Ingredient[0]));
        } // end read(json)

        @Override
        public FusionRecipe read(ResourceLocation recipeId, PacketBuffer buf)
        {
            Ingredient[] inputs = new Ingredient[buf.readVarInt()];
            for (int ii = 0; ii < inputs.length; ii++) {
                inputs[ii] = Ingredient.read(buf);
            }
            ItemStack output = buf.readItemStack();
            Ingredient catalyst = Ingredient.read(buf);
            int cook_time = buf.readVarInt();
            float exp = buf.readFloat();
            
            return new FusionRecipe(recipeId, output, cook_time, exp, catalyst, inputs);
        } // end read(packet)

        @Override
        public void write(PacketBuffer buf, FusionRecipe recipe)
        {
            buf.writeVarInt(recipe.getIngredients().size());
            for (Ingredient input : recipe.getIngredients()) {
                input.write(buf);
            }
            buf.writeItemStack(recipe.getRecipeOutput(), false);
            recipe.getCatalyst().write(buf);
            buf.writeVarInt(recipe.getCookTime());
            buf.writeFloat(recipe.getExperience());
        } // end write(packet)

    } // end class FusionRecipeSerializer

} // end class FusionRecipe
