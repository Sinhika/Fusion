package mod.alexndr.fusion.api.client;

import net.minecraft.client.Minecraft;
import net.minecraft.world.item.crafting.RecipeManager;

public class ClientOnlyWrapper
{
    @SuppressWarnings("resource")
    public static RecipeManager getRecipeManager()
    {
        return Minecraft.getInstance().level.getRecipeManager();
    } // end getRecipeManager()
} // end class
