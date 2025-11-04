package net.dorsz.dorszpackmod.util;

import net.dorsz.dorszpackmod.util.SocketUtils;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

@Mod.EventBusSubscriber(modid = "dorszpackmod", bus = Mod.EventBusSubscriber.Bus.FORGE)
public class MalachiteIntegration {

    @SubscribeEvent
    public static void onLivingHurt(LivingHurtEvent event) {
        if (!(event.getSource().getEntity() instanceof Player player)) return;

        int malachiteCount = 0;
        for (ItemStack armor : player.getArmorSlots()) {
            List<String> gems = SocketUtils.getGems(armor);
            for (String gem : gems) {
                if (gem.equals("malachite")) {
                    malachiteCount++;
                }
            }
        }

        if (malachiteCount > 0) {
            float bonus = (float) (malachiteCount * 0.5);
            event.setAmount(event.getAmount() + bonus);
        }
    }
}

