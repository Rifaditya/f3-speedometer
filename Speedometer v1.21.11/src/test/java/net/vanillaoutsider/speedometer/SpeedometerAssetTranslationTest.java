// Copyright (C) 2026 Dasik (Rifaditya) | GNU GPLv3
package net.vanillaoutsider.speedometer;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.InputStreamReader;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Pillar 3: ModMenu & Translation AST Verification")
class SpeedometerAssetTranslationTest {

    private static Path findProjectRoot() {
        Path dir = Paths.get(System.getProperty("user.dir"));
        if (Files.exists(dir.resolve("src/main/resources/fabric.mod.json"))) {
            return dir;
        }
        Path candidate = dir.resolve("Vanilla Outsider Collections/Speedometer/Speedometer v1.21.11");
        if (Files.exists(candidate.resolve("src/main/resources/fabric.mod.json"))) {
            return candidate;
        }
        Path current = dir;
        while (current != null) {
            if (Files.exists(current.resolve("src/main/resources/fabric.mod.json"))) {
                return current;
            }
            current = current.getParent();
        }
        return dir;
    }

    @Test
    @DisplayName("Verify fabric.mod.json ModMenu links and metadata contract")
    void testFabricModJsonMetadata() throws Exception {
        Path root = findProjectRoot();
        Path modJsonPath = root.resolve("src/main/resources/fabric.mod.json");
        assertTrue(Files.exists(modJsonPath), "fabric.mod.json must exist at " + modJsonPath);

        JsonObject rootJson = JsonParser.parseReader(Files.newBufferedReader(modJsonPath, StandardCharsets.UTF_8)).getAsJsonObject();

        assertEquals("speedometer", rootJson.get("id").getAsString());
        assertEquals("client", rootJson.get("environment").getAsString());
        assertEquals("GPL-3.0-or-later", rootJson.get("license").getAsString());

        assertTrue(rootJson.has("custom"), "fabric.mod.json must have 'custom' block");
        JsonObject custom = rootJson.getAsJsonObject("custom");
        assertTrue(custom.has("modmenu"), "'custom' block must contain 'modmenu'");
        JsonObject modmenu = custom.getAsJsonObject("modmenu");
        assertTrue(modmenu.has("links"), "'modmenu' must contain 'links'");
        JsonObject links = modmenu.getAsJsonObject("links");

        assertTrue(links.has("modmenu.donate"), "ModMenu links must declare modmenu.donate");
        assertTrue(links.has("modmenu.kofi"), "ModMenu links must declare modmenu.kofi");
        assertTrue(links.has("modmenu.discord"), "ModMenu links must declare modmenu.discord");

        String donate = links.get("modmenu.donate").getAsString();
        String kofi = links.get("modmenu.kofi").getAsString();
        String discord = links.get("modmenu.discord").getAsString();

        assertDoesNotThrow(() -> URI.create(donate));
        assertDoesNotThrow(() -> URI.create(kofi));
        assertDoesNotThrow(() -> URI.create(discord));

        assertTrue(donate.startsWith("https://ko-fi.com/"));
        assertTrue(kofi.startsWith("https://ko-fi.com/"));
        assertTrue(discord.startsWith("https://discord.gg/"));
    }

    @Test
    @DisplayName("Verify 100% key coverage and zero placeholder strings across all lang files")
    void testLanguageFilesCompleteness() throws Exception {
        Path root = findProjectRoot();
        Path langDir = root.resolve("src/main/resources/assets/speedometer/lang");
        assertTrue(Files.isDirectory(langDir), "Lang directory must exist at " + langDir);

        Path enUsPath = langDir.resolve("en_us.json");
        assertTrue(Files.exists(enUsPath), "en_us.json must exist as baseline translation");

        JsonObject enUs = JsonParser.parseReader(Files.newBufferedReader(enUsPath, StandardCharsets.UTF_8)).getAsJsonObject();
        assertTrue(enUs.has("debug.entry.speedometer"));
        assertTrue(enUs.has("modmenu.nameTranslation.speedometer"));
        assertTrue(enUs.has("modmenu.descriptionTranslation.speedometer"));

        try (Stream<Path> stream = Files.list(langDir)) {
            stream.filter(p -> p.getFileName().toString().endsWith(".json")).forEach(langFile -> {
                try {
                    JsonObject json = JsonParser.parseReader(Files.newBufferedReader(langFile, StandardCharsets.UTF_8)).getAsJsonObject();
                    for (Map.Entry<String, JsonElement> entry : enUs.entrySet()) {
                        String key = entry.getKey();
                        assertTrue(json.has(key), "File " + langFile.getFileName() + " is missing key: " + key);
                        String value = json.get(key).getAsString();
                        assertNotNull(value, "Value for key " + key + " in " + langFile.getFileName() + " is null");
                        assertFalse(value.trim().isEmpty(), "Value for key " + key + " in " + langFile.getFileName() + " is empty");
                        assertFalse(value.contains("TODO"), "Placeholder 'TODO' found in " + langFile.getFileName() + " for " + key);
                        assertFalse(value.contains("FIXME"), "Placeholder 'FIXME' found in " + langFile.getFileName() + " for " + key);
                        assertFalse(value.contains("UNTRANSLATED"), "Placeholder 'UNTRANSLATED' found in " + langFile.getFileName() + " for " + key);
                    }
                } catch (Exception e) {
                    fail("Failed to parse language file: " + langFile.getFileName() + " - " + e.getMessage());
                }
            });
        }
    }
}
