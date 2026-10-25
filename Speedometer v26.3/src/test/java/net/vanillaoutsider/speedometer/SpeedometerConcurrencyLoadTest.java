// Copyright (C) 2026 Dasik (Rifaditya) | GNU GPLv3
package net.vanillaoutsider.speedometer;

import net.vanillaoutsider.speedometer.util.SpeedometerSupport;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Pillar 2: Virtual Concurrency & Thread-Safety Load Simulator")
class SpeedometerConcurrencyLoadTest {

    private static final int CONCURRENT_THREADS = 50;
    private static final int TASKS_PER_THREAD = 500;
    private static final double TICK_RATE = 20.0;

    @Test
    @DisplayName("Stress 50 virtual threads executing concurrent velocity calculations, formatting, and support queries")
    void testVirtualConcurrencyLoad() throws Exception {
        ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor();
        List<Future<Void>> futures = new ArrayList<>(CONCURRENT_THREADS);

        for (int t = 0; t < CONCURRENT_THREADS; t++) {
            final int threadId = t;
            futures.add(executor.submit(() -> {
                for (int i = 0; i < TASKS_PER_THREAD; i++) {
                    // 1. Math and formatting
                    double x = (threadId * 0.1) + (i * 0.002);
                    double y = (i % 10) * 0.05;
                    double z = (threadId * 0.05) + (i * 0.001);

                    double horiz = Math.sqrt(x * x + z * z) * TICK_RATE;
                    double vert = Math.abs(y) * TICK_RATE;
                    double total = Math.sqrt(x * x + y * y + z * z) * TICK_RATE;

                    String standalone = String.format(Locale.ROOT, "Speed: %.2f b/s (H: %.2f, V: %.2f)", total, horiz, vert);
                    assertNotNull(standalone);
                    assertTrue(standalone.startsWith("Speed: "));

                    // 2. Wrapper string composition
                    String original = String.format(Locale.ROOT, "Speed: %.3f blocks/tick", Math.sqrt(x * x + y * y + z * z));
                    String combined = String.format(Locale.ROOT, "%s, %.2f b/s (H: %.2f, V: %.2f)", original, total, horiz, vert);
                    assertNotNull(combined);
                    assertTrue(combined.contains("blocks/tick, "));

                    // 3. SpeedometerSupport queries (immutable links)
                    String discordUrl = SpeedometerSupport.getDiscordUrl();
                    String kofiUrl = SpeedometerSupport.getKofiUrl();
                    URI discordUri = SpeedometerSupport.getDiscordUri();
                    URI kofiUri = SpeedometerSupport.getKofiUri();
                    URI githubUri = SpeedometerSupport.getGithubUri();
                    String supportInfo = SpeedometerSupport.getFormattedSupportInfo();

                    assertNotNull(discordUrl);
                    assertNotNull(kofiUrl);
                    assertNotNull(discordUri);
                    assertNotNull(kofiUri);
                    assertNotNull(githubUri);
                    assertTrue(supportInfo.contains("Discord:"));
                    assertTrue(supportInfo.contains("Ko-fi:"));
                }
                return null;
            }));
        }

        // Await all tasks to finish within 15 seconds
        for (Future<Void> future : futures) {
            assertDoesNotThrow(() -> future.get(15, TimeUnit.SECONDS), "Virtual thread task failed or timed out");
        }

        executor.shutdown();
        assertTrue(executor.awaitTermination(5, TimeUnit.SECONDS));
    }
}
