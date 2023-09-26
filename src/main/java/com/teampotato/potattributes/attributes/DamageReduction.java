package com.teampotato.potattributes.attributes;

import com.teampotato.potattributes.mixin.ConfigInitializer;
import net.minecraft.world.entity.ai.attributes.RangedAttribute;

public class DamageReduction extends RangedAttribute {
    public static final String PATH = "damage_reduction";
    public DamageReduction() {
        super("attribute.name.generic." + PATH, 0.00, 0.00, ConfigInitializer.config.maxDamageReduction);
    }
}
