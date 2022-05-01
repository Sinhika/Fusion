package mod.alexndr.fusion.loot;

import mod.alexndr.simplecorelib.api.helpers.InjectionTableLookup;

@SuppressWarnings("serial")
public class FusionInjectionLookup extends InjectionTableLookup
{

    public FusionInjectionLookup()
    {
        super();
        this.AddOceanAliases();
        
        // use shipwreck for all underwater stuff.
        this.replace("underwater_ruin_small", "shipwreck");
        this.replace("underwater_ruin_big", "shipwreck");
        
        this.AddDungeonAliases();
        this.AddStrongholdAliases();
        
        // these tables all present as themselves.
        this.put("abandoned_mineshaft", "abandoned_mineshaft");
        this.put("desert_pyramid", "desert_pyramid");
        this.put("igloo_chest", "igloo_chest");
        this.put("jungle_temple", "jungle_temple");
        this.put("spawn_bonus_chest", "spawn_bonus_chest");
        this.put("village_armorer", "village_armorer");
        this.put("village_fletcher", "village_fletcher");
        this.put("village_mason", "village_mason");
        this.put("village_shepherd", "village_shepherd");
        this.put("village_toolsmith", "village_toolsmith");
        this.put("village_weaponsmith", "village_weaponsmith");
        
    } // end ctor

} // end class
