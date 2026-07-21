// Copyright (C) 2026 Dasik (Rifaditya) | GNU GPLv3
package net.vanillaoutsider.playerspeed.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.debug.DebugScreenDisplayer;
import net.minecraft.client.gui.components.debug.DebugScreenEntry;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.chunk.LevelChunk;
import net.minecraft.world.phys.Vec3;
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
                    Minecraft client = Minecraft.getInstance();
                    Entity entity = client.getCameraEntity();
                    if (entity == null) {
                        entity = client.player;
                    }
                    if (entity != null) {
                        Vec3 knownSpeed = entity.getKnownSpeed();
                        double horiz = Math.sqrt(knownSpeed.x * knownSpeed.x + knownSpeed.z * knownSpeed.z);
                        double vert = Math.abs(knownSpeed.y);
                        // Append horizontal (H) and vertical (V) speeds in blocks/tick matching vanilla 26.3 style
                        return String.format(Locale.ROOT, "%s (H: %.3f, V: %.3f)", original, horiz, vert);
                    }
                }
                return original;
            }
        };

        parent.display(spyDisplayer, level, clientChunk, serverChunk);
    }
}
