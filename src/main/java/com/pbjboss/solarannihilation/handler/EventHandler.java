package com.pbjboss.solarannihilation.handler;

import com.pbjboss.solarannihilation.util.Util;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;

import java.util.List;

/**
 * Created by PbJBOSS on 2/23/2015.
 */
public
class EventHandler
{
    @SubscribeEvent
    public void serverTickEvent(TickEvent.ServerTickEvent event)
    {
        //Get list of players in the overworld
        List players = MinecraftServer.getServer().worldServerForDimension(0).playerEntities;

        //loop through each player
        for (int i = 0; i < players.size(); i++)
        {
            EntityPlayer player = (EntityPlayer) players.get(i);

            //Check if player is in the right conditions to burn
            if (Util.shouldPlayerBurn(player))
            {
                //Burn player
                Util.burnPlayer(player);
            }
        }
    }
}
