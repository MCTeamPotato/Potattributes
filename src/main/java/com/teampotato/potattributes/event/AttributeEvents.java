package com.teampotato.potattributes.event;

import com.teampotato.potattributes.registry.ModAttributes;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraftforge.event.entity.EntityAttributeModificationEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.RegistryObject;

public class AttributeEvents {
    @SubscribeEvent(priority = EventPriority.LOWEST)
    public static void onLivingHurt(LivingHurtEvent event) {
        LivingEntity livingEntity = event.getEntity();
        AttributeInstance attributeInstance = livingEntity.getAttribute(ModAttributes.DAMAGE_REDUCTION.get());
        if (attributeInstance == null || livingEntity.level.isClientSide || event.isCanceled()) return;
        double damageReduction = attributeInstance.getValue();
        event.setAmount(event.getAmount() * (1.0F - (float) damageReduction));
    }

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeModificationEvent event) {
        for (RegistryObject<Attribute> attributeRegistryObject : ModAttributes.ATTRIBUTES.getEntries()) {
            event.add(EntityType.PLAYER, attributeRegistryObject.get());
        }
    }
}
