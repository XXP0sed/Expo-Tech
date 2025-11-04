package net.expo.expotech.util;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

import java.util.List;

public class AquamarineIntegration {

    // Vanilla max air = 300 ticks = 15s
    private static final int BASE_AIR = 300;

    public static void updateAquamarineBreathing(Player player) {
        int aquamarineCount = 0;

        for (ItemStack armor : player.getArmorSlots()) {
            List<String> gems = SocketUtils.getGems(armor);
            for (String gem : gems) {
                if ("aquamarine".equals(gem)) {
                    aquamarineCount++;
                }
            }
        }

        int bonusAir = 0;
        if (aquamarineCount > 0) {
            bonusAir = 100 + ((aquamarineCount - 1) * 20); // +5s, +1s per additional
        }

        int maxAir = BASE_AIR + bonusAir;

        // If bonusAir is applied, only *increase* air when above water or just entered water
        if (bonusAir > 0) {
            if (!player.isUnderWater()) {
                // When above water, refill full extended air
                if (player.getAirSupply() < maxAir) {
                    player.setAirSupply(maxAir);
                }
            } else {
                // Underwater: clamp to maxAir if needed, but do NOT refill
                if (player.getAirSupply() > maxAir) {
                    player.setAirSupply(maxAir);
                }
            }
        }
    }
}











