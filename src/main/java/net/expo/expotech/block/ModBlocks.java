package net.expo.expotech.block;

import net.expo.expotech.Expotech;
import net.expo.expotech.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.minecraft.util.valueproviders.UniformInt;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Expotech.MOD_ID);


    public static final RegistryObject<Block> MALACHITE_ORE = registerBlock("malachite_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(2f).requiresCorrectToolForDrops(), UniformInt.of(3,6)));
    public static final RegistryObject<Block> AMBER_ORE = registerBlock("amber_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(2f).requiresCorrectToolForDrops(), UniformInt.of(3,6)));
    public static final RegistryObject<Block> AGATE_ORE = registerBlock("agate_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(2f).requiresCorrectToolForDrops(), UniformInt.of(3,6)));
    public static final RegistryObject<Block> TOPAZ_ORE = registerBlock("topaz_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(2f).requiresCorrectToolForDrops(), UniformInt.of(3,6)));
    public static final RegistryObject<Block> CITRINE_ORE = registerBlock("citrine_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE)
                    .strength(3f).requiresCorrectToolForDrops(), UniformInt.of(4,7)));
    public static final RegistryObject<Block> ONYX_ORE = registerBlock("onyx_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE)
                    .strength(3f).requiresCorrectToolForDrops(), UniformInt.of(4,7)));
    public static final RegistryObject<Block> AMETRINE_ORE = registerBlock("ametrine_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE)
                    .strength(3f).requiresCorrectToolForDrops(), UniformInt.of(4,7)));
    public static final RegistryObject<Block> NETHER_OPAL_ORE = registerBlock("nether_opal_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.BLACKSTONE)
                    .strength(4f).requiresCorrectToolForDrops(), UniformInt.of(6,8)));
    public static final RegistryObject<Block> TOURMALINE_ORE = registerBlock("tourmaline_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.SAND)
                    .strength(2f).requiresCorrectToolForDrops(), UniformInt.of(3,6)));
    public static final RegistryObject<Block> KYANITE_ORE = registerBlock("kyanite_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.SAND)
                    .strength(2f).requiresCorrectToolForDrops(), UniformInt.of(3,6)));
    public static final RegistryObject<Block> AQUAMARINE_ORE = registerBlock("aquamarine_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.SAND)
                    .strength(2f).requiresCorrectToolForDrops(), UniformInt.of(3,6)));
    public static final RegistryObject<Block> PERIDOT_ORE = registerBlock("peridot_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.PACKED_ICE)
                    .strength(3f).requiresCorrectToolForDrops(), UniformInt.of(3,6)));
    public static final RegistryObject<Block> SCORIA = registerBlock("scoria",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.MAGMA_BLOCK)
                    .strength(8f).requiresCorrectToolForDrops(), UniformInt.of(5,8)));
    public static final RegistryObject<Block> AMMOLITE_ORE = registerBlock("ammolite_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.IRON_ORE)
                    .strength(3f).requiresCorrectToolForDrops(), UniformInt.of(4,7)));

    public static final RegistryObject<Block> MOSSY_MUD = registerBlock("mossy_mud",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.MUD)
                    .strength(2f).requiresCorrectToolForDrops(), UniformInt.of(0,0)));
    public static final RegistryObject<Block> MUDSTONE = registerBlock("mudstone",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(5f).requiresCorrectToolForDrops(), UniformInt.of(0,0)));
    public static final RegistryObject<Block> MOSSY_MUD_IRON_ORE = registerBlock("mossy_mud_iron_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.IRON_ORE)
                    .strength(4f).requiresCorrectToolForDrops(), UniformInt.of(0,0)));
    public static final RegistryObject<Block> MOSSY_MUD_GOLD_ORE = registerBlock("mossy_mud_gold_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.GOLD_ORE)
                    .strength(4f).requiresCorrectToolForDrops(), UniformInt.of(0,0)));

    public static final RegistryObject<Block> MUD_IRON_ORE = registerBlock("mud_iron_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.IRON_ORE)
                    .strength(4f).requiresCorrectToolForDrops(), UniformInt.of(0,0)));
    public static final RegistryObject<Block> MUD_GOLD_ORE = registerBlock("mud_gold_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.GOLD_ORE)
                    .strength(4f).requiresCorrectToolForDrops(), UniformInt.of(0,0)));
    public static final RegistryObject<Block> MUDSTONE_GOLD_ORE = registerBlock("mudstone_gold_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.GOLD_ORE)
                    .strength(5f).requiresCorrectToolForDrops(), UniformInt.of(0,0)));
    public static final RegistryObject<Block> MUD_EMERALD_ORE = registerBlock("mud_emerald_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.EMERALD_ORE)
                    .strength(5f).requiresCorrectToolForDrops(), UniformInt.of(2,4)));

    public static final RegistryObject<Block> MARBLE = registerBlock("marble",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE)
                    .strength(5f).requiresCorrectToolForDrops(), UniformInt.of(0,0)));
    public static final RegistryObject<Block> MARBLE_BLOCK = registerBlock("marble_block",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE)
                    .strength(5f).requiresCorrectToolForDrops(), UniformInt.of(0,0)));
    public static final RegistryObject<Block> LARVIKITE = registerBlock("larvikite",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE)
                    .strength(5f).requiresCorrectToolForDrops(), UniformInt.of(0,0)));

    public static final RegistryObject<Block> COKE_BLOCK = registerBlock("coke_block",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.COAL_BLOCK)
                    .strength(2f).requiresCorrectToolForDrops(), UniformInt.of(0,0)));
    public static final RegistryObject<Block> BRONZE_SEARED_BRICKS = registerBlock("bronze_seared_bricks",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_BRICKS)
                    .strength(4f).requiresCorrectToolForDrops(), UniformInt.of(0,0)));
    public static final RegistryObject<Block> TUFF_HEAT_DAMPENER = registerBlock("tuff_heat_dampener",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.TUFF)
                    .strength(4f).requiresCorrectToolForDrops(), UniformInt.of(0,0)));



    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
