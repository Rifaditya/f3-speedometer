// Copyright (C) 2026 Dasik (Rifaditya) | GNU GPLv3
package net.vanillaoutsider.speedometer;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Pillar 4: Headless Client State Machine Simulation (DebugScreenOverlay)")
class SpeedometerStateSimulationTest {

    private static final double TICK_RATE = 20.0;

    /**
     * Simulated 3D deltaMovement vector.
     */
    record SimulatedVec3(double x, double y, double z) {
        public double length() {
            return Math.sqrt(x * x + y * y + z * z);
        }
    }

    /**
     * Simulated Entity representing Minecraft's player or vehicle.
     */
    static class SimulatedEntity {
        private final String name;
        private SimulatedVec3 deltaMovement;
        private SimulatedEntity vehicle;

        SimulatedEntity(String name, SimulatedVec3 deltaMovement) {
            this.name = name;
            this.deltaMovement = deltaMovement;
        }

        public SimulatedVec3 getDeltaMovement() {
            return deltaMovement;
        }

        public void setDeltaMovement(SimulatedVec3 deltaMovement) {
            this.deltaMovement = deltaMovement;
        }

        public SimulatedEntity getVehicle() {
            return vehicle;
        }

        public void setVehicle(SimulatedEntity vehicle) {
            this.vehicle = vehicle;
        }

        public String getName() {
            return name;
        }
    }

    /**
     * Simulated DebugScreenOverlay engine mimicking DebugScreenOverlayMixin logic.
     */
    static class SimulatedDebugOverlayEngine {
        private SimulatedEntity player;

        public void setPlayer(SimulatedEntity player) {
            this.player = player;
        }

        public void getGameInformation(List<String> lines, String translationTemplate) {
            if (player != null) {
                EntityResolution target = resolveEntity();
                SimulatedVec3 delta = target.entity().getDeltaMovement();
                double dx = delta.x();
                double dy = delta.y();
                double dz = delta.z();

                double total = Math.sqrt(dx * dx + dy * dy + dz * dz) * TICK_RATE;
                double horizontal = Math.sqrt(dx * dx + dz * dz) * TICK_RATE;
                double vertical = Math.abs(dy) * TICK_RATE;

                String sTotal = String.format(Locale.ROOT, "%.2f", total);
                String sHoriz = String.format(Locale.ROOT, "%.2f", horizontal);
                String sVert = String.format(Locale.ROOT, "%.2f", vertical);

                String text;
                if (translationTemplate != null && translationTemplate.contains("%s")) {
                    text = String.format(Locale.ROOT, "Speed: %s b/s (H: %s, V: %s)", sTotal, sHoriz, sVert);
                } else {
                    text = String.format(Locale.ROOT, "Speed: %.2f b/s (H: %.2f, V: %.2f)", total, horizontal, vertical);
                }

                if (text.equals("debug.entry.speedometer") || text.equals("Speedometer") || (!text.contains("%s") && !text.contains("b/s"))) {
                    text = String.format(Locale.ROOT, "Speed: %.2f b/s (H: %.2f, V: %.2f)", total, horizontal, vertical);
                }

                lines.add(text);
            }
        }

        public record EntityResolution(SimulatedEntity entity, boolean isVehicle) {}

        public EntityResolution resolveEntity() {
            if (player.getVehicle() != null) {
                return new EntityResolution(player.getVehicle(), true);
            }
            return new EntityResolution(player, false);
        }
    }

    @Test
    @DisplayName("Verify null player safely exits without adding debug line or throwing NPE")
    void testNullPlayerSafety() {
        SimulatedDebugOverlayEngine engine = new SimulatedDebugOverlayEngine();
        engine.setPlayer(null);

        List<String> lines = new ArrayList<>();
        engine.getGameInformation(lines, "Speed: %s b/s (H: %s, V: %s)");

        assertTrue(lines.isEmpty(), "Null player must not emit lines to debug overlay");
    }

    @Test
    @DisplayName("Verify vehicle riding resolution prioritizes vehicle deltaMovement over player")
    void testVehicleRidingPrioritization() {
        SimulatedDebugOverlayEngine engine = new SimulatedDebugOverlayEngine();

        SimulatedEntity player = new SimulatedEntity("Player", new SimulatedVec3(0.0, 0.0, 0.0));
        SimulatedEntity boat = new SimulatedEntity("Boat", new SimulatedVec3(1.5, 0.0, 2.0)); // 2.5 b/t * 20 = 50.0 b/s
        player.setVehicle(boat);

        engine.setPlayer(player);

        List<String> lines = new ArrayList<>();
        engine.getGameInformation(lines, "Speed: %s b/s (H: %s, V: %s)");

        assertEquals(1, lines.size());
        assertEquals("Speed: 50.00 b/s (H: 50.00, V: 0.00)", lines.get(0));
    }

    @Test
    @DisplayName("Verify zero deltaMovement correctly formats to 0.00 b/s")
    void testZeroMovement() {
        SimulatedDebugOverlayEngine engine = new SimulatedDebugOverlayEngine();
        SimulatedEntity player = new SimulatedEntity("Player", new SimulatedVec3(0.0, 0.0, 0.0));
        engine.setPlayer(player);

        List<String> lines = new ArrayList<>();
        engine.getGameInformation(lines, "Speed: %s b/s (H: %s, V: %s)");

        assertEquals(1, lines.size());
        assertEquals("Speed: 0.00 b/s (H: 0.00, V: 0.00)", lines.get(0));
    }

    @Test
    @DisplayName("Verify walking, free fall, and elytra movements calculate accurate speeds")
    void testMovementSimulations() {
        SimulatedDebugOverlayEngine engine = new SimulatedDebugOverlayEngine();
        List<String> lines = new ArrayList<>();

        // 1. Walking: 0.152 dx, 0.152 dz -> ~4.30 b/s
        SimulatedEntity player = new SimulatedEntity("Player", new SimulatedVec3(0.152, 0.0, 0.152));
        engine.setPlayer(player);
        engine.getGameInformation(lines, "Speed: %s b/s (H: %s, V: %s)");
        String walkLine = lines.get(0);
        assertTrue(walkLine.contains("Speed: 4.30 b/s"));
        assertTrue(walkLine.contains("H: 4.30"));
        assertTrue(walkLine.contains("V: 0.00"));

        // 2. Free fall: purely vertical 0.5 dy -> 10.00 b/s
        lines.clear();
        player.setDeltaMovement(new SimulatedVec3(0.0, -0.5, 0.0));
        engine.getGameInformation(lines, "Speed: %s b/s (H: %s, V: %s)");
        String fallLine = lines.get(0);
        assertTrue(fallLine.contains("Speed: 10.00 b/s"));
        assertTrue(fallLine.contains("H: 0.00"));
        assertTrue(fallLine.contains("V: 10.00"));

        // 3. Elytra rocket boost: 3D vector
        lines.clear();
        player.setDeltaMovement(new SimulatedVec3(1.2, 0.5, 1.6));
        engine.getGameInformation(lines, "Speed: %s b/s (H: %s, V: %s)");
        String elytraLine = lines.get(0);
        assertNotNull(elytraLine);
        assertTrue(elytraLine.startsWith("Speed: "));
    }

    @Test
    @DisplayName("Verify fallback formatting when translation key fails")
    void testTranslationFallbackLogic() {
        SimulatedDebugOverlayEngine engine = new SimulatedDebugOverlayEngine();
        SimulatedEntity player = new SimulatedEntity("Player", new SimulatedVec3(0.3, 0.4, 0.0));
        engine.setPlayer(player);

        List<String> lines = new ArrayList<>();
        // Simulate untranslated key returning raw key name
        engine.getGameInformation(lines, "debug.entry.speedometer");

        assertEquals(1, lines.size());
        assertEquals("Speed: 10.00 b/s (H: 6.00, V: 8.00)", lines.get(0));
    }

    @Test
    @DisplayName("Verify negative velocity components preserve non-negative speed values")
    void testNegativeVelocityComponents() {
        SimulatedDebugOverlayEngine engine = new SimulatedDebugOverlayEngine();
        SimulatedEntity player = new SimulatedEntity("Player", new SimulatedVec3(-0.3, -0.4, 0.0));
        engine.setPlayer(player);

        List<String> lines = new ArrayList<>();
        engine.getGameInformation(lines, "Speed: %s b/s (H: %s, V: %s)");

        assertEquals(1, lines.size());
        assertEquals("Speed: 10.00 b/s (H: 6.00, V: 8.00)", lines.get(0));
    }
}
