package com.teampotato.potattributes.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class Config {
    public static final ForgeConfigSpec config;
    public static final ForgeConfigSpec.DoubleValue maxCriticalAttackChance;
    public static final ForgeConfigSpec.DoubleValue maxCriticalAttackDamageBonus;
    public static final ForgeConfigSpec.DoubleValue maxDamageReduction;
    public static final ForgeConfigSpec.DoubleValue initialCriticalAttackChance;
    public static final ForgeConfigSpec.BooleanValue disableVanillaCriticalAttack;

    static {
        ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();
        builder.push("Potattributes");
        initialCriticalAttackChance = builder.defineInRange("initialCriticalAttackChance", 0.25, 0.00, 1.00);
        maxCriticalAttackChance = builder.defineInRange("maxCriticalAttackChance", 0.60, 0.01, 1.00);
        maxCriticalAttackDamageBonus = builder.defineInRange("maxCriticalAttackDamageBonus", 0.40, 0.01, Double.MAX_VALUE);
        maxDamageReduction = builder.defineInRange("maxDamageReduction", 0.30, 0.01, 1.00);
        disableVanillaCriticalAttack = builder.define("disableVanillaCriticalAttack", true);
        builder.pop();
        config = builder.build();
    }
}
