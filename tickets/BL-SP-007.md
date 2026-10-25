# 🎫 [BL-SP-007] Adopt 5-Pillar Testing & Sidedness Verification Harness

- **Ticket ID**: `[BL-SP-007]`
- **Category**: `[TECH_DEBT]`
- **Priority**: `[MEDIUM]`
- **Scope**: `All Anchors` (`1.20.1`, `1.21.1`, `1.21.11`, `26.1.2`, `26.2`, `26.3`)
- **Status**: `📌 DEFERRED`
- **Target Repository / Root**: `Vanilla Outsider Collections\Speedometer`

---

## 🎯 1. Problem Statement & Player Impact
Currently, `Speedometer` lacks the studio's mandatory 5-Pillar Testing Harness. As a pure client-side mod (`"environment": "client"` in `fabric.mod.json`), Speedometer contains no server GameRules and no server Brigadier commands. Under the Studio Constitution's *Client-Only Mod 5-Pillar Adaptation Doctrine* ([gradle-tester](../../../.agents/skills/gradle-tester/SKILL.md)), applying server-side command and GameTest assertions is invalid. Instead, adopting the client-adapted 5-Pillar Harness (Chaos Velocity Fuzzing, Virtual Concurrency Load, Translation & ModMenu AST, Headless Client State Simulation, and Sidedness & License Hygiene Contract) guarantees rock-solid runtime stability, zero-crash velocity math, and Knot ClassLoader safety for players across all Minecraft version anchors.

## 🔬 2. Architectural Blueprint & Target Classes
- Test Package: `net.vanillaoutsider.speedometer` (in `src/test/java/net/vanillaoutsider/speedometer/`)
- Target Test Classes to Implement (Client-Only 5-Pillar Adaptation):
  1. `SpeedometerStressFuzzTest.java` (Pillar 1 - Chaos Property & Mathematical Stress Fuzzing):
     - Executes 20,000 to 50,000 randomized iterations validating velocity calculation math, Euclidean norms, zero-vector handling, astronomical velocities, negative delta movements, and `NaN`/`Infinity` guards under the Freedom Over Anti-Crash policy.
  2. `SpeedometerConcurrencyLoadTest.java` (Pillar 2 - Virtual Concurrency & Thread-Safety Load Simulator):
     - Stresses speed formatting routines, `SpeedometerSupport` metadata integration, and concurrent queries across 50 virtual worker threads to verify lock-free safety and zero race conditions.
  3. `SpeedometerAssetTranslationTest.java` (Pillar 3 - ModMenu & Translation AST Verification):
     - Headlessly parses `assets/speedometer/lang/en_us.json` (and all regional languages), verifying 100% key coverage, zero placeholder strings, and valid ModMenu donation/support links in `fabric.mod.json`.
  4. `SpeedometerStateSimulationTest.java` (Pillar 4 - Headless Client State Machine Simulation):
     - Headlessly simulates client HUD state transitions, player camera entity resolution (riding vehicle vs walking player), native `player_speed` wrapper delegation, and format string composition without requiring OpenGL or an active display (`-Djava.awt.headless=true`).
  5. `SpeedometerSidednessContractTest.java` (Pillar 5 - Sidedness, RefMap & License Hygiene Contract Test):
     - Automated source/bytecode scanner asserting `fabric.mod.json` declares `"environment": "client"`, 0 server entrypoints, 100% single-line GPLv3 license headers, valid Mixin classes in `speedometer.mixins.json`, zero `ModVersionGuard` references, and valid DasikLibrary binary linkages.

## ⚓ 3. Multi-Era Anchor Parity Specifications
- **MC 1.20.1 & MC 1.21.1 (Legacy & Transitional Anchors)**: JUnit 5 test harness, legacy Fabric Loader test runners, Mojang mappings assertions, `DebugScreenOverlayMixin` target validation.
- **MC 1.21.11 (Transitional Modern Anchor)**: `DebugScreenEntriesMixin` & `DebugScreenEntryListMixin` target validation, DataComponent era compatibility.
- **MC 26.1.2, MC 26.2, MC 26.3+ (Sovereign Lead Anchors - Java 25)**: Modern Loom 1.15+ test runner, `Entity.getKnownSpeed()` velocity assertions, saturation arithmetic bounds.

## 🛡️ 4. Edge Cases, Collisions & Failure Modes
- Dedicated Server Headless Execution: zero client classes loaded on dedicated server or headless test runner; verifies Knot ClassLoader runtime safety.
- Numerical Saturation: extreme coordinate/velocity values (`Double.MAX_VALUE`, `Double.MIN_VALUE`, subnormal floats) must never produce `NaN`/`Infinity` or crash (Freedom Over Anti-Crash policy).
- Zero Entity / Null Player State: Camera entity null during dimension transitions or early join must safely produce `0.00 b/s` fallback without `NullPointerException`.

## 🚀 5. Implementation Steps (Code-Level Plan)
1. Reconcile working tree clean baseline (Step 0 quarantine).
2. Author Pillar 1 (`SpeedometerStressFuzzTest.java`), Pillar 2 (`SpeedometerConcurrencyLoadTest.java`), Pillar 3 (`SpeedometerAssetTranslationTest.java`), Pillar 4 (`SpeedometerStateSimulationTest.java`), and Pillar 5 (`SpeedometerSidednessContractTest.java`) in Modern Sovereign Lead Anchors (`26.3`, `26.2`, `26.1.2`).
3. Backport and adapt 5-Pillar Test Suite to Legacy and Transitional Anchors (`1.21.11`, `1.21.1`, `1.20.1`).
4. Execute `./gradlew test --no-daemon --console=plain` and `./gradlew build` across all anchors to certify 100% green pass.
5. Synchronize studio boards, release queues, and clean sweep `BACKLOG.md`.

## 🏁 6. 5-Pillar Verification Checklist
- [ ] **Pillar 1 (Chaos Fuzzing)**: Chaos velocity & coordinate fuzzing passes 20k-50k iterations.
- [ ] **Pillar 2 (Concurrency Load)**: Concurrency harness passes 50 virtual threads with zero race conditions.
- [ ] **Pillar 3 (Translation & ModMenu AST)**: Language keys and `fabric.mod.json` links headlessly validated.
- [ ] **Pillar 4 (Client State Simulation)**: Headless entity camera resolution and wrapper delegation simulated cleanly.
- [ ] **Pillar 5 (Sidedness & Hygiene)**: Sidedness contract asserts `"environment": "client"`, 0 server entrypoints, 100% single-line GPLv3 headers, zero `ModVersionGuard`.
- [ ] **Anchor Compilation**: Clean `./gradlew test` and `./gradlew build` across all 6 targeted anchors.
