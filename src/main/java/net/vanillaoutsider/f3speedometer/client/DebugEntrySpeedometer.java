// Copyright (C) 2026 Dasik (Rifaditya) | GNU GPLv3
package net.vanillaoutsider.f3speedometer.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.debug.DebugScreenDisplayer;
import net.minecraft.client.gui.components.debug.DebugScreenEntry;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.chunk.LevelChunk;
import net.minecraft.world.phys.Vec3;
import org.jspecify.annotations.Nullable;

import java.util.Locale;

public class DebugEntrySpeedometer implements DebugScreenEntry {

    private double smoothSpeed = 0.0;
    private double smoothHoriz = 0.0;
    private double smoothVert = 0.0;

    @Override
    public void display(DebugScreenDisplayer displayer, @Nullable Level level, @Nullable LevelChunk clientChunk, @Nullable LevelChunk serverChunk) {
        Minecraft client = Minecraft.getInstance();
        Entity entity = client.getCameraEntity();
        if (entity == null) {
            entity = client.player;
        }

        if (entity == null) {
            displayer.addLine("Speed:   0.00 m/s (H:   0.00, V:   0.00)");
            return;
        }

        Vec3 velocity = entity.getDeltaMovement();
        double targetHoriz = Math.sqrt(velocity.x * velocity.x + velocity.z * velocity.z) * 20.0;
        double targetVert = Math.abs(velocity.y) * 20.0;
        double targetSpeed = velocity.length() * 20.0;

        // Exponential smoothing to prevent frame jitter
        smoothHoriz = smoothHoriz * 0.7 + targetHoriz * 0.3;
        smoothVert = smoothVert * 0.7 + targetVert * 0.3;
        smoothSpeed = smoothSpeed * 0.7 + targetSpeed * 0.3;

        // Zero out negligible noise
        if (smoothHoriz < 0.001) smoothHoriz = 0.0;
        if (smoothVert < 0.001) smoothVert = 0.0;
        if (smoothSpeed < 0.001) smoothSpeed = 0.0;

        // Clamp to prevent exceeding 6-character column width (up to 999.99 m/s)
        double dispSpeed = Math.min(smoothSpeed, 999.99);
        double dispHoriz = Math.min(smoothHoriz, 999.99);
        double dispVert = Math.min(smoothVert, 999.99);

        // Fixed-width formatting (%6.2f) ensures string length is 100% constant to prevent box resizing/flashing
        String line = String.format(Locale.ROOT, "Speed: %6.2f m/s (H: %6.2f, V: %6.2f)", dispSpeed, dispHoriz, dispVert);
        displayer.addLine(line);
    }
}
