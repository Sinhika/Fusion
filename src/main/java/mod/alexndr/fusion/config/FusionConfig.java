package mod.alexndr.fusion.config;

import java.util.HashMap;
import java.util.Map;

import mod.alexndr.simpleores.api.config.ISimpleConfig;

public class FusionConfig implements ISimpleConfig
{
    private static Map<String, Boolean> flags = new HashMap<>();
    public static FusionConfig INSTANCE = new FusionConfig();
    
    @Override
    public void clear() {
        flags.clear();
    }

    @Override
    public boolean getFlag(String arg0)
    {
        Boolean obj = flags.get(arg0);
        return obj != null && obj;
    }

    @Override
    public void putFlag(String arg0, boolean arg1)
    {
        flags.put(arg0, arg1);
    }

} // end class
