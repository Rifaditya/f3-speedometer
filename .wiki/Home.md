# Speedometer Wiki Portal

Welcome to the official **Speedometer** Wiki! Speedometer is a lightweight, **100% Zero-Dependency** client-side Minecraft Fabric mod designed to display real-time player and entity movement velocity directly in the native F3 Debug Screen in **blocks per second (b/s)**.

> 📌 **Repository Source Disclaimer**: The documentation in this Wiki reflects the **current source code state in the repository**, which may include recent unreleased commits or developmental features ahead of public release builds on CurseForge and Modrinth.

---

## 📊 Mod Overview Infobox

| Property | Details |
| :--- | :--- |
| **Mod Name** | Speedometer |
| **Mod ID** | `speedometer` |
| **Collection Track** | **Vanilla Outsider Collection** |
| **Target Minecraft Version** | **26.2** (`>=26.2-`) |
| **Environment** | **Client-Side Only** (`client`) |
| **Dependencies** | **Fabric Loader** (`>=0.15.0`) |
| **License** | **GNU General Public License v3.0 (GPLv3)** |
| **Author / Developer** | **Dasik (Rifaditya)** |

---

## 💡 Design Philosophy & Purpose

In vanilla Minecraft, movement mechanics are calculated on a per-tick basis ($20\text{ ticks} = 1\text{ second}$). In Minecraft 26.3+, vanilla introduced `player_speed` displaying raw velocity in `blocks/tick`. However, players and server administrators naturally measure travel speed in **blocks per second (b/s)**.

**Speedometer** bridges this gap while respecting vanilla aesthetics:
1. **Zero External Dependencies**: Requires zero library mods or config engines—only Fabric Loader.
2. **Native F3 Registration**: Integrates directly into Minecraft's `DebugScreenEntries` engine under `speedometer`.
3. **Smart Consolidation**: Intelligently merges with vanilla's native `player_speed` line into a unified HUD display without cluttering the screen.
4. **Detailed Vector Breakdown**: Breaks velocity into total 3D speed, horizontal ground speed (**H**), and vertical velocity (**V**).

---

## 📦 Minecraft Versions Directory

* [[Minecraft 26.2 Guide|Minecraft-26.2-Guide]] — Dedicated guide for the primary Minecraft 26.2 target release.
* [[Version Compatibility|Version-Compatibility]] — Full Minecraft version lifecycle, dependency bounds, and migration history.

---

## 🎮 Player & Feature Guides Directory

* [[Velocity Math & Vectors|Velocity-Math-and-Vectors]] — Math formulas, vector components, and tick-to-second conversion.
* [[F3 Debug Integration|F3-Debug-Integration]] — How Speedometer hooks into `DebugScreenEntries` and `DebugScreenEntryList`.
* [[Smart Consolidation & Layouts|Smart-Consolidation-and-Layouts]] — Configuring F3 overlay states and line consolidation.
* [[Vehicle & Riding Physics|Vehicle-and-Riding-Physics]] — Tracking velocity while riding boats, minecarts, horses, or flying.
* [[Dynamic HUD Formatting|Dynamic-HUD-Formatting]] — High-precision, zero-jitter string length formatting (`%.2f`).
* [[Camera & Entity Tracking|Camera-and-Entity-Tracking]] — Spectator camera tracking and vehicle mount speed calculations.
* [[Ground Rest Fixes|Ground-Rest-Fixes]] — Resolution of standing-still velocity artifacts (`1.57 m/s`).
* [[Advancements|Advancements]] — Advancement integration status (Vanilla reliance policy).
* [[GameRules|GameRules]] — GameRule configuration status (Client-side mod policy).
* [[Commands|Commands]] — Brigadier command status (GUI F3+F6 driven policy).
* [[Configuration|Configuration]] — In-game `F3 + F6` debug options menu setup.
* [[HUD & Diagnostics|HUD-and-Diagnostics]] — Overlay display states (`Always`, `In Overlay`, `OFF`).

---

## 💻 Developer & Technical Reference

* [[Developer Setup & Building|Developer-Setup-and-Building]] — Building from source with JDK 25, Gradle 9.3+, and Loom 1.15+.
* [[Architecture & Mixins|Architecture-and-Mixins]] — Package hierarchy and Mixin target breakdown table.
* [[API & Addon Integration|API-and-Addon-Integration]] — Fabric entrypoints and `DebugScreenEntry` wrapper implementation.
* [[Zero-Dependency Design|Zero-Dependency-Design]] — Architecture rationale for lightweight client mod design.
* [[Performance & Rendering|Performance-and-Rendering]] — Render thread impact ($<0.001\text{ ms}$) and memory allocation analysis.
* [[Troubleshooting & FAQ|Troubleshooting-and-FAQ]] — Frequently asked questions and diagnostic solutions.
