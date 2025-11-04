package net.dorsz.dorszpackmod.util;

import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

import java.util.List;
import java.util.UUID;

public class TopazIntegration {

    private static final UUID TOPAZ_BONUS_UUID = UUID.fromString("c6d1a3fc-3f5f-4df3-908d-0aee1b8f4fcd");

    public static void updateTopazBonus(Player player) {
        double resistance = 0.0;

        for (ItemStack armor : player.getArmorSlots()) {
            List<String> gems = SocketUtils.getGems(armor);
            long count = gems.stream().filter(gem -> gem.equals("topaz")).count();
            if (count > 0) {
                resistance += 0.12 + (count - 1) * 0.05;
            }
        }

        // Remove old modifier if it exists
        if (player.getAttribute(Attributes.KNOCKBACK_RESISTANCE).getModifier(TOPAZ_BONUS_UUID) != null) {
            player.getAttribute(Attributes.KNOCKBACK_RESISTANCE).removeModifier(TOPAZ_BONUS_UUID);
        }

        if (resistance > 0.0) {
            AttributeModifier modifier = new AttributeModifier(
                    TOPAZ_BONUS_UUID,
                    "topaz_bonus",
                    resistance,
                    AttributeModifier.Operation.ADDITION
            );
            player.getAttribute(Attributes.KNOCKBACK_RESISTANCE).addTransientModifier(modifier);
        }
    }
}

