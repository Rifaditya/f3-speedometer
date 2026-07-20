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

    private Vec3 lastPos = null;
    private long lastTime = -1;

    @Override
    public void display(DebugScreenDisplayer displayer, @Nullable Level level, @Nullable LevelChunk clientChunk, @Nullable LevelChunk serverChunk) {
        Minecraft client = Minecraft.getInstance();
        Entity entity = client.getCameraEntity();
        if (entity == null) {
            entity = client.player;
        }

        if (entity == null) {
            displayer.addLine("Speed: 0.00 m/s");
            return;
        }

        Vec3 currentPos = entity.position();
        long currentTime = System.currentTimeMillis();

        double speedBps = 0.0;
        double horizBps = 0.0;
        double vertBps = 0.0;

        if (lastPos != null && lastTime > 0 && currentTime > lastTime) {
            double deltaSec = (currentTime - lastTime) / 1000.0;
            if (deltaSec > 0.001 && deltaSec < 1.0) {
                double dx = currentPos.x - lastPos.x;
                double dy = currentPos.y - lastPos.y;
                double dz = currentPos.z - lastPos.z;

                horizBps = Math.sqrt(dx * dx + dz * dz) / deltaSec;
                vertBps = Math.abs(dy) / deltaSec;
                speedBps = Math.sqrt(dx * dx + dy * dy + dz * dz) / deltaSec;
            } else {
                Vec3 velocity = entity.getDeltaMovement();
                horizBps = Math.sqrt(velocity.x * velocity.x + velocity.z * velocity.z) * 20.0;
                vertBps = Math.abs(velocity.y) * 20.0;
                speedBps = velocity.length() * 20.0;
            }
        } else {
            Vec3 velocity = entity.getDeltaMovement();
            horizBps = Math.sqrt(velocity.x * velocity.x + velocity.z * velocity.z) * 20.0;
            vertBps = Math.abs(velocity.y) * 20.0;
            speedBps = velocity.length() * 20.0;
        }

        lastPos = currentPos;
        lastTime = currentTime;

        String line = String.format(Locale.ROOT, "Speed: %.2f m/s (H: %.2f, V: %.2f)", speedBps, horizBps, vertBps);
        displayer.addLine(line);
    }
}
