package net.expo.expotech.util;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingHealEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;
import java.util.Random;

@Mod.EventBusSubscriber
public class AmberIntegration {

    private static final Random random = new Random();

    @SubscribeEvent
    public static void onPlayerHeal(LivingHealEvent event) {
        if (!(event.getEntity() instanceof Player player)) return;

        int amberCount = 0;

        for (ItemStack armor : player.getArmorSlots()) {
            List<String> gems = SocketUtils.getGems(armor);
            for (String gem : gems) {
                if (gem.equals("amber")) {
                    amberCount++;
                }
            }
        }

        if (amberCount == 0) return;

        double chance = 10.0 + (amberCount - 1) * 5;
        if (chance > 25) chance = 25;

        if (random.nextDouble() < (chance / 100.0)) {
            player.heal(2.0F); // 2.0 = 1 heart
        }
    }
}

