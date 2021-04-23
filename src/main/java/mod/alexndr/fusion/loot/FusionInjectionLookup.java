package mod.alexndr.fusion.loot;

import mod.alexndr.simplecorelib.helpers.InjectionTableLookup;

@SuppressWarnings("serial")
public class FusionInjectionLookup extends InjectionTableLookup
{

    public FusionInjectionLookup()
    {
        super();
        
        // use shipwreck for all underwater stuff.
        this.replace("underwater_ruin_small", "shipwreck");
        this.replace("underwater_ruin_big", "shipwreck");
        
        // we don't have nether loot tables.
        this.replace("bastion", null);
        this.replace("nether", null);
        
        // we don't have a 'village_house' table.
        this.replace("village_savanna_house", null);
        this.replace("village_plains_house", null);
        this.replace("village_desert_house", null);
        this.replace("village_snowy_house", null);
        this.replace("village_taiga_house", null);
        
        // these tables all present as themselves.
        this.remove("igloo_chest");
        this.remove("village_armorer");
        this.remove("village_fletcher");
        this.remove("village_mason");
        this.remove("village_shepherd");
        this.remove("village_toolsmith");
        this.remove("village_weaponsmith");
        
    } // end ctor

} // end class
