package mod.alexndr.fusion.init;

import mod.alexndr.fusion.Fusion;
import mod.alexndr.fusion.api.recipe.FusionRecipe;
import mod.alexndr.fusion.api.recipe.IFusionRecipe;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModRecipeTypes
{
    public static final DeferredRegister<RecipeType<?>> RECIPE_TYPES = 
            DeferredRegister.create(Registries.RECIPE_TYPE, Fusion.MODID);
    
    public static final RegistryObject<RecipeType<IFusionRecipe>> FUSION_TYPE = 
            RECIPE_TYPES.register(IFusionRecipe.TYPE_ID.getPath(), ()-> new RecipeType<IFusionRecipe>() {}) ;
            
    
    public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS = 
            DeferredRegister.create(Registries.RECIPE_SERIALIZER, Fusion.MODID);
    
    public static final RegistryObject<RecipeSerializer<FusionRecipe>> FUSION_SERIALIZER = 
            RECIPE_SERIALIZERS.register(IFusionRecipe.TYPE_ID.getPath(), () -> new FusionRecipe.FusionRecipeSerializer());
    

} // end class ModRecipeTypes
