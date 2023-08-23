package com.teampotato.potattributes.registry;

import com.teampotato.potattributes.Potattributes;
import com.teampotato.potattributes.attributes.CriticalAttackChance;
import com.teampotato.potattributes.attributes.CriticalAttackDamageBonus;
import com.teampotato.potattributes.attributes.DamageReduction;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModAttributes {

    public static final DeferredRegister<Attribute> ATTRIBUTES = DeferredRegister.create(ForgeRegistries.ATTRIBUTES, Potattributes.MOD_ID);

    public static final RegistryObject<Attribute> DAMAGE_REDUCTION;
    public static final RegistryObject<Attribute> CRITICAL_ATTACK_CHANCE;
    public static final RegistryObject<Attribute> CRITICAL_ATTACK_DAMAGE_BONUS;

    static {
        DAMAGE_REDUCTION = ATTRIBUTES.register(DamageReduction.PATH, DamageReduction::new);
        CRITICAL_ATTACK_CHANCE = ATTRIBUTES.register(CriticalAttackChance.PATH, CriticalAttackChance::new);
        CRITICAL_ATTACK_DAMAGE_BONUS = ATTRIBUTES.register(CriticalAttackDamageBonus.PATH, CriticalAttackDamageBonus::new);
    }
}
