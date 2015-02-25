package com.pbjboss.solarannihilation;

import com.pbjboss.solarannihilation.configuration.ConfigurationHandler;
import com.pbjboss.solarannihilation.handler.EventHandler;
import com.pbjboss.solarannihilation.handler.EventHandlerMF;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.MinecraftForge;

/**
 * Created by PbJBOSS on 2/23/2015.
 */

@Mod(modid = SolarAnnihilation.modid, name = SolarAnnihilation.name, version = SolarAnnihilation.version, /*Allows the mod to run server side only */acceptableRemoteVersions = "*")
public
class SolarAnnihilation
{
    public static final String modid = "solarannihilation";
    public static final String name = "Solar Annihilation";
    public static final String version = "1.7.10-1.0";

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        //Register main mod event handler
        FMLCommonHandler.instance().bus().register(new EventHandler());
        MinecraftForge.EVENT_BUS.register(new EventHandlerMF());
        ConfigurationHandler.load(event.getSuggestedConfigurationFile());
    }
}
