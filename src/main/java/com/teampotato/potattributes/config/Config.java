package com.teampotato.potattributes.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class Config {
    public static final ForgeConfigSpec config;
    public static final ForgeConfigSpec.DoubleValue maxCriticalAttackChance, maxCriticalAttackDamageBonus, maxDamageReduction, initialCriticalAttackChance;

    static {
        ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();
        builder.push("Potattributes");
        initialCriticalAttackChance = builder.defineInRange("initialCriticalAttackChance", 0.25, 0.00, 1.00);
        maxCriticalAttackChance = builder.defineInRange("maxCriticalAttackChance", 0.60, 0.01, 1.00);
        maxCriticalAttackDamageBonus = builder.defineInRange("maxCriticalAttackDamageBonus", 0.40, 0.01, 1.00);
        maxDamageReduction = builder.defineInRange("maxDamageReduction", 0.30, 0.01, 1.00);
        builder.pop();
        config = builder.build();
    }
}
