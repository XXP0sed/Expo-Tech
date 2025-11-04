package net.dorsz.dorszpackmod.util;

import net.dorsz.dorszpackmod.entity.ModEntities;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.AABB;

import java.util.List;
import java.util.UUID;

public class AmethystIntegration {

    // Unique UUIDs for each level of bonus
    private static final UUID[] AMETHYST_TOUGHNESS_UUIDS = new UUID[] {
            UUID.fromString("d2299ab9-aff5-41c6-8574-44265cdd9eac"),
            UUID.fromString("d979e9ad-bfa3-4964-b192-212a368747eb"),
            UUID.fromString("cf766320-92bb-442b-8f97-92e3a9ab1bac"),
            UUID.fromString("fcd61db4-c7b4-47ca-96b4-8c765c1d75e9")
    };

    public static void updateAmethystEffects(Player player) {
        if (!(player instanceof ServerPlayer serverPlayer)) return;

        // Count Amethyst gems
        int count = 0;
        for (ItemStack armor : player.getArmorSlots()) {
            List<String> gems = SocketUtils.getGems(armor);
            for (String gem : gems) {
                if (gem.equals("amethyst")) {
                    count++;
                }
            }
        }

        // Manage toughness modifiers
        for (int i = 0; i < 4; i++) {
            if (player.getAttribute(Attributes.ARMOR_TOUGHNESS).getModifier(AMETHYST_TOUGHNESS_UUIDS[i]) != null) {
                player.getAttribute(Attributes.ARMOR_TOUGHNESS).removeModifier(AMETHYST_TOUGHNESS_UUIDS[i]);
            }
        }

        if (count > 0) {
            double bonus = switch (count) {
                case 1 -> 0.25;
                case 2 -> 0.5;
                case 3 -> 1.0;
                default -> 1.5;
            };

            double[] split = switch (count) {
                case 1 -> new double[] {0.25};
                case 2 -> new double[] {0.25, 0.25};
                case 3 -> new double[] {0.25, 0.25, 0.5};
                case 4 -> new double[] {1, 1, 1, 1};
                default -> new double[0];
            };

            for (int i = 0; i < split.length; i++) {
                player.getAttribute(Attributes.ARMOR_TOUGHNESS).addTransientModifier(
                        new AttributeModifier(AMETHYST_TOUGHNESS_UUIDS[i], "amethyst_bonus_" + i, split[i], AttributeModifier.Operation.ADDITION)
                );
            }
        }
    }
}

