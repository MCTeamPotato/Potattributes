package com.teampotato.potattributes.mixin;

import com.teampotato.potattributes.registry.ModAttributes;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.registries.RegistryObject;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(Player.class)
public abstract class PlayerMixin {
    @Redirect(method = "createAttributes", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/ai/attributes/AttributeSupplier$Builder;add(Lnet/minecraft/world/entity/ai/attributes/Attribute;)Lnet/minecraft/world/entity/ai/attributes/AttributeSupplier$Builder;", ordinal = 3))
    private static AttributeSupplier.Builder onRegisterAttribute(AttributeSupplier.Builder instance, Attribute arg) {
        for (RegistryObject<Attribute> attributeRegistryObject : ModAttributes.ATTRIBUTES.getEntries()) instance.add(attributeRegistryObject.get());
        return instance.add(arg);
    }
}
