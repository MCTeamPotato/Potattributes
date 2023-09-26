package com.teampotato.potattributes.attributes;

import com.teampotato.potattributes.mixin.ConfigInitializer;
import net.minecraft.world.entity.ai.attributes.RangedAttribute;

public class CriticalAttackChance extends RangedAttribute {
    public static final String PATH = "critical_attack_chance";
    public CriticalAttackChance() {
        super("attribute.name.generic." + PATH, ConfigInitializer.config.initialCriticalAttackChance, 0.00, ConfigInitializer.config.maxCriticalAttackChance);
    }
}
