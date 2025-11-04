package net.dorsz.dorszpackmod.util;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class PeridotIntegration {

    private static final Map<UUID, Integer> tickCounters = new HashMap<>();

    public static void init() {
        MinecraftForge.EVENT_BUS.register(PeridotIntegration.class);
    }

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.phase != TickEvent.Phase.END || event.player == null || event.player.level().isClientSide) return;

        Player player = event.player;
        UUID playerId = player.getUUID();

        int peridotCount = 0;
        for (ItemStack armor : player.getArmorSlots()) {
            List<String> gems = SocketUtils.getGems(armor);
            for (String gem : gems) {
                if (gem.equals("peridot")) {
                    peridotCount++;
                }
            }
        }

        if (peridotCount == 0) {
            tickCounters.remove(playerId);
            return;
        }

        int interval = Math.max(20, 180 - (peridotCount * 20)); // 10s down to 1s
        int ticks = tickCounters.getOrDefault(playerId, 0) + 1;

        if (ticks >= interval) {
            if (player.getHealth() < player.getMaxHealth()) {
                player.heal(1.0F); // 0.5 heart = 1 HP
            }
            ticks = 0;
        }

        tickCounters.put(playerId, ticks);
    }
}


