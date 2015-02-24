package com.pbjboss.solarannihilation.util;

import com.pbjboss.solarannihilation.configuration.ConfigurationHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.DamageSource;

/**
 * Created by PbJBOSS on 2/23/2015.
 */
public
class Util
{
    public static boolean shouldPlayerBurn(EntityPlayer player)
    {

        //Make sure the player is not in creative or the time is not day
        if (player.capabilities.isCreativeMode || !player.worldObj.isDaytime())
            return false;

        //Check for blocks above the player
        for (int y = (int) player.posY + 1; y < player.worldObj.provider.getActualHeight(); y++)
        {
            if (!player.worldObj.getBlock(player.getPlayerCoordinates().posX, y, player.getPlayerCoordinates().posZ).equals(Blocks.air))
                return false;
        }

        //Make sure the player isnt damaged every tick
        if (!((player.ticksExisted / 20) % ConfigurationHandler.damageInterval == 0))
            return false;

        return true;
    }

    public static void burnPlayer(EntityPlayer player)
    {
        //Damage player from drowning so it cannot be prevented
        player.attackEntityFrom(DamageSource.drown, ConfigurationHandler.damagePerInterval);
    }
}
