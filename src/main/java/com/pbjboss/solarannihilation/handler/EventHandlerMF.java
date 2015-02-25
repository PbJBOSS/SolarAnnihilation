package com.pbjboss.solarannihilation.handler;

import com.pbjboss.solarannihilation.configuration.ConfigurationHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;

/**
 * Created by PbJBOSS on 2/25/2015.
 */
public
class EventHandlerMF
{
    @SubscribeEvent
    public void itemToolTipEvent(ItemTooltipEvent event)
    {
        if (ConfigurationHandler.addUNToTooltip)
        {
            event.toolTip.add(event.itemStack.getItem().getUnlocalizedName());
        }
    }
}
