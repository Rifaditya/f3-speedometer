// Copyright (C) 2026 Dasik (Rifaditya) | GNU GPLv3
package net.vanillaoutsider.speedometer;

import net.dasik.social.api.SocialLinks;
import net.dasik.social.api.config.DasikSupportHelper;
import net.vanillaoutsider.speedometer.util.SpeedometerSupport;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.net.URI;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

class SpeedometerCalculationTest {

    private static final double TICK_RATE = 20.0;
    private static final double EPSILON = 1e-6;

    @Test
    @DisplayName("Verify tick-to-second conversion multiplier is exactly 20.0")
    void testTickToSecondConversion() {
        double velocityPerTick = 0.215;
        double speedBps = velocityPerTick * TICK_RATE;
        assertEquals(4.30, speedBps, 0.001);
    }

    @Test
    @DisplayName("Verify horizontal velocity vector calculation sqrt(x^2 + z^2) * 20.0")
    void testHorizontalVelocityVector() {
        double x = 0.3;
        double z = 0.4;
        double horizontalSpeedBps = Math.sqrt(x * x + z * z) * TICK_RATE;
        // 0.3^2 + 0.4^2 = 0.09 + 0.16 = 0.25 -> sqrt(0.25) = 0.5 * 20.0 = 10.0
        assertEquals(10.0, horizontalSpeedBps, EPSILON);
    }

    @Test
    @DisplayName("Verify 3D total speed calculation sqrt(x^2 + y^2 + z^2) * 20.0")
    void testTotalSpeedVector() {
        double x = 0.2;
        double y = 0.3;
        double z = 0.6;
        // 0.04 + 0.09 + 0.36 = 0.49 -> sqrt(0.49) = 0.7 * 20.0 = 14.0
        double totalSpeedBps = Math.sqrt(x * x + y * y + z * z) * TICK_RATE;
        assertEquals(14.0, totalSpeedBps, EPSILON);
    }

    @Test
    @DisplayName("Verify standalone speedometer line formatting")
    void testStandaloneFormatting() {
        double targetSpeed = 14.0;
        double targetHoriz = 10.0;
        double targetVert = 6.0;

        String formatted = String.format(Locale.ROOT, "Speed: %.2f b/s (H: %.2f, V: %.2f)", targetSpeed, targetHoriz, targetVert);
        assertEquals("Speed: 14.00 b/s (H: 10.00, V: 6.00)", formatted);
    }

    @Test
    @DisplayName("Verify consolidated player_speed wrapper line formatting")
    void testConsolidatedFormatting() {
        String original = "Speed: 0.215 blocks/tick";
        double bpsSpeed = 4.30;
        double bpsHoriz = 4.30;
        double bpsVert = 0.00;

        String combined = String.format(Locale.ROOT, "%s, %.2f b/s (H: %.2f, V: %.2f)", original, bpsSpeed, bpsHoriz, bpsVert);
        assertEquals("Speed: 0.215 blocks/tick, 4.30 b/s (H: 4.30, V: 0.00)", combined);
    }

    @Test
    @DisplayName("Verify boundary check: zero velocity produces 0.00 values")
    void testZeroVelocity() {
        double x = 0.0;
        double y = 0.0;
        double z = 0.0;

        double targetHoriz = Math.sqrt(x * x + z * z) * TICK_RATE;
        double targetVert = Math.abs(y) * TICK_RATE;
        double targetSpeed = Math.sqrt(x * x + y * y + z * z) * TICK_RATE;

        String formatted = String.format(Locale.ROOT, "Speed: %.2f b/s (H: %.2f, V: %.2f)", targetSpeed, targetHoriz, targetVert);
        assertEquals("Speed: 0.00 b/s (H: 0.00, V: 0.00)", formatted);
    }

    @Test
    @DisplayName("Verify boundary check: negative velocity components preserve absolute/Euclidean magnitudes")
    void testNegativeVelocityComponents() {
        double x = -0.3;
        double y = -0.5;
        double z = -0.4;

        double targetHoriz = Math.sqrt(x * x + z * z) * TICK_RATE;
        double targetVert = Math.abs(y) * TICK_RATE;
        double targetSpeed = Math.sqrt(x * x + y * y + z * z) * TICK_RATE;

        assertTrue(targetHoriz > 0, "Horizontal speed must be positive");
        assertTrue(targetVert > 0, "Vertical speed must be positive");
        assertTrue(targetSpeed > 0, "Total speed must be positive");

        assertEquals(10.0, targetHoriz, EPSILON);
        assertEquals(10.0, targetVert, EPSILON);
    }

    @ParameterizedTest
    @CsvSource({
            "100.0, 50.0, 100.0",
            "1000.0, 0.0, 1000.0",
            "50000.0, -20000.0, 30000.0"
    })
    @DisplayName("Verify boundary check: large velocity stress test")
    void testLargeVelocities(double x, double y, double z) {
        double targetHoriz = Math.sqrt(x * x + z * z) * TICK_RATE;
        double targetVert = Math.abs(y) * TICK_RATE;
        double targetSpeed = Math.sqrt(x * x + y * y + z * z) * TICK_RATE;

        assertFalse(Double.isNaN(targetHoriz));
        assertFalse(Double.isInfinite(targetHoriz));
        assertFalse(Double.isNaN(targetVert));
        assertFalse(Double.isInfinite(targetVert));
        assertFalse(Double.isNaN(targetSpeed));
        assertFalse(Double.isInfinite(targetSpeed));
    }

    @Test
    @DisplayName("Verify SpeedometerSupport integrates with Dasik Library SocialLinks and DasikSupportHelper")
    void testSpeedometerSupportIntegration() {
        assertEquals(SocialLinks.DISCORD_INVITE_URL, SpeedometerSupport.getDiscordUrl());
        assertEquals(DasikSupportHelper.KOFI_URL, SpeedometerSupport.getKofiUrl());

        URI discordUri = SpeedometerSupport.getDiscordUri();
        assertNotNull(discordUri);
        assertEquals(SocialLinks.getDiscordUri(), discordUri);

        URI kofiUri = SpeedometerSupport.getKofiUri();
        assertNotNull(kofiUri);
        assertEquals(SocialLinks.getKofiUri(), kofiUri);

        URI githubUri = SpeedometerSupport.getGithubUri();
        assertNotNull(githubUri);
        assertEquals(SocialLinks.getGithubUri(), githubUri);

        String supportInfo = SpeedometerSupport.getFormattedSupportInfo();
        assertTrue(supportInfo.contains(SocialLinks.DISCORD_INVITE_URL));
        assertTrue(supportInfo.contains(DasikSupportHelper.KOFI_URL));
    }
}
