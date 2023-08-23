package com.teampotato.potattributes.event;

import com.teampotato.potattributes.Potattributes;
import com.teampotato.potattributes.registry.ModAttributes;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = Potattributes.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class AttributeRegistry {
    @SubscribeEvent
    public static void onEntityAttributeCreate(EntityAttributeCreationEvent event) {
        AttributeSupplier.Builder builder = AttributeSupplier.builder();
        for (RegistryObject<Attribute> attributeRegistryObject : ModAttributes.ATTRIBUTES.getEntries()) {
            builder.add(attributeRegistryObject.get());
        }
        event.put(EntityType.PLAYER, builder.build());
    }
}
