package com.teampotato.potattributes;

import com.teampotato.potattributes.event.AttributeEvents;
import com.teampotato.potattributes.registry.ModAttributes;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityAttributeModificationEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.RegistryObject;

@Mod(Potattributes.MOD_ID)
public class Potattributes {
    public static final String MOD_ID = "potattributes";

    public Potattributes() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        MinecraftForge.EVENT_BUS.register(AttributeEvents.class);
        bus.addListener(this::registerAttributes);
        ModAttributes.ATTRIBUTES.register(bus);
    }

    private void registerAttributes(EntityAttributeModificationEvent event) {
        for (RegistryObject<Attribute> attributeRegistryObject : ModAttributes.ATTRIBUTES.getEntries()) {
            event.add(EntityType.PLAYER, attributeRegistryObject.get());
        }
    }
}
