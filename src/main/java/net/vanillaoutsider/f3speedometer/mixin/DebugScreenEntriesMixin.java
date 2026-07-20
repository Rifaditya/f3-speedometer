// Copyright (C) 2026 Dasik (Rifaditya) | GNU GPLv3
package net.vanillaoutsider.f3speedometer.mixin;

import net.minecraft.client.gui.components.debug.DebugScreenEntries;
import net.minecraft.client.gui.components.debug.DebugScreenEntry;
import net.minecraft.resources.Identifier;
import net.vanillaoutsider.f3speedometer.F3SpeedometerMod;
import net.vanillaoutsider.f3speedometer.client.DebugEntrySpeedometer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(DebugScreenEntries.class)
public abstract class DebugScreenEntriesMixin {
    @Invoker("register")
    public static Identifier invokeRegister(Identifier identifier, DebugScreenEntry entry) {
        throw new AssertionError();
    }

    @Inject(method = "<clinit>", at = @At("TAIL"))
    private static void onInit(CallbackInfo ci) {
        invokeRegister(F3SpeedometerMod.SPEEDOMETER_ID, new DebugEntrySpeedometer());
    }
}
