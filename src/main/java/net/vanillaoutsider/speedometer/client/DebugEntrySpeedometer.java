// Copyright (C) 2026 Dasik (Rifaditya) | GNU GPLv3
package net.vanillaoutsider.speedometer.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.debug.DebugScreenDisplayer;
import net.minecraft.client.gui.components.debug.DebugScreenEntry;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.chunk.LevelChunk;
import net.minecraft.world.phys.Vec3;
import net.vanillaoutsider.speedometer.SpeedometerMod;
import org.jspecify.annotations.Nullable;

import java.util.Locale;

public class DebugEntrySpeedometer implements DebugScreenEntry {

    @Override
    public void display(DebugScreenDisplayer displayer, @Nullable Level level, @Nullable LevelChunk clientChunk, @Nullable LevelChunk serverChunk) {
        Minecraft client = Minecraft.getInstance();
        
        // If vanilla's native player_speed is also currently enabled, let the wrapper handle the combined output and exit here
        if (client.debugEntries != null && client.debugEntries.isCurrentlyEnabled(SpeedometerMod.NATIVE_PLAYER_SPEED_ID)) {
            return;
        }

        Entity entity = client.getCameraEntity();
        if (entity == null) {
            entity = client.player;
        }

        if (entity == null) {
            displayer.addLine("Speed: 0.00 b/s (H: 0.00, V: 0.00)");
            return;
        }

        // Retrieve tick-based velocity natively calculated by Minecraft 26.2 (Entity.getKnownSpeed)
        Vec3 knownSpeed = entity.getKnownSpeed();

        // Convert from blocks/tick to blocks/second (b/s)
        double targetHoriz = Math.sqrt(knownSpeed.x * knownSpeed.x + knownSpeed.z * knownSpeed.z) * 20.0;
        double targetVert = Math.abs(knownSpeed.y) * 20.0;
        double targetSpeed = knownSpeed.length() * 20.0;

        // Dynamic string length formatting (%.2f) without rigid spaces padding
        String line = String.format(Locale.ROOT, "Speed: %.2f b/s (H: %.2f, V: %.2f)", targetSpeed, targetHoriz, targetVert);
        displayer.addLine(line);
    }
}
