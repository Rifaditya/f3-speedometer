// Copyright (C) 2026 Dasik (Rifaditya) | GNU GPLv3
package net.vanillaoutsider.speedometer.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.debug.DebugScreenDisplayer;
import net.minecraft.client.gui.components.debug.DebugScreenEntry;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.chunk.LevelChunk;
import net.minecraft.world.phys.Vec3;
import net.vanillaoutsider.speedometer.SpeedometerMod;
import org.jspecify.annotations.Nullable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;

public class DebugEntryPlayerSpeedWrapper implements DebugScreenEntry {
    private final DebugScreenEntry parent;

    public DebugEntryPlayerSpeedWrapper(DebugScreenEntry parent) {
        this.parent = parent;
    }

    @Override
    public void display(DebugScreenDisplayer displayer, @Nullable Level level, @Nullable LevelChunk clientChunk, @Nullable LevelChunk serverChunk) {
        Minecraft client = Minecraft.getInstance();
        
        // Check if our speedometer entry is also currently enabled
        boolean speedometerEnabled = (client.debugEntries != null && client.debugEntries.isCurrentlyEnabled(SpeedometerMod.SPEEDOMETER_ID));

        if (speedometerEnabled) {
            DebugScreenDisplayer spyDisplayer = new DebugScreenDisplayer() {
                @Override
                public void addPriorityLine(String line) {
                    displayer.addPriorityLine(modifyLine(line));
                }

                @Override
                public void addLine(String line) {
                    displayer.addLine(modifyLine(line));
                }

                @Override
                public void addToGroup(Identifier group, Collection<String> lines) {
                    List<String> modified = new ArrayList<>();
                    for (String line : lines) {
                        modified.add(modifyLine(line));
                    }
                    displayer.addToGroup(group, modified);
                }

                @Override
                public void addToGroup(Identifier group, String line) {
                    displayer.addToGroup(group, modifyLine(line));
                }

                private String modifyLine(String original) {
                    if (original != null && original.startsWith("Speed: ")) {
                        Entity entity = client.getCameraEntity();
                        if (entity == null) {
                            entity = client.player;
                        }
                        if (entity != null) {
                            Vec3 knownSpeed = entity.getKnownSpeed();
                            double bpsSpeed = knownSpeed.length() * 20.0;
                            double bpsHoriz = Math.sqrt(knownSpeed.x * knownSpeed.x + knownSpeed.z * knownSpeed.z) * 20.0;
                            double bpsVert = Math.abs(knownSpeed.y) * 20.0;
                            // Appends dynamic blocks/second details: Speed: 0.215 blocks/tick, 4.30 b/s (H: 4.30, V: 0.00)
                            return String.format(Locale.ROOT, "%s, %.2f b/s (H: %.2f, V: %.2f)", original, bpsSpeed, bpsHoriz, bpsVert);
                        }
                    }
                    return original;
                }
            };

            parent.display(spyDisplayer, level, clientChunk, serverChunk);
        } else {
            // Speedometer option is disabled; output vanilla speed unmodified (Speed: 0.215 blocks/tick)
            parent.display(displayer, level, clientChunk, serverChunk);
        }
    }
}
