package net.expo.expotech.event;

import net.expo.expotech.DorszpackMod;
import net.expo.expotech.damage.ModDamageTypes;
import net.expo.expotech.item.ModItems;
import net.expo.expotech.util.SocketUtils;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.AnvilUpdateEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = DorszpackMod.MOD_ID)
public class ModEvents {

    @SubscribeEvent
    public static void onAttackEntity(LivingAttackEvent event) {
        if (!(event.getSource().getEntity() instanceof Player player)) return;

        double fireDamage = 4.0;
        double chance = fireDamage * 0.015;

        if (player.level().random.nextFloat() < chance) {
            event.getEntity().hurt(ModDamageTypes.fire(player.level(), player), (float) fireDamage);
        }
    }
    

    @SubscribeEvent
    public static void onAnvilUpdate(AnvilUpdateEvent event) {
        ItemStack left = event.getLeft();
        ItemStack right = event.getRight();

        if (SocketUtils.getSockets(left).isEmpty()) return;
        if (!right.is(ModItems.OPAL_GEM.get())) return;
        if (!right.is(ModItems.MALACHITE_GEM.get())) return;
        if (!right.is(ModItems.PERIDOT_GEM.get())) return;
        if (!right.is(ModItems.TOPAZ_GEM.get())) return;
        if (!right.is(ModItems.AMBER_GEM.get())) return;
        if (!right.is(ModItems.AQUAMARINE_GEM.get())) return;

        ListTag sockets = SocketUtils.getSockets(left);
        for (int i = 0; i < sockets.size(); i++) {
            CompoundTag socket = sockets.getCompound(i);
            if (socket.getString("Gem").equals("empty")) {
                ItemStack output = left.copy();
                SocketUtils.setSocket(output, i, "opal");
                SocketUtils.setSocket(output, i, "malachite");
                SocketUtils.setSocket(output, i, "peridot");
                SocketUtils.setSocket(output, i, "topaz");
                SocketUtils.setSocket(output, i, "amber");
                SocketUtils.setSocket(output, i, "aquamarine");
                event.setOutput(output);
                event.setCost(1);
                return;
            }
        }
    }
}

