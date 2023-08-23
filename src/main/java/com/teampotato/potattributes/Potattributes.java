package com.teampotato.potattributes;

import com.teampotato.potattributes.config.Config;
import com.teampotato.potattributes.event.AttributeEvents;
import com.teampotato.potattributes.registry.ModAttributes;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Potattributes.MOD_ID)
public class Potattributes {
    public static final String MOD_ID = "potattributes";

    public Potattributes() {
        MinecraftForge.EVENT_BUS.register(AttributeEvents.class);
        ModAttributes.ATTRIBUTES.register(FMLJavaModLoadingContext.get().getModEventBus());
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.config);
    }
}
