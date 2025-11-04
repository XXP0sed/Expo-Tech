package net.expo.expotech.worldgen;

import net.expo.expotech.Expotech;
import net.expo.expotech.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;

public class ModConfiguredFeatures {

    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_OPAL_ORE_KEY = registerKey("opal_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> NETHER_OPAL_ORE_KEY = registerKey("nether_opal_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PERIDOT_ORE_KEY = registerKey("peridot_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TOURMALINE_ORE_KEY = registerKey("tourmaline_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> KYANITE_ORE_KEY = registerKey("kyanite_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> AQUAMARINE_ORE_KEY = registerKey("aquamarine_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SCORIA_KEY = registerKey("scoria");
    public static final ResourceKey<ConfiguredFeature<?, ?>> AMMOLITE_ORE_KEY = registerKey("ammolite");

    public static final ResourceKey<ConfiguredFeature<?, ?>> MUD_KEY = registerKey("mud");
    public static final ResourceKey<ConfiguredFeature<?, ?>> MUDSTONE_KEY = registerKey("mudstone");
    public static final ResourceKey<ConfiguredFeature<?, ?>> MOSSY_MUD_KEY = registerKey("mossy_mud");
    public static final ResourceKey<ConfiguredFeature<?, ?>> MOSSY_MUD_IRON_ORE_KEY = registerKey("mossy_mud_iron_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> MOSSY_MUD_GOLD_ORE_KEY = registerKey("mossy_mud_gold_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> MUD_IRON_ORE_KEY = registerKey("mud_iron_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> MUD_GOLD_ORE_KEY = registerKey("mud_gold_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> MUDSTONE_GOLD_ORE_KEY = registerKey("mudstone_gold_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> MUD_EMERALD_ORE_KEY = registerKey("mud_emerald_ore");

    public static final ResourceKey<ConfiguredFeature<?, ?>> MARBLE_KEY = registerKey("marble");
    public static final ResourceKey<ConfiguredFeature<?, ?>> LARVIKITE_KEY = registerKey("larvikite");


    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest blackstoneReplaceables = new BlockMatchTest(Blocks.BLACKSTONE);
        RuleTest stoneReplaceables = new BlockMatchTest(Blocks.STONE);
        RuleTest deepslateReplaceables = new BlockMatchTest(Blocks.DEEPSLATE);
        RuleTest packediceReplaceables = new BlockMatchTest(Blocks.PACKED_ICE);
        RuleTest sandReplaceables = new BlockMatchTest(Blocks.SAND);
        RuleTest smoothbasaltReplaceables = new BlockMatchTest(Blocks.SMOOTH_BASALT);
        RuleTest mudReplaceables = new BlockMatchTest(Blocks.MUD);
        RuleTest mossymudReplaceables = new BlockMatchTest(ModBlocks.MOSSY_MUD.get());

        register(context, OVERWORLD_OPAL_ORE_KEY, Feature.ORE, new OreConfiguration(blackstoneReplaceables,
                ModBlocks.NETHER_OPAL_ORE.get().defaultBlockState(), 9));
        register(context, NETHER_OPAL_ORE_KEY, Feature.ORE, new OreConfiguration(blackstoneReplaceables,
                ModBlocks.NETHER_OPAL_ORE.get().defaultBlockState(), 9));
        register(context, PERIDOT_ORE_KEY, Feature.ORE, new OreConfiguration(packediceReplaceables,
                ModBlocks.PERIDOT_ORE.get().defaultBlockState(), 9));
        register(context, TOURMALINE_ORE_KEY, Feature.ORE, new OreConfiguration(sandReplaceables,
                ModBlocks.TOURMALINE_ORE.get().defaultBlockState(), 5));
        register(context, KYANITE_ORE_KEY, Feature.ORE, new OreConfiguration(sandReplaceables,
                ModBlocks.KYANITE_ORE.get().defaultBlockState(), 9));
        register(context, AQUAMARINE_ORE_KEY, Feature.ORE, new OreConfiguration(sandReplaceables,
                ModBlocks.AQUAMARINE_ORE.get().defaultBlockState(), 9));
        register(context, SCORIA_KEY, Feature.ORE, new OreConfiguration(smoothbasaltReplaceables,
                ModBlocks.SCORIA.get().defaultBlockState(), 4));
        register(context, AMMOLITE_ORE_KEY, Feature.ORE, new OreConfiguration(mudReplaceables,
                ModBlocks.AMMOLITE_ORE.get().defaultBlockState(), 4));



        register(context, MUD_KEY, Feature.ORE, new OreConfiguration(stoneReplaceables,
                Blocks.MUD.defaultBlockState(), 4));
        register(context, MUDSTONE_KEY, Feature.ORE, new OreConfiguration(mudReplaceables,
                ModBlocks.MUDSTONE.get().defaultBlockState(), 4));
        register(context, MUD_IRON_ORE_KEY, Feature.ORE, new OreConfiguration(mudReplaceables,
                ModBlocks.MUD_IRON_ORE.get().defaultBlockState(), 10));
        register(context, MUD_GOLD_ORE_KEY, Feature.ORE, new OreConfiguration(mudReplaceables,
                ModBlocks.MUD_GOLD_ORE.get().defaultBlockState(), 6));
        register(context, MUDSTONE_GOLD_ORE_KEY, Feature.ORE, new OreConfiguration(mudReplaceables,
                ModBlocks.MUDSTONE_GOLD_ORE.get().defaultBlockState(), 6));
        register(context, MUD_EMERALD_ORE_KEY, Feature.ORE, new OreConfiguration(mudReplaceables,
                ModBlocks.MUD_EMERALD_ORE.get().defaultBlockState(), 4));
        register(context, MOSSY_MUD_KEY, Feature.ORE, new OreConfiguration(stoneReplaceables,
                ModBlocks.MOSSY_MUD.get().defaultBlockState(), 4));
        register(context, MOSSY_MUD_GOLD_ORE_KEY, Feature.ORE, new OreConfiguration(mossymudReplaceables,
                ModBlocks.MOSSY_MUD_GOLD_ORE.get().defaultBlockState(), 4));
        register(context, MOSSY_MUD_IRON_ORE_KEY, Feature.ORE, new OreConfiguration(mossymudReplaceables,
                ModBlocks.MOSSY_MUD_IRON_ORE.get().defaultBlockState(), 4));


        register(context, MARBLE_KEY, Feature.ORE, new OreConfiguration(deepslateReplaceables,
                ModBlocks.MARBLE.get().defaultBlockState(), 4));
        register(context, LARVIKITE_KEY, Feature.ORE, new OreConfiguration(deepslateReplaceables,
                ModBlocks.LARVIKITE.get().defaultBlockState(), 4));

    }


    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(Expotech.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }



}