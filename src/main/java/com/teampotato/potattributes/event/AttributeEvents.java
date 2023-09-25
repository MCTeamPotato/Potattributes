package com.teampotato.potattributes.event;

import com.teampotato.potattributes.registry.ModAttributes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import org.jetbrains.annotations.NotNull;

public class AttributeEvents {
    @SubscribeEvent(priority = EventPriority.LOWEST)
    public static void onLivingHurt(@NotNull LivingHurtEvent event) {
        LivingEntity livingEntity = event.getEntity();
        AttributeInstance attributeInstance = livingEntity.getAttribute(ModAttributes.DAMAGE_REDUCTION.get());
        if (attributeInstance == null || livingEntity.level.isClientSide || event.isCanceled()) return;
        double damageReduction = attributeInstance.getValue();
        event.setAmount(event.getAmount() * (1.0F - (float) damageReduction));
    }
}
