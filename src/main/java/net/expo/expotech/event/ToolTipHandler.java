package net.expo.expotech.event;

import net.expo.expotech.util.SocketUtils;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

@Mod.EventBusSubscriber(modid = "expotech", value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ToolTipHandler {

    @SubscribeEvent
    public static void onItemTooltip(ItemTooltipEvent event) {
        Player player = event.getEntity();
        if (player == null) return;

        ItemStack stack = event.getItemStack();
        List<Component> tooltip = event.getToolTip();
        boolean isTool = isToolOrRanged(stack);

        int opalCount = 0;
        int malachiteCount = 0;
        int peridotCount = 0;
        int topazCount = 0;
        int amberCount = 0;
        int aquamarineCount = 0;
        int kyaniteCount = 0;
        int tourmalineCount = 0;
        int citrineCount = 0;
        int amethystCount = 0;
        int ametrineCount = 0;

        for (ItemStack armor : player.getArmorSlots()) {
            List<String> gems = SocketUtils.getGems(armor);
            for (String gem : gems) {
                switch (gem) {
                    case "opal" -> opalCount++;
                    case "malachite" -> malachiteCount++;
                    case "peridot" -> peridotCount++;
                    case "topaz" -> topazCount++;
                    case "amber" -> amberCount++;
                    case "aquamarine" -> aquamarineCount++;
                    case "kyanite" -> kyaniteCount++;
                    case "tourmaline" -> tourmalineCount++;
                    case "citrine" -> citrineCount++;
                    case "amethyst" -> amethystCount++;
                    case "ametrine" -> ametrineCount++;
                }
            }
        }

        if (opalCount > 0 && (isTool || hasGems(stack, "opal"))) {
            double critBonus = opalCount * 5.0;
            tooltip.add(Component.literal("OPAL: Crit Chance Bonus: +" + critBonus + "%")
                    .withStyle(ChatFormatting.WHITE));
        }

        if (malachiteCount > 0 && (isTool || hasGems(stack, "malachite"))) {
            double dmgBonus = malachiteCount * 0.5;
            tooltip.add(Component.literal("MALACHITE: Attack Damage Bonus: +" + dmgBonus)
                    .withStyle(ChatFormatting.DARK_GREEN));
        }

        if (peridotCount > 0 && (isTool || hasGems(stack, "peridot"))) {
            int intervalTicks = Math.max(20, 180 - (topazCount * 20)); // Minimum 20 ticks = 1 sec
            double seconds = intervalTicks / 20.0;
            tooltip.add(Component.literal("PERIDOT: Heals 0.5❤ every " + seconds + "s")
                    .withStyle(ChatFormatting.GREEN));
        }
        if (topazCount > 0 && (isTool || hasGems(stack, "topaz"))) {
            double knockbackReduction = 12.0 + (topazCount - 1) * 5.0;
            tooltip.add(Component.literal("TOPAZ: Knockback Resistance Bonus: -" + knockbackReduction + "%")
                    .withStyle(ChatFormatting.GOLD));
        }
        if (amberCount > 0 && (isTool || hasGems(stack, "amber"))) {
            double chance = 10.0 + (amberCount - 1) * 5;
            if (chance > 25) chance = 25;
            tooltip.add(Component.literal("AMBER: " + String.format("%.1f", chance) + "% chance to heal 1 heart on healing")
                    .withStyle(ChatFormatting.GOLD));
        }
        if (aquamarineCount > 0 && (isTool || hasGems(stack, "aquamarine"))) {
            int bonusSeconds = 5 + (aquamarineCount - 1) * 1;
            tooltip.add(Component.literal("AQUAMARINE: +" + bonusSeconds + "s Underwater Breathing")
                    .withStyle(ChatFormatting.DARK_AQUA));
        }
        if (kyaniteCount > 0 && (isTool || hasGems(stack, "kyanite"))) {
            double speedBonus = kyaniteCount == 1 ? 6.0 : 6.0 + (kyaniteCount - 1) * 3.0;
            tooltip.add(Component.literal("KYANITE: Movement Speed Bonus: +" + speedBonus + "%")
                    .withStyle(ChatFormatting.BLUE));
        }
        if (tourmalineCount > 0 && (isTool || hasGems(stack, "tourmaline"))) {
            float thornsChance = 15f + 5f * (tourmalineCount - 1);
            float projectileNegate = 5f + 5f * (tourmalineCount - 1);

            tooltip.add(Component.literal("TOURMALINE: " +
                            String.format("✹ %s%% Retaliation Chance", thornsChance))
                    .withStyle(ChatFormatting.RED));
            tooltip.add(Component.literal("                 " +
                            String.format("✦ %s%% Projectile Negation", projectileNegate))
                    .withStyle(ChatFormatting.GREEN));
        }
        if (citrineCount > 0 && (isTool || hasGems(stack, "citrine"))) {
            int[] bonuses = {7, 9, 11, 13}; // % bonuses for each gem
            int bonus = 0;
            for (int i = 0; i < Math.min(citrineCount, bonuses.length); i++) {
                bonus += bonuses[i];
            }

            tooltip.add(Component.literal("CITRINE: Digging Speed Bonus: +" + bonus + "%")
                    .withStyle(ChatFormatting.YELLOW));
        }
        if (amethystCount > 0 && (isTool || hasGems(stack, "amethyst"))) {
            double toughnessBonus =
                    amethystCount >= 4 ? 4 :
                            amethystCount == 3 ? 1.0 :
                                    amethystCount == 2 ? 0.5 :
                                            0.25;

            tooltip.add(Component.literal("AMETHYST: +" + toughnessBonus + " Armor Toughness")
                    .withStyle(ChatFormatting.LIGHT_PURPLE));

        }
        if (ametrineCount > 0 && (isToolOrRanged(stack) || hasGems(stack, "ametrine"))) {
            double toughnessBonus = ametrineCount * 0.5;
            int breakSpeedBonus = ametrineCount * 8;

            tooltip.add(Component.literal("AMETRINE: Armor Toughness Bonus: +" + toughnessBonus)
                    .withStyle(ChatFormatting.LIGHT_PURPLE));
            tooltip.add(Component.literal("AMETRINE: Breaking Speed Bonus: +" + breakSpeedBonus + "%")
                    .withStyle(ChatFormatting.YELLOW));
        }









        // Empty socket indicator for armor
        if (isArmor(stack)) {
            List<String> gems = SocketUtils.getGems(stack);
            if (!gems.isEmpty() && gems.stream().allMatch(gem -> gem.equals("empty"))) {
                tooltip.add(Component.literal("Socket Slot: Empty").withStyle(ChatFormatting.GRAY));
            }
        }
    }

    private static boolean isToolOrRanged(ItemStack stack) {
        Item item = stack.getItem();
        return item instanceof SwordItem || item instanceof BowItem || item instanceof CrossbowItem ||
                item instanceof DiggerItem;
    }

    private static boolean isArmor(ItemStack stack) {
        return stack.getItem() instanceof ArmorItem;
    }

    private static boolean hasGems(ItemStack stack, String gem) {
        if (!stack.hasTag()) return false;
        return SocketUtils.getGems(stack).contains(gem);
    }
}
