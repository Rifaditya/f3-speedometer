// Copyright (C) 2026 Dasik (Rifaditya) | GNU GPLv3
package net.vanillaoutsider.playerspeed.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.debug.DebugScreenDisplayer;
import net.minecraft.client.gui.components.debug.DebugScreenEntry;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.chunk.LevelChunk;
import net.minecraft.world.phys.Vec3;
import org.jspecify.annotations.Nullable;

import java.util.Locale;

public class DebugEntryPlayerSpeed implements DebugScreenEntry {

    @Override
    public void display(DebugScreenDisplayer displayer, @Nullable Level level, @Nullable LevelChunk clientChunk, @Nullable LevelChunk serverChunk) {
        Minecraft client = Minecraft.getInstance();
        Entity entity = client.getCameraEntity();
        if (entity == null) {
            entity = client.player;
        }

        if (entity == null) {
            displayer.addLine("Speed:   0.00 b/s (H:   0.00, V:   0.00)");
            return;
        }

        // Retrieve tick-based velocity natively calculated by Minecraft 26.2 (Entity.getKnownSpeed)
        Vec3 knownSpeed = entity.getKnownSpeed();

        // Convert from blocks/tick to blocks/second (b/s)
        double targetHoriz = Math.sqrt(knownSpeed.x * knownSpeed.x + knownSpeed.z * knownSpeed.z) * 20.0;
        double targetVert = Math.abs(knownSpeed.y) * 20.0;
        double targetSpeed = knownSpeed.length() * 20.0;

        // Clamp display range (up to 999.99 b/s)
        double dispSpeed = Math.min(targetSpeed, 999.99);
        double dispHoriz = Math.min(targetHoriz, 999.99);
        double dispVert = Math.min(targetVert, 999.99);

        // Fixed-width formatting (%6.2f) keeps string length 100% constant to prevent text box resizing
        String line = String.format(Locale.ROOT, "Speed: %6.2f b/s (H: %6.2f, V: %6.2f)", dispSpeed, dispHoriz, dispVert);
        displayer.addLine(line);
    }
}
