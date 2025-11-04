package net.expo.expotech.worldgen;

import net.expo.expotech.DorszpackMod;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;

import java.util.List;

public class ModPlacedFeatures {
    public static final ResourceKey<PlacedFeature> OVERWORLD_OPAL_ORE_PLACED_KEY = registerKey("overworld_opal_ore_placed");
    public static final ResourceKey<PlacedFeature> NETHER_OPAL_ORE_PLACED_KEY = registerKey("nether_opal_ore_placed");
    public static final ResourceKey<PlacedFeature> PERIDOT_ORE_PLACED_KEY = registerKey("peridot_ore_placed");
    public static final ResourceKey<PlacedFeature> TOURMALINE_ORE_PLACED_KEY = registerKey("tourmaline_ore_placed");
    public static final ResourceKey<PlacedFeature> KYANITE_ORE_PLACED_KEY = registerKey("kyanite_ore_placed");
    public static final ResourceKey<PlacedFeature> AQUAMARINE_ORE_PLACED_KEY = registerKey("aquamarine_ore_placed");
    public static final ResourceKey<PlacedFeature> SCORIA_PLACED_KEY = registerKey("scoria_placed");
    public static final ResourceKey<PlacedFeature> AMMOLITE_ORE_PLACED_KEY = registerKey("ammolite_ore_placed");

    public static final ResourceKey<PlacedFeature> MUD_PLACED_KEY = registerKey("mud_placed");
    public static final ResourceKey<PlacedFeature> MUDSTONE_PLACED_KEY = registerKey("mudstone_placed");
    public static final ResourceKey<PlacedFeature> MOSSY_MUD_PLACED_KEY = registerKey("mossy_mud_placed");
    public static final ResourceKey<PlacedFeature> MOSSY_MUD_IRON_ORE_PLACED_KEY = registerKey("mossy_mud_iron_ore_placed");
    public static final ResourceKey<PlacedFeature> MOSSY_MUD_GOLD_ORE_PLACED_KEY = registerKey("mossy_mud_gold_ore_placed");
    public static final ResourceKey<PlacedFeature> MUD_GOLD_ORE_PLACED_KEY = registerKey("mud_gold_ore_placed");
    public static final ResourceKey<PlacedFeature> MUDSTONE_GOLD_ORE_PLACED_KEY = registerKey("mudstone_gold_ore_placed");
    public static final ResourceKey<PlacedFeature> MUD_IRON_ORE_PLACED_KEY = registerKey("mud_iron_ore_placed");
    public static final ResourceKey<PlacedFeature> MUD_EMERALD_ORE_PLACED_KEY = registerKey("mud_emerald_ore_placed");

    public static final ResourceKey<PlacedFeature> MARBLE_PLACED_KEY = registerKey("marble_placed_key");
    public static final ResourceKey<PlacedFeature> LARVIKITE_PLACED_KEY = registerKey("larvikite_placed_key");




    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        // Register Placed Features with proper placement modifiers
        register(context, OVERWORLD_OPAL_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_OPAL_ORE_KEY),
                ModOrePlacement.commonOrePlacement(9,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(80))));

        register(context, NETHER_OPAL_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.NETHER_OPAL_ORE_KEY),
                ModOrePlacement.commonOrePlacement(9,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(80))));

        register(context, PERIDOT_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.PERIDOT_ORE_KEY),
                ModOrePlacement.commonOrePlacement(18,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(80))));

        register(context, TOURMALINE_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.TOURMALINE_ORE_KEY),
                ModOrePlacement.commonOrePlacement(5,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(80))));

        register(context, KYANITE_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.KYANITE_ORE_KEY),
                ModOrePlacement.commonOrePlacement(14,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(57))));

        register(context, AQUAMARINE_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.AQUAMARINE_ORE_KEY),
                ModOrePlacement.commonOrePlacement(14,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(57))));

        register(context, MOSSY_MUD_IRON_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.MOSSY_MUD_IRON_ORE_KEY),
                ModOrePlacement.commonOrePlacement(14,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(57))));
        register(context, MOSSY_MUD_GOLD_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.MOSSY_MUD_GOLD_ORE_KEY),
                ModOrePlacement.commonOrePlacement(14,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(57))));
        register(context, MUD_IRON_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.MUD_IRON_ORE_KEY),
                ModOrePlacement.commonOrePlacement(14,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(57))));
        register(context, MUD_GOLD_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.MUD_GOLD_ORE_KEY),
                ModOrePlacement.commonOrePlacement(14,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(57))));
        register(context, MUDSTONE_GOLD_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.MUDSTONE_GOLD_ORE_KEY),
                ModOrePlacement.commonOrePlacement(5,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(57))));
        register(context, MUD_EMERALD_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.MUD_EMERALD_ORE_KEY),
                ModOrePlacement.commonOrePlacement(14,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(57))));


        register(context, SCORIA_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.SCORIA_KEY),
                ModOrePlacement.commonOrePlacement(14,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(57))));
        register(context, AMMOLITE_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.AMMOLITE_ORE_KEY),
                ModOrePlacement.commonOrePlacement(9,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(57))));


        register(context, MUD_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.MUD_KEY),
                ModOrePlacement.commonOrePlacement(98,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(57))));

        register(context, MUDSTONE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.MUDSTONE_KEY),
                ModOrePlacement.commonOrePlacement(28,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(57))));

        register(context, MARBLE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.MARBLE_KEY),
                ModOrePlacement.commonOrePlacement(28,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(57))));
        register(context, LARVIKITE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.LARVIKITE_KEY),
                ModOrePlacement.commonOrePlacement(28,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(57))));

        register(context, MOSSY_MUD_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.MOSSY_MUD_KEY),
                ModOrePlacement.commonOrePlacement(78,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(57))));
    }

    // Register the PlacedFeature with the given key, configured feature, and placement modifiers
    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

    // Register the key for PlacedFeature using the given name
    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(DorszpackMod.MOD_ID, name));
    }
}

