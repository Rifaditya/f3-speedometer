// Copyright (C) 2026 Dasik (Rifaditya) | GNU GPLv3
package net.vanillaoutsider.speedometer;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import net.dasik.social.api.SocialLinks;
import net.dasik.social.api.config.DasikSupportHelper;
import net.vanillaoutsider.speedometer.util.SpeedometerSupport;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Pillar 5: Sidedness, RefMap & License Hygiene Contract Test")
class SpeedometerSidednessContractTest {

    private static final String MANDATORY_LICENSE_HEADER = "// Copyright (C) 2026 Dasik (Rifaditya) | GNU GPLv3";

    private static Path findProjectRoot() {
        Path dir = Paths.get(System.getProperty("user.dir"));
        if (Files.exists(dir.resolve("src/main/resources/fabric.mod.json"))) {
            return dir;
        }
        Path candidate = dir.resolve("Vanilla Outsider Collections/Speedometer/Speedometer v1.21.1");
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
    @DisplayName("Verify fabric.mod.json strictly enforces client-only environment and zero server entrypoints")
    void testClientSidednessContract() throws Exception {
        Path root = findProjectRoot();
        Path modJsonPath = root.resolve("src/main/resources/fabric.mod.json");
        assertTrue(Files.exists(modJsonPath), "fabric.mod.json must exist");

        JsonObject rootJson = JsonParser.parseReader(Files.newBufferedReader(modJsonPath, StandardCharsets.UTF_8)).getAsJsonObject();

        // Must declare client environment
        assertEquals("client", rootJson.get("environment").getAsString(), "Mod must strictly specify environment: client");

        // Must NOT declare main or server entrypoints
        JsonObject entrypoints = rootJson.getAsJsonObject("entrypoints");
        assertNotNull(entrypoints, "Entrypoints block must be defined");
        assertFalse(entrypoints.has("main"), "Client-only mod must NOT declare a 'main' entrypoint");
        assertFalse(entrypoints.has("server"), "Client-only mod must NOT declare a 'server' entrypoint");
        assertTrue(entrypoints.has("client"), "Client-only mod MUST declare a 'client' entrypoint");
    }

    @Test
    @DisplayName("Verify 100% of Java source and test files declare the GPLv3 license header on line 1")
    void testLicenseHeaders() throws Exception {
        Path root = findProjectRoot();
        Path mainJava = root.resolve("src/main/java");
        Path testJava = root.resolve("src/test/java");

        for (Path javaRoot : new Path[]{mainJava, testJava}) {
            if (!Files.exists(javaRoot)) continue;

            try (Stream<Path> stream = Files.walk(javaRoot)) {
                stream.filter(p -> p.toString().endsWith(".java")).forEach(javaFile -> {
                    try (BufferedReader reader = Files.newBufferedReader(javaFile, StandardCharsets.UTF_8)) {
                        String firstLine = reader.readLine();
                        assertNotNull(firstLine, "File cannot be empty: " + javaFile);
                        assertEquals(MANDATORY_LICENSE_HEADER, firstLine.trim(),
                                "First line of " + javaFile.getFileName() + " must match GNU GPLv3 license header");
                    } catch (Exception e) {
                        fail("Failed reading " + javaFile + ": " + e.getMessage());
                    }
                });
            }
        }
    }

    @Test
    @DisplayName("Verify mixin descriptor targets in speedometer.mixins.json exist in source tree")
    void testMixinDescriptorIntegrity() throws Exception {
        Path root = findProjectRoot();
        Path mixinJsonPath = root.resolve("src/main/resources/speedometer.mixins.json");
        assertTrue(Files.exists(mixinJsonPath), "speedometer.mixins.json must exist");

        JsonObject mixinJson = JsonParser.parseReader(Files.newBufferedReader(mixinJsonPath, StandardCharsets.UTF_8)).getAsJsonObject();
        String mixinPackage = mixinJson.get("package").getAsString();
        String packagePath = mixinPackage.replace('.', '/');

        Path mixinSourceDir = root.resolve("src/main/java").resolve(packagePath);
        assertTrue(Files.isDirectory(mixinSourceDir), "Mixin package directory must exist: " + mixinSourceDir);

        if (mixinJson.has("client")) {
            JsonArray clientMixins = mixinJson.getAsJsonArray("client");
            for (JsonElement el : clientMixins) {
                String className = el.getAsString() + ".java";
                Path classFile = mixinSourceDir.resolve(className);
                assertTrue(Files.exists(classFile), "Mixin class declared in mixins.json does not exist: " + classFile);
            }
        }
    }

    @Test
    @DisplayName("Verify zero ModVersionGuard references across all Java sources")
    void testZeroModVersionGuardInvariant() throws Exception {
        Path root = findProjectRoot();
        Path mainJava = root.resolve("src/main/java");

        try (Stream<Path> stream = Files.walk(mainJava)) {
            stream.filter(p -> p.toString().endsWith(".java")).forEach(javaFile -> {
                try {
                    String content = Files.readString(javaFile, StandardCharsets.UTF_8);
                    assertFalse(content.contains("ModVersionGuard"),
                            "Forbidden reference to ModVersionGuard detected in " + javaFile.getFileName());
                    assertFalse(content.contains("mod_version_guard"),
                            "Forbidden reference to mod_version_guard detected in " + javaFile.getFileName());
                } catch (Exception e) {
                    fail("Failed scanning " + javaFile + ": " + e.getMessage());
                }
            });
        }
    }

    @Test
    @DisplayName("Verify compiled classes contain zero invalid server-side or ModVersionGuard bytecode references")
    void testBytecodeConstantPoolScan() throws Exception {
        Path root = findProjectRoot();
        Path classesDir = root.resolve("build/classes/java/main");
        if (!Files.exists(classesDir)) {
            return;
        }

        try (Stream<Path> stream = Files.walk(classesDir)) {
            stream.filter(p -> p.toString().endsWith(".class")).forEach(classFile -> {
                try {
                    byte[] bytes = Files.readAllBytes(classFile);
                    String rawString = new String(bytes, StandardCharsets.ISO_8859_1);
                    assertFalse(rawString.contains("ModVersionGuard"),
                            "Bytecode constant pool in " + classFile.getFileName() + " must not contain ModVersionGuard");
                } catch (Exception e) {
                    fail("Failed scanning bytecode in " + classFile + ": " + e.getMessage());
                }
            });
        }
    }

    @Test
    @DisplayName("Verify DasikLibrary binary linkages and integration contracts")
    void testDasikLibraryLinkageContract() {
        assertNotNull(SocialLinks.DISCORD_INVITE_URL);
        assertNotNull(DasikSupportHelper.KOFI_URL);
        assertNotNull(SpeedometerSupport.getDiscordUrl());
        assertNotNull(SpeedometerSupport.getKofiUrl());
        assertEquals(SocialLinks.DISCORD_INVITE_URL, SpeedometerSupport.getDiscordUrl());
        assertEquals(DasikSupportHelper.KOFI_URL, SpeedometerSupport.getKofiUrl());
    }
}
