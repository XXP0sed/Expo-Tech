package net.expo.expotech.util;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;
import java.util.Random;

@Mod.EventBusSubscriber
public class TourmalineIntegration {
    private static final Random RANDOM = new Random();

    @SubscribeEvent
    public static void onPlayerDamaged(LivingHurtEvent event) {
        if (!(event.getEntity() instanceof Player player)) return;

        int gemCount = 0;
        for (ItemStack armor : player.getArmorSlots()) {
            List<String> gems = SocketUtils.getGems(armor);
            for (String gem : gems) {
                if (gem.equals("tourmaline")) {
                    gemCount++;
                }
            }
        }

        if (gemCount == 0) return;

        float projectileChance = 0.05f + 0.05f * (gemCount - 1);
        if (event.getSource().getDirectEntity() instanceof net.minecraft.world.entity.projectile.Projectile
                && RANDOM.nextFloat() < projectileChance) {
            event.setCanceled(true);
            return;
        }

        float retaliateChance = 0.15f + 0.05f * (gemCount - 1);
        if (RANDOM.nextFloat() < retaliateChance && event.getSource().getEntity() instanceof LivingEntity attacker) {
            attacker.hurt(player.damageSources().thorns(player), 2.0f);
        }
    }

}

