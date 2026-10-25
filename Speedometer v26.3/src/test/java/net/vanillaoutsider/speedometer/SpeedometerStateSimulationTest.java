// Copyright (C) 2026 Dasik (Rifaditya) | GNU GPLv3
package net.vanillaoutsider.speedometer;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Pillar 4: Headless Client State Machine Simulation")
class SpeedometerStateSimulationTest {

    private static final double TICK_RATE = 20.0;

    /**
     * Simulated 3D vector representing Minecraft's Vec3 tick-based knownSpeed.
     */
    record SimulatedVec3(double x, double y, double z) {
        public double length() {
            return Math.sqrt(x * x + y * y + z * z);
        }
    }

    /**
     * Simulated Entity representing Minecraft's camera or player entity.
     */
    static class SimulatedEntity {
        private final String name;
        private SimulatedVec3 knownSpeed;

        SimulatedEntity(String name, SimulatedVec3 knownSpeed) {
            this.name = name;
            this.knownSpeed = knownSpeed;
        }

        public SimulatedVec3 getKnownSpeed() {
            return knownSpeed;
        }

        public void setKnownSpeed(SimulatedVec3 knownSpeed) {
            this.knownSpeed = knownSpeed;
        }

        public String getName() {
            return name;
        }
    }

    /**
     * Simulated DebugScreenDisplayer capturing emitted lines.
     */
    static class SimulatedDisplayer {
        private final List<String> lines = new ArrayList<>();

        public void addLine(String line) {
            lines.add(line);
        }

        public List<String> getLines() {
            return lines;
        }

        public void clear() {
            lines.clear();
        }
    }

    /**
     * Simulated state engine mimicking DebugEntrySpeedometer and DebugEntryPlayerSpeedWrapper logic.
     */
    static class SimulatedSpeedometerEngine {
        private SimulatedEntity cameraEntity;
        private SimulatedEntity playerEntity;
        private boolean speedometerEnabled = true;
        private boolean nativePlayerSpeedEnabled = false;

        public void setCameraEntity(SimulatedEntity cameraEntity) {
            this.cameraEntity = cameraEntity;
        }

        public void setPlayerEntity(SimulatedEntity playerEntity) {
            this.playerEntity = playerEntity;
        }

        public void setSpeedometerEnabled(boolean speedometerEnabled) {
            this.speedometerEnabled = speedometerEnabled;
        }

        public void setNativePlayerSpeedEnabled(boolean nativePlayerSpeedEnabled) {
            this.nativePlayerSpeedEnabled = nativePlayerSpeedEnabled;
        }

        public SimulatedEntity resolveTargetEntity() {
            if (cameraEntity != null) {
                return cameraEntity;
            }
            return playerEntity;
        }

        public void displayStandalone(SimulatedDisplayer displayer) {
            // If vanilla native player_speed is enabled, standalone displayer yields to wrapper
            if (nativePlayerSpeedEnabled) {
                return;
            }

            SimulatedEntity target = resolveTargetEntity();
            if (target == null) {
                displayer.addLine("Speed: 0.00 b/s (H: 0.00, V: 0.00)");
                return;
            }

            SimulatedVec3 knownSpeed = target.getKnownSpeed();
            double targetHoriz = Math.sqrt(knownSpeed.x() * knownSpeed.x() + knownSpeed.z() * knownSpeed.z()) * TICK_RATE;
            double targetVert = Math.abs(knownSpeed.y()) * TICK_RATE;
            double targetSpeed = knownSpeed.length() * TICK_RATE;

            String line = String.format(Locale.ROOT, "Speed: %.2f b/s (H: %.2f, V: %.2f)", targetSpeed, targetHoriz, targetVert);
            displayer.addLine(line);
        }

        public String processWrapperLine(String original) {
            if (speedometerEnabled) {
                if (original != null && original.startsWith("Speed: ")) {
                    SimulatedEntity target = resolveTargetEntity();
                    if (target != null) {
                        SimulatedVec3 knownSpeed = target.getKnownSpeed();
                        double bpsSpeed = knownSpeed.length() * TICK_RATE;
                        double bpsHoriz = Math.sqrt(knownSpeed.x() * knownSpeed.x() + knownSpeed.z() * knownSpeed.z()) * TICK_RATE;
                        double bpsVert = Math.abs(knownSpeed.y()) * TICK_RATE;
                        return String.format(Locale.ROOT, "%s, %.2f b/s (H: %.2f, V: %.2f)", original, bpsSpeed, bpsHoriz, bpsVert);
                    }
                }
            }
            return original;
        }
    }

    @Test
    @DisplayName("Verify null camera and null player entity safely yield 0.00 fallback without NPE")
    void testNullEntitySafety() {
        SimulatedSpeedometerEngine engine = new SimulatedSpeedometerEngine();
        engine.setCameraEntity(null);
        engine.setPlayerEntity(null);

        SimulatedDisplayer displayer = new SimulatedDisplayer();
        engine.displayStandalone(displayer);

        assertEquals(1, displayer.getLines().size());
        assertEquals("Speed: 0.00 b/s (H: 0.00, V: 0.00)", displayer.getLines().get(0));
    }

    @Test
    @DisplayName("Verify camera entity resolution prioritizes vehicle over player entity")
    void testVehicleCameraResolution() {
        SimulatedSpeedometerEngine engine = new SimulatedSpeedometerEngine();

        SimulatedEntity player = new SimulatedEntity("Player", new SimulatedVec3(0.0, 0.0, 0.0));
        SimulatedEntity iceBoat = new SimulatedEntity("Boat", new SimulatedVec3(1.5, 0.0, 2.0)); // 2.5 b/t * 20 = 50 b/s

        engine.setPlayerEntity(player);
        engine.setCameraEntity(iceBoat);

        SimulatedDisplayer displayer = new SimulatedDisplayer();
        engine.displayStandalone(displayer);

        assertEquals(1, displayer.getLines().size());
        assertEquals("Speed: 50.00 b/s (H: 50.00, V: 0.00)", displayer.getLines().get(0));
    }

    @Test
    @DisplayName("Verify standalone display yields when native player_speed is also enabled")
    void testNativePlayerSpeedYielding() {
        SimulatedSpeedometerEngine engine = new SimulatedSpeedometerEngine();
        SimulatedEntity player = new SimulatedEntity("Player", new SimulatedVec3(0.15, 0.0, 0.20));

        engine.setPlayerEntity(player);
        engine.setCameraEntity(player);
        engine.setNativePlayerSpeedEnabled(true);

        SimulatedDisplayer displayer = new SimulatedDisplayer();
        engine.displayStandalone(displayer);

        // Standalone must not add a duplicate line
        assertTrue(displayer.getLines().isEmpty(), "Standalone line must yield when native player_speed is enabled");
    }

    @Test
    @DisplayName("Verify wrapper modifies Speed line when enabled and passes through non-speed lines unmodified")
    void testWrapperInterception() {
        SimulatedSpeedometerEngine engine = new SimulatedSpeedometerEngine();
        SimulatedEntity player = new SimulatedEntity("Player", new SimulatedVec3(0.215, 0.0, 0.0));
        engine.setPlayerEntity(player);
        engine.setCameraEntity(player);
        engine.setSpeedometerEnabled(true);

        // 1. Intercept speed line
        String original = "Speed: 0.215 blocks/tick";
        String intercepted = engine.processWrapperLine(original);
        assertEquals("Speed: 0.215 blocks/tick, 4.30 b/s (H: 4.30, V: 0.00)", intercepted);

        // 2. Non-speed line passes through untouched
        String nonSpeed = "XYZ: 125.432 / 64.000 / -432.123";
        assertEquals(nonSpeed, engine.processWrapperLine(nonSpeed));

        // 3. When speedometer is disabled, original line passes through unmodified
        engine.setSpeedometerEnabled(false);
        assertEquals(original, engine.processWrapperLine(original));
    }

    @Test
    @DisplayName("Verify multi-movement simulations: walking, falling, and elytra flight")
    void testMovementSimulations() {
        SimulatedSpeedometerEngine engine = new SimulatedSpeedometerEngine();
        SimulatedDisplayer displayer = new SimulatedDisplayer();

        // 1. Walking: ~4.30 b/s horizontal
        SimulatedEntity player = new SimulatedEntity("Player", new SimulatedVec3(0.152, 0.0, 0.152));
        engine.setPlayerEntity(player);
        engine.displayStandalone(displayer);
        String walkLine = displayer.getLines().get(0);
        assertTrue(walkLine.contains("Speed: 4.30 b/s"));
        assertTrue(walkLine.contains("H: 4.30"));
        assertTrue(walkLine.contains("V: 0.00"));

        // 2. Free fall: purely vertical ~10.00 b/s
        displayer.clear();
        player.setKnownSpeed(new SimulatedVec3(0.0, -0.5, 0.0));
        engine.displayStandalone(displayer);
        String fallLine = displayer.getLines().get(0);
        assertTrue(fallLine.contains("Speed: 10.00 b/s"));
        assertTrue(fallLine.contains("H: 0.00"));
        assertTrue(fallLine.contains("V: 10.00"));

        // 3. Elytra rocket boost: 3D velocity
        displayer.clear();
        player.setKnownSpeed(new SimulatedVec3(1.2, 0.5, 1.6));
        engine.displayStandalone(displayer);
        String elytraLine = displayer.getLines().get(0);
        assertNotNull(elytraLine);
        assertTrue(elytraLine.startsWith("Speed: "));
    }
}
