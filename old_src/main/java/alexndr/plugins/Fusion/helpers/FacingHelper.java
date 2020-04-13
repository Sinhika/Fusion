package alexndr.plugins.Fusion.helpers;

import net.minecraft.util.EnumFacing;

/**
 * Helper functions for figuring out facings. Mostly used by machines to figure out 
 * which slot is where.
 *
 */
public class FacingHelper 
{
	public static final EnumFacing DEFAULT_FACING = EnumFacing.NORTH;
	
	/**
	 * What would this facing be relative to DEFAULT_FACING?
	 * @param changedFacing
	 * @return facing relative to north
	 */
	
	public static EnumFacing withDefaultFacing(EnumFacing blockFacing, EnumFacing changedFacing)
	{
		EnumFacing relativeFacing = DEFAULT_FACING;
		
		/* simplest case */
		if (blockFacing == DEFAULT_FACING) {
			return changedFacing;
		}
		/* next simplest case: opposite face */
		if (blockFacing.getOpposite() == DEFAULT_FACING) {
			relativeFacing = changedFacing.getOpposite();
		}
		else if (blockFacing.rotateY() == DEFAULT_FACING) 
		{
			relativeFacing = changedFacing.rotateY();
		}
		else if (blockFacing.rotateYCCW() == DEFAULT_FACING)
		{
			relativeFacing = changedFacing.rotateYCCW();
		}
		return relativeFacing;
	} // end withDefaultFacing()
} // end-class
