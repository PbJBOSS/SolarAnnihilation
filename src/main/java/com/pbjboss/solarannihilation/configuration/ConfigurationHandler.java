package com.pbjboss.solarannihilation.configuration;

import cpw.mods.fml.common.FMLLog;
import net.minecraftforge.common.config.Configuration;
import org.apache.logging.log4j.Level;

import java.io.File;

/**
 * Created by PbJBOSS on 2/23/2015.
 */
public
class ConfigurationHandler
{
    public static int damageInterval;
    public static float damagePerInterval;
    public static boolean warnPlayerOnJoin;

    public static
    Configuration config;

    public static void load(File file)
    {
        config = new Configuration(file);

        try
        {
            config.load();

            damagePerInterval = config.getFloat("damagePerInterval", Configuration.CATEGORY_GENERAL, 1F, .5F, 20F, "Amount of damage to do to a player every interval. 1 is half a heart");
            damageInterval = config.getInt("damageInterval",Configuration.CATEGORY_GENERAL, 1, 1, 10, "Every x amount of seconds the player will take damage");
            warnPlayerOnJoin = config.getBoolean("warnPlayerOnJoin", Configuration.CATEGORY_GENERAL, false, "Warn players that the mod is installed on the server");
        }
        catch (Exception e)
        {
            FMLLog.log(Level.ERROR, "Error loading config!");
        }
        finally
        {
            if (config.hasChanged())
                config.save();
        }
    }
}
