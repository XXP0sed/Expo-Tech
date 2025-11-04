package net.expo.expotech.event;


import net.expo.expotech.util.*;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "expotech", bus = Mod.EventBusSubscriber.Bus.FORGE)
public class SocketBonusHandler {

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.phase != TickEvent.Phase.END || event.player == null) return;

        OpalIntegration.updateCritBonus(event.player);
        PeridotIntegration.init();
        TopazIntegration.updateTopazBonus(event.player);
        AquamarineIntegration.updateAquamarineBreathing(event.player);
        KyaniteIntegration.updateKyaniteBonus(event.player);


    }

    public static void onBreakSpeed(PlayerEvent.BreakSpeed event) {
        CitrineIntegration.onBreakSpeed(event);
    }
    @SubscribeEvent
    public static void onClientTick(TickEvent.ClientTickEvent event) {
        Minecraft mc = Minecraft.getInstance();
        Player player = mc.player;
        if (player == null) return;


    }

}


