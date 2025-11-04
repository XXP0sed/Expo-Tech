package net.expo.expotech.event;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "expotech")
public class MobHealthBuffHandler {

    @SubscribeEvent
    public static void onEntityJoin(EntityJoinLevelEvent event) {
        if (!(event.getEntity() instanceof LivingEntity entity)) return;

        // Buff specific mob types
        if (entity.getType() == EntityType.ZOMBIE) {
            var attr = entity.getAttribute(Attributes.MAX_HEALTH);
            if (attr != null && attr.getBaseValue() < 30.0) {
                attr.setBaseValue(30.0);
                entity.setHealth(30.0f);
            }
        }

        if (entity.getType() == EntityType.HUSK) {
            var attr = entity.getAttribute(Attributes.MAX_HEALTH);
            if (attr != null && attr.getBaseValue() < 35.0) {
                attr.setBaseValue(35.0);
                entity.setHealth(35.0f);
            }
        }

        if (entity.getType() == EntityType.DROWNED) {
            var attr = entity.getAttribute(Attributes.MAX_HEALTH);
            if (attr != null && attr.getBaseValue() < 40.0) {
                attr.setBaseValue(40.0);
                entity.setHealth(40.0f);
            }
        }

        if (entity.getType() == EntityType.SKELETON) {
            var attr = entity.getAttribute(Attributes.MAX_HEALTH);
            if (attr != null && attr.getBaseValue() < 30.0) {
                attr.setBaseValue(30.0);
                entity.setHealth(30.0f);
            }
        }

        if (entity.getType() == EntityType.STRAY) {
            var attr = entity.getAttribute(Attributes.MAX_HEALTH);
            if (attr != null && attr.getBaseValue() < 35.0) {
                attr.setBaseValue(35.0);
                entity.setHealth(35.0f);
            }
        }

        if (entity.getType() == EntityType.ENDER_DRAGON) {
            var attr = entity.getAttribute(Attributes.MAX_HEALTH);
            if (attr != null && attr.getBaseValue() < 400.0) {
                attr.setBaseValue(400.0);
                entity.setHealth(400.0f);
            }
        }
        if (entity.getType() == EntityType.WITHER_SKELETON) {
            var attr = entity.getAttribute(Attributes.MAX_HEALTH);
            if (attr != null && attr.getBaseValue() < 45.0) {
                attr.setBaseValue(45.0);
                entity.setHealth(45.0f);
            }
        }
        if (entity.getType() == EntityType.BLAZE) {
            var attr = entity.getAttribute(Attributes.MAX_HEALTH);
            if (attr != null && attr.getBaseValue() < 40.0) {
                attr.setBaseValue(40.0);
                entity.setHealth(40.0f);
            }
        }
    }
}
