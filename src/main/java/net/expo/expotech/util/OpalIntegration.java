package net.expo.expotech.util;

import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.randomcrits.init.RandomCritsModAttributes;

import java.util.List;
import java.util.UUID;

public class OpalIntegration {

    private static final UUID OPAL_BONUS_UUID = UUID.fromString("c3a4b5e6-1234-4f6a-8c3a-a7b5a5f6d7e8");

    public static void updateCritBonus(Player player) {
        if (!RandomCritsModAttributes.CRITCHANCE.isPresent()) return;

        Attribute critChanceAttr = RandomCritsModAttributes.CRITCHANCE.get();
        if (player.getAttribute(critChanceAttr) == null) return;

        double bonus = 0.0;

        for (ItemStack armor : player.getArmorSlots()) {
            List<String> gems = SocketUtils.getGems(armor);
            for (String gem : gems) {
                if (gem.equals("opal")) {
                    bonus += 0.05; // 5% per opal
                }
            }
        }

        var attrInstance = player.getAttribute(critChanceAttr);

        if (attrInstance.getModifier(OPAL_BONUS_UUID) != null) {
            attrInstance.removeModifier(OPAL_BONUS_UUID);
        }

        if (bonus > 0.0) {
            AttributeModifier modifier = new AttributeModifier(
                    OPAL_BONUS_UUID,
                    "Opal Crit Chance Bonus",
                    bonus,
                    AttributeModifier.Operation.ADDITION
            );
            attrInstance.addTransientModifier(modifier);
        }
    }
}


