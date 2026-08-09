# Version Compatibility & Lifecycle

This page documents the Minecraft version support matrix, dependency bounds, and version evolution history for **Speedometer**.

> 📌 **Repository Source Disclaimer**: The documentation in this Wiki reflects the **current source code state in the repository**, which may include recent unreleased commits or developmental features ahead of public release builds on CurseForge and Modrinth.

---

## 📊 Minecraft Compatibility Matrix

| Minecraft Version | Speedometer Version | Build Tag | Support Status | Primary JDK |
| :--- | :--- | :--- | :--- | :--- |
| **MC 26.2** | **1.2.2-26.2** | `speedometer-1.2.2-26.2.jar` | **Active / Stable** | **JDK 25** |
| **MC 26.2** | **1.2.1-26.2** | `speedometer-1.2.1-26.2.jar` | Legacy Release | JDK 25 |
| **MC 26.2** | **1.2.0-26.2** | `player-speed-1.2.0-26.2.jar` | Legacy Release | JDK 25 |
| **MC 26.2** | **1.1.0-26.2** | `f3-speedometer-1.1.0-26.2.jar` | Legacy Release | JDK 25 |
| **MC 26.2** | **1.0.0-26.2** | `f3-speedometer-1.0.0-26.2.jar` | Initial Release | JDK 25 |

---

## 🔒 Dependency Bounds Specification (`fabric.mod.json`)

To prevent pre-release locks while ensuring stability, Speedometer uses open-ended lower bounds (`>=`) in `fabric.mod.json`:

```json
"depends": {
  "fabricloader": ">=0.15.0",
  "minecraft": ">=26.2"
}
```

* **Fabric Loader**: Minimum `0.15.0` required for Java 25 classloading.
* **Minecraft Target**: Open-ended `>=26.2` bound ensuring compatibility across modern Minecraft 26.x updates.

---

## 📜 Version Evolution & Migration Notes

1. **v1.0.0 – Initial Release**: Native F3 debug overlay rendering player speed in blocks per second (b/s).
2. **v1.1.0 – Vanilla Engine Alignment**: Migrated from custom physics delta calculations to Minecraft's native `Entity.getKnownSpeed()` API.
3. **v1.2.1 – Smart Consolidation**: Introduced `DebugEntryPlayerSpeedWrapper` spy-wrapper pattern. Allows automatic consolidation when both `player_speed` (blocks/tick) and `speedometer` (b/s) are enabled.
4. **v1.2.2 – Localization & Descriptor Refinement**: Tagline updated to *"Player Speed but blocks per second"*.

---

## 🔗 Related Pages

* [[Minecraft 26.2 Guide|Minecraft-26.2-Guide]]
* [[Architecture & Mixins|Architecture-and-Mixins]]
