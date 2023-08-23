package com.teampotato.potattributes.attributes;

import com.teampotato.potattributes.config.Config;
import net.minecraft.world.entity.ai.attributes.RangedAttribute;

public class CriticalAttackChance extends RangedAttribute {
    public static final String PATH = "critical_attack_chance";
    public CriticalAttackChance() {
        super("attribute.name.generic." + PATH, Config.initialCriticalAttackChance.get(), 0.00, Config.maxCriticalAttackChance.get());
    }
}
