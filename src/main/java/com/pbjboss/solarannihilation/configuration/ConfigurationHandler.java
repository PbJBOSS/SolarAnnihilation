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
    public static String[] armorProtectionList;
    public static boolean addUNToTooltip;

    public static
    Configuration config;

    public static void load(File file)
    {
        config = new Configuration(file);

        try
        {
            config.load();

            damagePerInterval = config.getFloat("damagePerInterval", Configuration.CATEGORY_GENERAL, 1F, .5F, 20F, "Amount of damage to do to a player every interval. 1 is half a heart");
            damageInterval = config.getInt("damageInterval", Configuration.CATEGORY_GENERAL, 1, 1, 10, "Every x amount of seconds the player will take damage");
            armorProtectionList = config.getStringList("armorProtectionList", Configuration.CATEGORY_GENERAL, new String[] {"item.infusedHelmetEpicFlight","item.infusedPlatebodyEpicFlight", "item.infusedLeggingsEpicFlight","item.infusedBootsEpicFlight"}, "A whitelist of armor pieces that protect the player from Solar Annihilation. Unlocalized names of items are case sensitive");
            addUNToTooltip = config.getBoolean("addItemUnlocalizedNameToTooltip", Configuration.CATEGORY_GENERAL, false, "Adds the unlocalized name of items to their tooltip. Makes it easier to add armor to the whitelist.");
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
