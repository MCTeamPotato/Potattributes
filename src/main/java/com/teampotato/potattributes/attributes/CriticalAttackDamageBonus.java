package com.teampotato.potattributes.attributes;

import com.teampotato.potattributes.mixin.ConfigInitializer;
import net.minecraft.world.entity.ai.attributes.RangedAttribute;

public class CriticalAttackDamageBonus extends RangedAttribute {
    public static final String PATH = "critical_attack_damage_bonus";
    public CriticalAttackDamageBonus() {
        super("attribute.name.generic." + PATH, 0.00, 0.00, ConfigInitializer.config.maxCriticalAttackDamageBonus);
    }
}
