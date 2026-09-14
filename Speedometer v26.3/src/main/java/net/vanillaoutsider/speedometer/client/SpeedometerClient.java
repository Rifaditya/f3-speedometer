// Copyright (C) 2026 Dasik (Rifaditya) | GNU GPLv3
package net.vanillaoutsider.speedometer.client;

import net.fabricmc.api.ClientModInitializer;
import net.vanillaoutsider.speedometer.util.ModVersionGuard;

public class SpeedometerClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ModVersionGuard.checkClass("Speedometer", "net.minecraft.client.gui.components.debug.DebugScreenEntries");
    }
}
