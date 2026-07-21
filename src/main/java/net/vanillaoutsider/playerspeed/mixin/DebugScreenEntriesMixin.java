// Copyright (C) 2026 Dasik (Rifaditya) | GNU GPLv3
package net.vanillaoutsider.playerspeed.mixin;

import net.minecraft.client.gui.components.debug.DebugScreenEntries;
import net.minecraft.client.gui.components.debug.DebugScreenEntry;
import net.minecraft.resources.Identifier;
import net.vanillaoutsider.playerspeed.PlayerSpeedMod;
import net.vanillaoutsider.playerspeed.client.DebugEntryPlayerSpeed;
import net.vanillaoutsider.playerspeed.client.DebugEntryPlayerSpeedWrapper;
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
        Identifier id = PlayerSpeedMod.SPEEDOMETER_ID;
        DebugScreenEntry vanillaEntry = ENTRIES_BY_ID.get(id);
        if (vanillaEntry != null) {
            // Under Minecraft 26.3+ (where player_speed is natively registered), wrap the vanilla entry
            ENTRIES_BY_ID.put(id, new DebugEntryPlayerSpeedWrapper(vanillaEntry));
        } else {
            // Under Minecraft 26.2, register our own player speed entry
            invokeRegister(id, new DebugEntryPlayerSpeed());
        }
    }
}
