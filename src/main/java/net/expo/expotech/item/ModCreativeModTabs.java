package net.expo.expotech.item;

import net.expo.expotech.Expotech;
import net.expo.expotech.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Expotech.MOD_ID);

    public static final RegistryObject<CreativeModeTab> expotech_tab = CREATIVE_MODE_TABS.register("expotech_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.MALACHITE.get()))
                    .title(Component.translatable("ExpoTech"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.MALACHITE.get());
                        output.accept(ModItems.OPAL.get());
                        output.accept(ModItems.CITRINE.get());
                        output.accept(ModItems.AGATE.get());
                        output.accept(ModItems.PERIDOT.get());
                        output.accept(ModItems.AMETRINE.get());
                        output.accept(ModItems.ONYX.get());
                        output.accept(ModItems.KYANITE.get());
                        output.accept(ModItems.TOURMALINE.get());
                        output.accept(ModItems.AQUAMARINE.get());
                        output.accept(ModItems.TOPAZ.get());
                        output.accept(ModItems.RAW_MALACHITE.get());
                        output.accept(ModItems.RAW_KYANITE.get());
                        output.accept(ModItems.RAW_AQUAMARINE.get());
                        output.accept(ModItems.RAW_AGATE.get());
                        output.accept(ModItems.RAW_TOPAZ.get());
                        output.accept(ModItems.RAW_AMBER.get());
                        output.accept(ModItems.RAW_PERIDOT.get());
                        output.accept(ModItems.RAW_CITRINE.get());
                        output.accept(ModItems.RAW_TOURMALINE.get());
                        output.accept(ModItems.RAW_OPAL.get());
                        output.accept(ModItems.RAW_AMETRINE.get());
                        output.accept(ModItems.RAW_ONYX.get());
                        output.accept(ModItems.SCORIA_CHUNK.get());
                        output.accept(ModItems.SCORIA_BAR.get());
                        output.accept(ModItems.UNPOLISHED_AMMOLITE.get());
                        output.accept(ModItems.AMMOLITE.get());

                        output.accept(ModItems.OPAL_GEM.get());
                        output.accept(ModItems.MALACHITE_GEM.get());
                        output.accept(ModItems.PERIDOT_GEM.get());
                        output.accept(ModItems.TOPAZ_GEM.get());
                        output.accept(ModItems.AMBER_GEM.get());
                        output.accept(ModItems.AQUAMARINE_GEM.get());
                        output.accept(ModItems.KYANITE_GEM.get());
                        output.accept(ModItems.TOURMALINE_GEM.get());
                        output.accept(ModItems.CITRINE_GEM.get());
                        output.accept(ModItems.AMETHYST_GEM.get());
                        output.accept(ModItems.AMETRINE_GEM.get());
                        output.accept(ModItems.ONYX_GEM.get());
                        output.accept(ModItems.AMMOLITE_GEM.get());

                        output.accept(ModItems.COKE.get());

                        output.accept(ModBlocks.AGATE_ORE.get());
                        output.accept(ModBlocks.AMBER_ORE.get());
                        output.accept(ModBlocks.MALACHITE_ORE.get());
                        output.accept(ModBlocks.TOPAZ_ORE.get());
                        output.accept(ModBlocks.TOURMALINE_ORE.get());
                        output.accept(ModBlocks.KYANITE_ORE.get());
                        output.accept(ModBlocks.AQUAMARINE_ORE.get());
                        output.accept(ModBlocks.NETHER_OPAL_ORE.get());
                        output.accept(ModBlocks.AMETRINE_ORE.get());
                        output.accept(ModBlocks.CITRINE_ORE.get());
                        output.accept(ModBlocks.ONYX_ORE.get());
                        output.accept(ModBlocks.PERIDOT_ORE.get());
                        output.accept(ModBlocks.SCORIA.get());
                        output.accept(ModBlocks.AMMOLITE_ORE.get());
                        output.accept(ModBlocks.MOSSY_MUD.get());
                        output.accept(ModBlocks.MOSSY_MUD_IRON_ORE.get());
                        output.accept(ModBlocks.MOSSY_MUD_GOLD_ORE.get());
                        output.accept(ModBlocks.MUD_GOLD_ORE.get());
                        output.accept(ModBlocks.MUDSTONE_GOLD_ORE.get());
                        output.accept(ModBlocks.MUDSTONE.get());
                        output.accept(ModBlocks.MARBLE.get());
                        output.accept(ModBlocks.MARBLE_BLOCK.get());
                        output.accept(ModBlocks.LARVIKITE.get());
                        output.accept(ModBlocks.MUD_IRON_ORE.get());
                        output.accept(ModBlocks.MUD_EMERALD_ORE.get());

                        output.accept(ModBlocks.COKE_BLOCK.get());
                        output.accept(ModBlocks.BRONZE_SEARED_BRICKS.get());
                        output.accept(ModBlocks.TUFF_HEAT_DAMPENER.get());

                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
