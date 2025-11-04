package net.dorsz.dorszpackmod.util;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.entity.player.PlayerEvent.BreakSpeed;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

@Mod.EventBusSubscriber
public class CitrineIntegration {

    @SubscribeEvent
    public static void onBreakSpeed(BreakSpeed event) {
        Player player = event.getEntity();
        if (player == null) return;

        int citrineCount = 0;
        for (ItemStack armor : player.getArmorSlots()) {
            List<String> gems = SocketUtils.getGems(armor);
            for (String gem : gems) {
                if (gem.equals("citrine")) {
                    citrineCount++;
                }
            }
        }

        float originalSpeed = event.getOriginalSpeed();
        float bonusMultiplier = 1.0f;

        // Apply bonus based on number of citrine gems
        switch (citrineCount) {
            case 1 -> bonusMultiplier += 0.07f;
            case 2 -> bonusMultiplier += 0.09f;
            case 3 -> bonusMultiplier += 0.11f;
            case 4 -> bonusMultiplier += 0.13f;
        }

        if (citrineCount > 0) {
            event.setNewSpeed(originalSpeed * bonusMultiplier);
        }
    }
}


