// Copyright (C) 2026 Dasik (Rifaditya) | GNU GPLv3
package net.vanillaoutsider.f3speedometer.mixin;

import net.minecraft.client.gui.components.debug.DebugScreenEntryList;
import net.minecraft.client.gui.components.debug.DebugScreenEntryStatus;
import net.minecraft.resources.Identifier;
import net.vanillaoutsider.f3speedometer.F3SpeedometerMod;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Map;

@Mixin(DebugScreenEntryList.class)
public abstract class DebugScreenEntryListMixin {
    @Shadow @Final
    private Map<Identifier, DebugScreenEntryStatus> allStatuses;

    @Inject(method = "rebuildCurrentList", at = @At("HEAD"))
    private void onRebuildCurrentList(CallbackInfo ci) {
        if (!allStatuses.containsKey(F3SpeedometerMod.SPEEDOMETER_ID)) {
            allStatuses.put(F3SpeedometerMod.SPEEDOMETER_ID, DebugScreenEntryStatus.IN_OVERLAY);
        }
    }
}
