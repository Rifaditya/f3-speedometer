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
            displayer.addLine("Speed:   0.00 b/s (H:   0.00, V:   0.00)");
            return;
        }

        // Handle vehicles (horses, minecarts, boats) if player is riding
        Entity targetEntity = entity.getVehicle() != null ? entity.getVehicle() : entity;

        Vec3 velocity = targetEntity.getDeltaMovement();

        double vy = velocity.y;
        // On ground, ignore constant downward gravity acceleration (~ -0.0784 -> ~1.57 b/s) when resting on blocks
        if (targetEntity.onGround() && vy < 0.0 && Math.abs(vy) <= 0.08) {
            vy = 0.0;
        }

        double targetHoriz = Math.sqrt(velocity.x * velocity.x + velocity.z * velocity.z) * 20.0;
        double targetVert = Math.abs(vy) * 20.0;
        double targetSpeed = Math.sqrt(velocity.x * velocity.x + vy * vy + velocity.z * velocity.z) * 20.0;

        // Exponential smoothing to prevent frame jitter
        smoothHoriz = smoothHoriz * 0.7 + targetHoriz * 0.3;
        smoothVert = smoothVert * 0.7 + targetVert * 0.3;
        smoothSpeed = smoothSpeed * 0.7 + targetSpeed * 0.3;

        // Zero out negligible movement noise when standing still
        if (smoothHoriz < 0.01) smoothHoriz = 0.0;
        if (smoothVert < 0.01) smoothVert = 0.0;
        if (smoothSpeed < 0.01) smoothSpeed = 0.0;

        // Clamp display range (up to 999.99 b/s)
        double dispSpeed = Math.min(smoothSpeed, 999.99);
        double dispHoriz = Math.min(smoothHoriz, 999.99);
        double dispVert = Math.min(smoothVert, 999.99);

        // Fixed-width formatting (%6.2f) keeps string length 100% constant to prevent text box resizing
        String line = String.format(Locale.ROOT, "Speed: %6.2f b/s (H: %6.2f, V: %6.2f)", dispSpeed, dispHoriz, dispVert);
        displayer.addLine(line);
    }
}
