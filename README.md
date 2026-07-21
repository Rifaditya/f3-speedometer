# Speedometer

A lightweight, **100% Zero-Dependency** Minecraft client mod that adds a real-time Speedometer directly into the vanilla F3 Debug overlay with full support for native `ALWAYS_ON` HUD toggling.

---

## ⚡ Features
- **Native F3 Debug Entry**: Registered as `speedometer` within Minecraft's `DebugScreenEntries`, coexisting with vanilla's `player_speed` (in 26.3+).
- **In-Game Toggle & Layout Configuration (`F3 + F6`)**:
  - The mod registers `speedometer` as a separate option in the F3 Debug Options Screen.
  - Toggling `player_speed` and `speedometer` gives you complete layout control:
    - **Both Enabled** (Smart consolidation): `Speed: 0.215 blocks/tick, 4.30 b/s (H: 4.30, V: 0.00)`
    - **Only Speedometer Enabled**: `Speed: 4.30 b/s (H: 4.30, V: 0.00)`
    - **Only Player Speed Enabled** (Vanilla): `Speed: 0.215 blocks/tick`
- **Dynamic Sizing**: Automatically adjusts the HUD string width without rigid space padding, allowing it to grow and shrink smoothly and flawlessly.
- **Detailed Vector Breakdown**: Displays total speed alongside horizontal (**H**) and vertical (**V**) velocity components:
  - **Speed**: Total 3D movement velocity in blocks per second (b/s).
  - **H (Horizontal)**: Ground speed across the X/Z axis.
  - **V (Vertical)**: Up/down speed on the Y axis.
- **Vehicle & Riding Support**: Accurately tracks movement speed when riding horses, minecarts, boats, or pigs.
- **Zero External Dependencies**: Requires only Fabric Loader. No Fabric API or config libraries needed.

---

## ⚙️ How to Toggle Layouts (In-Game)
1. Press **`F3 + F6`** in-game to open the vanilla **F3 Debug Options Screen**.
2. Locate **`speedometer`** and **`player_speed`** (on 26.3+).
3. Toggle their status to set whether they appear in the overlay (`Always`, `In Overlay`, or `OFF`).
4. Returning to the game will dynamically apply the chosen layout (including smart consolidation).

---

## 📜 Installation
1. Install Fabric Loader.
2. Drop `speedometer-1.2.1-26.2.jar` into your `.minecraft/mods` folder.
3. Launch Minecraft, press `F3` (or `F3 + F6`), and view your real-time movement speed!

---

## 📄 License
Copyright (C) 2026 Dasik (Rifaditya) | GNU GPLv3
