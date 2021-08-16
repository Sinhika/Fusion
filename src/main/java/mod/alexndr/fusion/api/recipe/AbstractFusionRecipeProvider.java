package mod.alexndr.fusion.api.recipe;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.mojang.serialization.Dynamic;
import com.mojang.serialization.JsonOps;

import mod.alexndr.fusion.init.ModRecipeTypes;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.nbt.NbtOps;
import net.minecraft.core.NonNullList;
import net.minecraft.resources.ResourceLocation;

public class AbstractFusionRecipeProvider extends RecipeProvider
{

    public AbstractFusionRecipeProvider(DataGenerator generatorIn)
    {
        super(generatorIn);
    }

    @Override
    public String getName()
    {
        return "SimpleOres:Fusion Alloy Recipes";
    }

    public static ResourceLocation id(String modid, String path) 
    {
        return new ResourceLocation(modid, "fusion_furnace/" + path);
    }
    
    
    public static class FinishedFusionRecipe implements FinishedRecipe
    {
        private final ResourceLocation id;
        private final ItemStack output;
        private final NonNullList<Ingredient> inputs;
        private final Ingredient catalyst;
        private final int cook_time;
        private final float experience;

        public FinishedFusionRecipe(ResourceLocation id, ItemStack output,  int cook_time, float experience,
                Ingredient catalyst, Ingredient... inputs)
        {
            this.id = id;
            this.output = output;
            this.inputs = NonNullList.of(null, inputs);
            this.catalyst = catalyst;
            this.cook_time = cook_time;
            this.experience = experience;
        }

        @Override
        public void serializeRecipeData(JsonObject json)
        {
            JsonArray json_inputs = new JsonArray();
            for (Ingredient ing : inputs)
            {
                json_inputs.add(ing.toJson());
            }
            json.add("inputs", json_inputs);
            json.add("catalyst", catalyst.toJson());
            json.add("output", serializeStack(output));
            json.addProperty("cookingtime", cook_time);
            json.addProperty("experience", experience);
        }

        @Override
        public ResourceLocation getId()
        {
            return id;
        }

        @Override
        public RecipeSerializer<?> getType()
        {
            return ModRecipeTypes.FUSION_SERIALIZER;
        }

        @Override
        public JsonObject serializeAdvancement()
        {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public ResourceLocation getAdvancementId()
        {
            // TODO Auto-generated method stub
            return null;
        }

        /**
         * Serializes the given stack such that {@link net.minecraftforge.common.crafting.CraftingHelper#getItemStack}
         * would be able to read the result back. (Borrowed from Botania).
         * 
         * @param stack - stack to be serialized.
         * @return JsonObject describing stack.
         */
        private static JsonObject serializeStack(ItemStack stack) 
        {
            CompoundTag nbt = stack.save(new CompoundTag());
            byte c = nbt.getByte("Count");
            if (c != 1) {
                nbt.putByte("count", c);
            }
            nbt.remove("Count");
            renameTag(nbt, "id", "item");
            renameTag(nbt, "tag", "nbt");
            Dynamic<Tag> dyn = new Dynamic<>(NbtOps.INSTANCE, nbt);
            return dyn.convert(JsonOps.INSTANCE).getValue().getAsJsonObject();            
        }
        
        /**
         * also borrowed from Botania.
         * @param nbt
         * @param oldName
         * @param newName
         */
        public static void renameTag(CompoundTag nbt, String oldName, String newName) {
            Tag tag = nbt.get(oldName);
            if (tag != null) {
                nbt.remove(oldName);
                nbt.put(newName, tag);
            }
        }
    } // end-class FinishedFusionRecipe
    
} // end class
