# ⚡ Speedometer

> **Player Speed but blocks per second.**

Speedometer converts your movement into real-world readable **blocks per second (b/s)**. Powered directly by vanilla's 20 TPS physics engine, it updates dynamically, breaks down horizontal vs vertical velocity, works on mounts and vehicles, and seamlessly consolidates with vanilla's `player_speed` on modern Minecraft versions.

Part of the **Vanilla Outsider Collection** — mods that refine the vanilla experience with modern standards.

---

## ⚡ Features
- **Native F3 Debug Integration**:
  - **Modern (1.21.11, 26.x+)**: Registered as `speedometer` within Minecraft's native `DebugScreenEntries` (`F3 + F6`).
  - **Legacy (1.20.1, 1.21.1)**: Hooks directly into the F3 debug overlay.
- **Smart Display Layouts (`F3 + F6`)**:
  - **Speedometer Only** *(Default)*: `Speed: 58.79 b/s (H: 58.62, V: 4.47)`
  - **Both Enabled (Smart Consolidation)**: `Speed: 2.049 blocks/tick, 40.97 b/s (H: 37.46, V: 16.60)`
  - **Vanilla Player Speed Only**: `Speed: 0.215 blocks/tick`
- **ALWAYS_ON HUD Pinning**: Pin speedometer directly to the screen via `F3 + F6` (`Always` mode).
- **Dynamic Sizing**: Automatically adjusts HUD string width without rigid space padding or jitter.
- **Vector Velocity Breakdown**: Displays total 3D speed alongside horizontal (**H**) and vertical (**V**) velocity.
- **Vehicle & Mount Support**: Accurately tracks movement speed when riding horses, minecarts, boats, pigs, or striders.

---

## 📦 Dependencies
- **Fabric Loader**
- **Fabric API**
- **Dasik Library**

---

## 📜 Installation
1. Install Fabric Loader.
2. Install Fabric API and Dasik Library.
3. Download the matching **Speedometer** JAR for your Minecraft version.
4. Drop the JAR into your `.minecraft/mods` folder.
5. Launch Minecraft — press `F3` (or `F3 + F6` to configure layouts).

---

## 📄 License
Copyright (C) 2026 Dasik (Rifaditya) | GNU GPLv3
