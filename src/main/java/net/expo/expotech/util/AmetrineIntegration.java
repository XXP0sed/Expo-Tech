package net.expo.expotech.util;

import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;
import java.util.UUID;

@Mod.EventBusSubscriber
public class AmetrineIntegration {

    private static final UUID AMETRINE_TOUGHNESS_UUID = UUID.fromString("0d4c1a60-25b3-4c3d-b1c8-871e3a01d36f");

    public static void updateToughnessBonus(Player player) {
        double bonus = 0.0;
        for (ItemStack armor : player.getArmorSlots()) {
            List<String> gems = SocketUtils.getGems(armor);
            for (String gem : gems) {
                if (gem.equals("ametrine")) {
                    bonus += 0.5;
                }
            }
        }

        if (player.getAttribute(Attributes.ARMOR_TOUGHNESS).getModifier(AMETRINE_TOUGHNESS_UUID) != null) {
            player.getAttribute(Attributes.ARMOR_TOUGHNESS).removeModifier(AMETRINE_TOUGHNESS_UUID);
        }

        if (bonus > 0.0) {
            AttributeModifier modifier = new AttributeModifier(
                    AMETRINE_TOUGHNESS_UUID, "ametrine_toughness", bonus, AttributeModifier.Operation.ADDITION
            );
            player.getAttribute(Attributes.ARMOR_TOUGHNESS).addTransientModifier(modifier);
        }
    }

    @SubscribeEvent
    public static void onBreakSpeed(PlayerEvent.BreakSpeed event) {
        Player player = event.getEntity();
        if (player == null) return;

        int ametrineCount = 0;
        for (ItemStack armor : player.getArmorSlots()) {
            List<String> gems = SocketUtils.getGems(armor);
            for (String gem : gems) {
                if (gem.equals("ametrine")) {
                    ametrineCount++;
                }
            }
        }

        if (ametrineCount > 0) {
            float bonus = event.getOriginalSpeed() * (ametrineCount * 0.08f);
            event.setNewSpeed(event.getOriginalSpeed() + bonus);
        }
    }
}

