# Minecraft 26.2 Guide

The primary release build of **Speedometer** targets **Minecraft 26.2** compiled with **JDK 25**, **Loom 1.15+**, and **Fabric Loader 0.15.0+**.

---

## 📋 Version Metadata Infobox

| Parameter | Specification |
| :--- | :--- |
| **Minecraft Target** | **26.2** |
| **Mod Version Tag** | `1.2.2-26.2` |
| **Jar Naming Convention** | `speedometer-1.2.2-26.2.jar` |
| **Fabric Loader Bounds** | `>=0.15.0` |
| **Minecraft Dependency Bounds** | `>=26.2` |
| **Java Toolchain Target** | **Java 25** |
| **Fabric API Required?** | **No (100% Zero-Dependency)** |

---

## ⚡ Core Features in Minecraft 26.2

Minecraft 26.2 introduced modern debug screen architectures (`DebugScreenEntries` & `DebugScreenEntryList`). Speedometer integrates seamlessly into these APIs to provide:

1. **Native F3 Debug Screen Registration**:
   Registered as `speedometer` alongside vanilla's internal entries.
2. **Dynamic Keybinding Administration (`F3 + F6`)**:
   Access the F3 Debug Options Screen to toggle `speedometer` between `Always`, `In Overlay`, and `OFF`.
3. **Smart Line Consolidation**:
   On builds where vanilla `player_speed` is enabled, Speedometer dynamically appends its velocity calculations to the same line:
   ```text
   Speed: 0.215 blocks/tick, 4.30 b/s (H: 4.30, V: 0.00)
   ```
4. **Standalone Velocity Output**:
   When vanilla `player_speed` is disabled and `speedometer` is enabled:
   ```text
   Speed: 4.30 b/s (H: 4.30, V: 0.00)
   ```

---

## ⚙️ Installation Instructions

1. Ensure **Fabric Loader** (`0.15.0+`) is installed for Minecraft 26.2.
2. Download `speedometer-1.2.2-26.2.jar` from CurseForge, Modrinth, or the repository GitHub Releases page.
3. Place the `.jar` file into your `.minecraft/mods/` directory.
4. Launch the game and press **`F3`** (or **`F3 + F6`** to open debug options).

---

## 🔗 Related Pages

* [[Version Compatibility|Version-Compatibility]]
* [[Smart Consolidation & Layouts|Smart-Consolidation-and-Layouts]]
* [[Developer Setup & Building|Developer-Setup-and-Building]]
