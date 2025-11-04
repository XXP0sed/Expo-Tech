package net.expo.expotech.event;

import net.expo.expotech.item.ModItems;
import net.expo.expotech.util.SocketUtils;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ArmorItem;
import net.minecraftforge.event.AnvilUpdateEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "dorszpackmod", bus = Mod.EventBusSubscriber.Bus.FORGE)
public class SocketAnvilHandler {

    @SubscribeEvent
    public static void onAnvilUpdate(AnvilUpdateEvent event) {
        ItemStack left = event.getLeft();
        ItemStack right = event.getRight();

        if (left == null || right == null) return;

        if (left.getItem() instanceof ArmorItem && isGemItem(right)) {
            String gemId = getGemId(right.getItem());
            if (gemId == null) return;

            ItemStack output = left.copy();
            SocketUtils.addEmptySockets(output, 1); // If not already added
            SocketUtils.setSocket(output, 0, gemId); // Set socket 0 for example



            event.setOutput(output);
            event.setCost(4);
            event.setMaterialCost(1);
        }
    }

    private static boolean isGemItem(ItemStack stack) {
        return getGemId(stack.getItem()) != null;
    }

    private static String getGemId(Item item) {
        if (item == ModItems.OPAL_GEM.get()) return "opal";
        if (item == ModItems.MALACHITE_GEM.get()) return "malachite";
        if (item == ModItems.PERIDOT_GEM.get()) return "peridot";
        if (item == ModItems.TOPAZ_GEM.get()) return "topaz";
        if (item == ModItems.AMBER_GEM.get()) return "amber";
        if (item == ModItems.AQUAMARINE_GEM.get()) return "aquamarine";
        if (item == ModItems.KYANITE_GEM.get()) return "kyanite";
        if (item == ModItems.TOURMALINE_GEM.get()) return "tourmaline";
        if (item == ModItems.CITRINE_GEM.get()) return "citrine";
        if (item == ModItems.AMETHYST_GEM.get()) return "amethyst";
        if (item == ModItems.AMETRINE_GEM.get()) return "ametrine";
        return null;
    }

    private static String capitalize(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

}
