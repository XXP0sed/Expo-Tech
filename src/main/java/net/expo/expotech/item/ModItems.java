package net.expo.expotech.item;

import net.expo.expotech.Expotech;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Expotech.MOD_ID);

    public static final RegistryObject<Item> MALACHITE = ITEMS.register("malachite",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> OPAL = ITEMS.register("opal",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CITRINE = ITEMS.register("citrine",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ONYX = ITEMS.register("onyx",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> KYANITE = ITEMS.register("kyanite",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> TOPAZ = ITEMS.register("topaz",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> AGATE = ITEMS.register("agate",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PERIDOT = ITEMS.register("peridot",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> AQUAMARINE = ITEMS.register("aquamarine",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> TOURMALINE = ITEMS.register("tourmaline",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> AMETRINE= ITEMS.register("ametrine",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_MALACHITE = ITEMS.register("raw_malachite",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_TOPAZ = ITEMS.register("raw_topaz",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_AMBER = ITEMS.register("raw_amber",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_AGATE = ITEMS.register("raw_agate",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_KYANITE = ITEMS.register("raw_kyanite",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_PERIDOT = ITEMS.register("raw_peridot",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_CITRINE = ITEMS.register("raw_citrine",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_ONYX = ITEMS.register("raw_onyx",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_OPAL = ITEMS.register("raw_opal",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_AMETRINE = ITEMS.register("raw_ametrine",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_TOURMALINE = ITEMS.register("raw_tourmaline",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_AQUAMARINE = ITEMS.register("raw_aquamarine",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SCORIA_CHUNK = ITEMS.register("scoria_chunk",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SCORIA_BAR = ITEMS.register("scoria_bar",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> UNPOLISHED_AMMOLITE = ITEMS.register("unpolished_ammolite",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> AMMOLITE = ITEMS.register("ammolite",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> OPAL_GEM = ITEMS.register("opal_gem",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> MALACHITE_GEM = ITEMS.register("malachite_gem",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PERIDOT_GEM = ITEMS.register("peridot_gem",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> TOPAZ_GEM = ITEMS.register("topaz_gem",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> AMBER_GEM = ITEMS.register("amber_gem",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> AQUAMARINE_GEM = ITEMS.register("aquamarine_gem",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> KYANITE_GEM = ITEMS.register("kyanite_gem",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> TOURMALINE_GEM = ITEMS.register("tourmaline_gem",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CITRINE_GEM = ITEMS.register("citrine_gem",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> AMETHYST_GEM = ITEMS.register("amethyst_gem",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> AMETRINE_GEM = ITEMS.register("ametrine_gem",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ONYX_GEM = ITEMS.register("onyx_gem",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> AMMOLITE_GEM = ITEMS.register("ammolite_gem",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> COKE = ITEMS.register("coke",
            () -> new Item(new Item.Properties()));





    public static void  register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
