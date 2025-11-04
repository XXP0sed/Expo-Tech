package net.dorsz.dorszpackmod;

import com.mojang.logging.LogUtils;
import net.dorsz.dorszpackmod.block.ModBlocks;


import net.dorsz.dorszpackmod.entity.ModEntities;
import net.dorsz.dorszpackmod.item.ModCreativeModTabs;
import net.dorsz.dorszpackmod.item.ModItems;
import net.dorsz.dorszpackmod.util.SocketUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import software.bernie.geckolib.GeckoLib;


// The value here should match an entry in the META-INF/mods.toml file
@Mod(DorszpackMod.MOD_ID)
public class DorszpackMod {
    public static final String MOD_ID = "dorszpackmod";
    private static final Logger LOGGER = LogUtils.getLogger();

    public DorszpackMod() {

        GeckoLib.initialize();

        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModCreativeModTabs.register(modEventBus);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);


        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::onCommonSetup);

        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);

        MinecraftForge.EVENT_BUS.register(this);

        // Setup phase
        MinecraftForge.EVENT_BUS.register(this);



    }

    private void commonSetup(final FMLCommonSetupEvent event) {


    }

    private void onCommonSetup(final FMLCommonSetupEvent event) {
        MinecraftForge.EVENT_BUS.addListener(this::onCommandRegister);
    }

    private void onCommandRegister(RegisterCommandsEvent event) {

    }




    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ModItems.MALACHITE);
            event.accept(ModItems.RAW_MALACHITE);
            event.accept(ModItems.RAW_TOPAZ);
            event.accept(ModItems.RAW_AGATE);
            event.accept(ModItems.RAW_AQUAMARINE);
            event.accept(ModItems.RAW_OPAL);
            event.accept(ModItems.RAW_AMETRINE);
            event.accept(ModItems.RAW_TOURMALINE);
            event.accept(ModItems.RAW_AMBER);
            event.accept(ModItems.RAW_PERIDOT);
            event.accept(ModItems.RAW_KYANITE);
            event.accept(ModItems.RAW_CITRINE);
        }
    }
    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
        // Do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            // Some client setup code
            LOGGER.info("HELLO FROM CLIENT SETUP");
            LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());

        }
    }
    @Mod.EventBusSubscriber(modid = "dorszpackmod", bus = Mod.EventBusSubscriber.Bus.FORGE)
    public class SocketEvents {

        @SubscribeEvent
        public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
            if (event.phase != TickEvent.Phase.END) return;

            Player player = event.player;
            for (ItemStack armor : player.getArmorSlots()) {
                if (armor.getItem() instanceof ArmorItem) {
                    CompoundTag tag = armor.getOrCreateTag();
                    if (!tag.contains(SocketUtils.SOCKETS_KEY)) {
                        SocketUtils.addEmptySockets(armor, 1);
                    }
                }
            }
        }
    }

}
