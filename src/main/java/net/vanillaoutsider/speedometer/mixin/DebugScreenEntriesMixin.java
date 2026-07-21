// Copyright (C) 2026 Dasik (Rifaditya) | GNU GPLv3
package net.vanillaoutsider.speedometer.mixin;

import net.minecraft.client.gui.components.debug.DebugScreenEntries;
import net.minecraft.client.gui.components.debug.DebugScreenEntry;
import net.minecraft.resources.Identifier;
import net.vanillaoutsider.speedometer.SpeedometerMod;
import net.vanillaoutsider.speedometer.client.DebugEntrySpeedometer;
import net.vanillaoutsider.speedometer.client.DebugEntryPlayerSpeedWrapper;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.gen.Invoker;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Map;

@Mixin(DebugScreenEntries.class)
public abstract class DebugScreenEntriesMixin {
    @Shadow @Final
    private static Map<Identifier, DebugScreenEntry> ENTRIES_BY_ID;

    @Invoker("register")
    public static Identifier invokeRegister(Identifier identifier, DebugScreenEntry entry) {
        throw new AssertionError();
    }

    @Inject(method = "<clinit>", at = @At("TAIL"))
    private static void onInit(CallbackInfo ci) {
        // Register our custom speedometer entry
        invokeRegister(SpeedometerMod.SPEEDOMETER_ID, new DebugEntrySpeedometer());

        // Check if player_speed is natively registered by vanilla (Minecraft 26.3+)
        DebugScreenEntry vanillaEntry = ENTRIES_BY_ID.get(SpeedometerMod.NATIVE_PLAYER_SPEED_ID);
        if (vanillaEntry != null) {
            ENTRIES_BY_ID.put(SpeedometerMod.NATIVE_PLAYER_SPEED_ID, new DebugEntryPlayerSpeedWrapper(vanillaEntry));
        }
    }
}
