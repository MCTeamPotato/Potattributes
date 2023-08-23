package com.teampotato.potattributes.mixin;

import com.teampotato.potattributes.registry.ModAttributes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.CriticalHitEvent;
import net.minecraftforge.eventbus.api.Event;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import java.util.concurrent.ThreadLocalRandom;

@Mixin(value = ForgeHooks.class, remap = false, priority = 2000)
public abstract class MixinForgeHooks {
    /**
     * @author Kasualix
     * @reason impl critical hit chance
     */
    @Overwrite
    @Nullable
    public static CriticalHitEvent getCriticalHit(Player player, Entity target, boolean vanillaCritical, float damageModifier) {
        AttributeInstance criticalAttackChanceAttribute = player.getAttribute(ModAttributes.CRITICAL_ATTACK_CHANCE.get());
        if (criticalAttackChanceAttribute != null) {
            vanillaCritical = !(ThreadLocalRandom.current().nextDouble(0.00, 1.01) > criticalAttackChanceAttribute.getValue());
            if (vanillaCritical) {
                AttributeInstance criticalAttackDamageBonusAttribute = player.getAttribute(ModAttributes.CRITICAL_ATTACK_DAMAGE_BONUS.get());
                if (criticalAttackDamageBonusAttribute != null) {
                    damageModifier = (float) ((1 + criticalAttackDamageBonusAttribute.getValue()) * damageModifier);
                }
            }
        }
        CriticalHitEvent hitResult = new CriticalHitEvent(player, target, damageModifier, vanillaCritical);
        MinecraftForge.EVENT_BUS.post(hitResult);
        if (hitResult.getResult() == Event.Result.ALLOW || vanillaCritical && hitResult.getResult() == Event.Result.DEFAULT) return hitResult;
        return null;
    }
}
