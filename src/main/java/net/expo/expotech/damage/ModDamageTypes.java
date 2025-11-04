package net.expo.expotech.damage;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.level.Level;

import net.minecraft.world.entity.Entity;


public class ModDamageTypes {

    // ResourceKeys for your custom damage types
    public static final ResourceKey<DamageType> FIRE = ResourceKey.create(
            Registries.DAMAGE_TYPE, new ResourceLocation("dorszpackmod", "fire"));
    public static final ResourceKey<DamageType> ICE = ResourceKey.create(
            Registries.DAMAGE_TYPE, new ResourceLocation("dorszpackmod", "ice"));

    // Utility method to create DamageSources
    public static DamageSource fire(Level level, Entity attacker) {
        return new DamageSource(level.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(FIRE), attacker);
    }

    public static DamageSource ice(Level level, Entity attacker) {
        return new DamageSource(level.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ICE), attacker);
    }
}

