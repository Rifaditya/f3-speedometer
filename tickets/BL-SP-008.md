# 🎫 [BL-SP-008] Purge Obsolete ModVersionGuard Knot ClassLoader Crash & Release 1.2.14+26.3

- **Ticket ID**: `[BL-SP-008]`
- **Category**: `[BUGFIX]`
- **Priority**: `[HIGH]`
- **Scope**: `MC 26.3` (Sovereign Modern Anchor)
- **Status**: `🚧 IN_PROGRESS`
- **Target Repository / Root**: `Vanilla Outsider Collections\Speedometer`

---

## 🎯 1. Problem Statement & Player Impact
In Minecraft 26.3 with Dasik Library 1.11.2 installed, launching the client triggers an immediate fatal crash:
`java.lang.NoClassDefFoundError: net/dasik/social/util/ModVersionGuard` at `net.vanillaoutsider.speedometer.client.SpeedometerClient.onInitializeClient()`.
This prevents players from starting Minecraft 26.3 whenever Speedometer 1.2.13+26.3 is loaded.
The root cause is that `SpeedometerClient.java` in anchor 26.3 still imported and called `net.dasik.social.util.ModVersionGuard.checkClass(...)`, which was an obsolete reflection check purged from Dasik Library 1.11.2+ under the Studio Constitution's *Comprehensive Legacy Guard Purge Invariant*. All other anchors (`1.20.1`, `1.21.1`, `1.21.11`, `26.1.2`, `26.2`) were already cleansed.
Furthermore, because version `1.2.13+26.3` was already published and contains this fatal defect, it must be marked `SUPERSEDED` and skipped in the release queues. The fix must be published under `1.2.14+26.3`.

## 🔬 2. Architectural Blueprint & Target Classes
- Target Class: [`SpeedometerClient.java`](file:///E:/Minecraft%20Project/Vanilla%20Outsider%20Collections/Speedometer/Speedometer%20v26.3/src/main/java/net/vanillaoutsider/speedometer/client/SpeedometerClient.java)
- Changes:
  1. Remove `import net.dasik.social.util.ModVersionGuard;`.
  2. Remove line `ModVersionGuard.checkClass("Speedometer", "net.minecraft.client.gui.components.debug.DebugScreenEntries");`.
  3. Pre-compile SemVer bump in `gradle.properties`: `mod_version=1.2.14+26.3`.
  4. Update `CHANGELOG.md` with player-facing patch notes.
  5. Mark `1.2.13+26.3` as `SUPERSEDED` in `RELEASE_QUEUE.md` and queue `- [ ] **1.2.14+26.3**`.

## ⚓ 3. Multi-Era Anchor Parity Specifications
- **MC 1.20.1 - 26.2**: Verified clean; none of the other anchors reference `ModVersionGuard`. Anchor 26.2 is already aligned at `1.2.14+26.2`.
- **MC 26.3**: Brought into complete parity with the other anchors and aligned to version `1.2.14+26.3`.

## 🛡️ 4. Edge Cases, Collisions & Failure Modes
- Knot ClassLoader Runtime Safety: Deobfuscated reflection calls in client initializers cause immediate `NoClassDefFoundError` in production Knot runtime. Purging reflection guards restores pure native Fabric dependency validation in `fabric.mod.json`.
- Release Queue Supersession: The automated publisher bot (`platform-publisher.py`) must cleanly recognize that `1.2.13+26.3` is superseded and pick up `1.2.14+26.3` as the next release candidate.

## 🚀 5. Implementation Steps (Code-Level Plan)
1. Edit `SpeedometerClient.java` to purge `ModVersionGuard`.
2. Bump `mod_version=1.2.14+26.3` in `gradle.properties`.
3. Update `CHANGELOG.md` and `RELEASE_QUEUE.md`.
4. Compile and verify headless tests: `./gradlew test build --no-daemon --console=plain`.
5. Universal 4-Point deploy: Local archive, Release Hub archive, External vault `D:`, and Modrinth 26.3 test profile (`profiles/26.3/mods/`).
6. Pre-commit secret scan and remote Git push (`Build = Push`).
7. Update release publisher queue status and studio governance boards.

## 🏁 6. Verification Checklist
- [ ] Obsolete `ModVersionGuard` purged from `SpeedometerClient.java`.
- [ ] `mod_version` bumped to `1.2.14+26.3` in `gradle.properties`.
- [ ] Clean `./gradlew test build` execution.
- [ ] 4-Point deployment completed and stale `1.2.13+26.3` purged from test profile.
- [ ] `platform_publisher.py --mod Speedometer --status` confirms `1.2.14+26.3` is ready.
