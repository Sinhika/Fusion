package mod.alexndr.fusion.init;

import mod.alexndr.fusion.Fusion;
import mod.alexndr.fusion.api.recipe.FusionRecipe;
import mod.alexndr.fusion.api.recipe.IFusionRecipe;
import net.minecraft.core.Registry;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModRecipeTypes
{
    public static final DeferredRegister<RecipeType<?>> RECIPE_TYPES = 
            DeferredRegister.create(Registry.RECIPE_TYPE_REGISTRY.location(), Fusion.MODID);
    
//    public static final RecipeType<IFusionRecipe> FUSION_TYPE = RecipeType.register(IFusionRecipe.TYPE_ID.toString());
//    Registry.register(Registry.RECIPE_TYPE, IFusionRecipe.TYPE_ID, ModRecipeTypes.FUSION_TYPE);

    public static final RegistryObject<RecipeType<IFusionRecipe>> FUSION_TYPE = 
            RECIPE_TYPES.register(IFusionRecipe.TYPE_ID.getPath(), ()-> new RecipeType<IFusionRecipe>() {}) ;
            
    
    public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS = 
            DeferredRegister.create(ForgeRegistries.Keys.RECIPE_SERIALIZERS, Fusion.MODID);
    
    //evt.getRegistry().register(ModRecipeTypes.FUSION_SERIALIZER.setRegistryName(IFusionRecipe.TYPE_ID));
    
    public static final RegistryObject<RecipeSerializer<FusionRecipe>> FUSION_SERIALIZER = 
            RECIPE_SERIALIZERS.register(IFusionRecipe.TYPE_ID.getPath(), () -> new FusionRecipe.FusionRecipeSerializer());
    

} // end class ModRecipeTypes
