package net.expo.expotech.util;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class SocketUtils {

    public static final String SOCKETS_KEY = "Sockets";

    public static void addEmptySockets(ItemStack stack, int amount) {
        CompoundTag tag = stack.getOrCreateTag();
        if (tag.contains(SOCKETS_KEY)) return; // already has sockets

        ListTag socketList = new ListTag();

        for (int i = 0; i < amount; i++) {
            CompoundTag socket = new CompoundTag();
            socket.putString("Gem", "empty");
            socketList.add(socket);
        }

        tag.put(SOCKETS_KEY, socketList);
    }

    public static ListTag getSockets(ItemStack stack) {
        CompoundTag tag = stack.getOrCreateTag();
        if (!tag.contains(SOCKETS_KEY)) return new ListTag();
        return tag.getList(SOCKETS_KEY, Tag.TAG_COMPOUND);
    }

    public static boolean hasGem(ItemStack stack, String gemId) {
        ListTag sockets = getSockets(stack);
        for (Tag tag : sockets) {
            if (tag instanceof CompoundTag compound) {
                if (compound.getString("Gem").equals(gemId)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static List<String> getGems(ItemStack stack) {
        List<String> gems = new ArrayList<>();
        ListTag sockets = getSockets(stack);
        for (int i = 0; i < sockets.size(); i++) {
            CompoundTag socket = sockets.getCompound(i);
            if (socket.contains("Gem")) {
                gems.add(socket.getString("Gem"));
            }
        }
        return gems;
    }


    public static void setSocket(ItemStack stack, int index, String gemId) {
        ListTag sockets = getSockets(stack);
        if (index >= sockets.size()) return;

        CompoundTag socket = sockets.getCompound(index);
        socket.putString("Gem", gemId);
    }

    private static final Set<String> VALID_GEMS = Set.of(
            "expotech:opal_gem",
            "expotech:malachite_gem",
            "expotech:peridot_gem",
            "expotech:amber_gem",
            "expotech:aquamarine_gem",
            "expotech:kyanite_gem",
            "expotech:tourmaline_gem",
            "expotech:citrine_gem",
            "expotech:amethyst_gem",
            "expotech:topaz_gem"
    );

    public static boolean isGemItem(ItemStack stack) {
        if (stack == null || stack.isEmpty()) return false;
        return VALID_GEMS.contains(ForgeRegistries.ITEMS.getKey(stack.getItem()).toString());
    }




    /**
     * Returns a simplified ID like "opal" from the item ID "expotech:opal_gem"
     */
    public static String getGemId(ItemStack stack) {
        String fullId = ForgeRegistries.ITEMS.getKey(stack.getItem()).getPath(); // "opal_gem"
        return fullId.replace("_gem", ""); // -> "opal"
    }

    /**
     * Inserts a gem into the first empty socket in the armor piece. Returns true if successful.
     */
    public static boolean insertGem(ItemStack armor, ItemStack gem) {
        if (!isGemItem(gem)) return false;

        ListTag sockets = getSockets(armor);
        for (int i = 0; i < sockets.size(); i++) {
            CompoundTag socket = sockets.getCompound(i);
            if (socket.getString("Gem").equals("empty")) {
                socket.putString("Gem", getGemId(gem));
                return true;
            }
        }

        return false; // no empty socket found
    }
    public static boolean hasGemInArmor(Player player, String gemId) {
        for (ItemStack stack : player.getArmorSlots()) {
            if (hasGem(stack, gemId)) {
                return true;
            }
        }
        return false;
    }

}

