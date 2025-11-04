package net.dorsz.dorszpackmod.util;

import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

import java.util.List;
import java.util.UUID;

public class KyaniteIntegration {

    private static final UUID KYANITE_BONUS_UUID = UUID.fromString("e58fdc4d-ca46-41fc-b881-d48fba12b4fd");

    public static void updateKyaniteBonus(Player player) {
        double bonus = 0.0;

        for (ItemStack armor : player.getArmorSlots()) {
            List<String> gems = SocketUtils.getGems(armor);
            for (String gem : gems) {
                if (gem.equals("kyanite")) {
                    bonus += (bonus == 0.0) ? 0.06 : 0.03; // First gem gives 8%, then 4% each
                }
            }
        }

        if (player.getAttribute(Attributes.MOVEMENT_SPEED).getModifier(KYANITE_BONUS_UUID) != null) {
            player.getAttribute(Attributes.MOVEMENT_SPEED).removeModifier(KYANITE_BONUS_UUID);
        }

        if (bonus > 0.0) {
            AttributeModifier modifier = new AttributeModifier(
                    KYANITE_BONUS_UUID, "kyanite_speed_bonus", bonus, AttributeModifier.Operation.MULTIPLY_TOTAL
            );
            player.getAttribute(Attributes.MOVEMENT_SPEED).addTransientModifier(modifier);
        }
    }
}

