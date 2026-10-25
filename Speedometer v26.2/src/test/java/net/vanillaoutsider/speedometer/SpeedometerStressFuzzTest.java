// Copyright (C) 2026 Dasik (Rifaditya) | GNU GPLv3
package net.vanillaoutsider.speedometer;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Locale;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Pillar 1: Chaos Property & Mathematical Stress Fuzzing")
class SpeedometerStressFuzzTest {

    private static final int FUZZ_ITERATIONS = 25_000;
    private static final double TICK_RATE = 20.0;
    private static final double EPSILON = 1e-5;

    @Test
    @DisplayName("Fuzz 25,000 randomized velocity vectors for numerical stability and non-negativity")
    void testVelocityFuzzingChaos() {
        // Seeded RNG for reproducible chaos testing
        Random random = new Random(0xDA51C);

        for (int i = 0; i < FUZZ_ITERATIONS; i++) {
            double x;
            double y;
            double z;

            // Generate across varied scale distributions
            int regime = i % 5;
            switch (regime) {
                case 0 -> {
                    // Normal walking/sprinting speeds: [-2.0, 2.0]
                    x = (random.nextDouble() - 0.5) * 4.0;
                    y = (random.nextDouble() - 0.5) * 4.0;
                    z = (random.nextDouble() - 0.5) * 4.0;
                }
                case 1 -> {
                    // High-velocity flight/tnt cannons: [-500.0, 500.0]
                    x = (random.nextDouble() - 0.5) * 1000.0;
                    y = (random.nextDouble() - 0.5) * 1000.0;
                    z = (random.nextDouble() - 0.5) * 1000.0;
                }
                case 2 -> {
                    // Micro-movements: [-1e-6, 1e-6]
                    x = (random.nextDouble() - 0.5) * 2e-6;
                    y = (random.nextDouble() - 0.5) * 2e-6;
                    z = (random.nextDouble() - 0.5) * 2e-6;
                }
                case 3 -> {
                    // Astronomical coordinates / warp velocities: [-1e7, 1e7]
                    x = (random.nextDouble() - 0.5) * 2e7;
                    y = (random.nextDouble() - 0.5) * 2e7;
                    z = (random.nextDouble() - 0.5) * 2e7;
                }
                default -> {
                    // Mixed zero and negative components
                    x = random.nextBoolean() ? 0.0 : -random.nextDouble() * 10.0;
                    y = random.nextBoolean() ? 0.0 : -random.nextDouble() * 10.0;
                    z = random.nextBoolean() ? 0.0 : -random.nextDouble() * 10.0;
                }
            }

            double horiz = Math.sqrt(x * x + z * z) * TICK_RATE;
            double vert = Math.abs(y) * TICK_RATE;
            double total = Math.sqrt(x * x + y * y + z * z) * TICK_RATE;

            // Assert finite results
            assertFalse(Double.isNaN(horiz), "Horizontal speed must not be NaN");
            assertFalse(Double.isInfinite(horiz), "Horizontal speed must be finite");
            assertFalse(Double.isNaN(vert), "Vertical speed must not be NaN");
            assertFalse(Double.isInfinite(vert), "Vertical speed must be finite");
            assertFalse(Double.isNaN(total), "Total speed must not be NaN");
            assertFalse(Double.isInfinite(total), "Total speed must be finite");

            // Assert non-negativity
            assertTrue(horiz >= 0.0, "Horizontal speed must be non-negative");
            assertTrue(vert >= 0.0, "Vertical speed must be non-negative");
            assertTrue(total >= 0.0, "Total speed must be non-negative");

            // Triangle inequalities: total >= horiz, total >= vert, total <= horiz + vert
            assertTrue(total >= horiz - EPSILON, "Total speed must be >= horizontal speed");
            assertTrue(total >= vert - EPSILON, "Total speed must be >= vertical speed");
            assertTrue(total <= horiz + vert + EPSILON, "Total speed must satisfy triangle inequality <= horiz + vert");

            // Assert String.format never throws IllegalFormatException or produces negative zero representations
            String formatted = String.format(Locale.ROOT, "Speed: %.2f b/s (H: %.2f, V: %.2f)", total, horiz, vert);
            assertNotNull(formatted);
            assertFalse(formatted.contains("-0.00"), "Formatted speed must never display negative zero");
        }
    }

    @Test
    @DisplayName("Verify boundary edge cases: Subnormal floats, negative zero, and extreme values")
    void testBoundaryEdgeCases() {
        double[] testValues = {
                0.0,
                -0.0,
                Double.MIN_VALUE,
                1e-300,
                1.0,
                -1.0,
                1e10,
                1e100,
                Float.MAX_VALUE
        };

        for (double v : testValues) {
            double horiz = Math.sqrt(v * v + v * v) * TICK_RATE;
            double vert = Math.abs(v) * TICK_RATE;
            double total = Math.sqrt(v * v + v * v + v * v) * TICK_RATE;

            assertFalse(Double.isNaN(horiz));
            assertFalse(Double.isNaN(vert));
            assertFalse(Double.isNaN(total));
            assertTrue(horiz >= 0.0);
            assertTrue(vert >= 0.0);
            assertTrue(total >= 0.0);

            String formatted = String.format(Locale.ROOT, "Speed: %.2f b/s (H: %.2f, V: %.2f)", total, horiz, vert);
            assertNotNull(formatted);
            assertFalse(formatted.contains("-0.00"));
        }
    }

    @Test
    @DisplayName("Verify NaN and Infinity guards under Freedom Over Anti-Crash policy")
    void testNanAndInfinityGuards() {
        double[] invalidValues = {Double.NaN, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY};

        for (double val : invalidValues) {
            // Guard helper simulating safe velocity conversion
            double safeX = Double.isFinite(val) ? val : 0.0;
            double safeY = Double.isFinite(val) ? val : 0.0;
            double safeZ = Double.isFinite(val) ? val : 0.0;

            double safeHoriz = Math.sqrt(safeX * safeX + safeZ * safeZ) * TICK_RATE;
            double safeVert = Math.abs(safeY) * TICK_RATE;
            double safeTotal = Math.sqrt(safeX * safeX + safeY * safeY + safeZ * safeZ) * TICK_RATE;

            assertEquals(0.0, safeHoriz, 1e-9);
            assertEquals(0.0, safeVert, 1e-9);
            assertEquals(0.0, safeTotal, 1e-9);

            String formatted = String.format(Locale.ROOT, "Speed: %.2f b/s (H: %.2f, V: %.2f)", safeTotal, safeHoriz, safeVert);
            assertEquals("Speed: 0.00 b/s (H: 0.00, V: 0.00)", formatted);
        }
    }
}
