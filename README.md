# Player Speed

A lightweight, **100% Zero-Dependency** Minecraft client mod that adds a real-time Speedometer directly into the vanilla F3 Debug overlay with full support for native `ALWAYS_ON` HUD toggling. 

---

## ⚡ Features
- **Native F3 Debug Entry**: Registered directly as `player_speed` within Minecraft's `DebugScreenEntries`, aligning with Mojang's official Minecraft 26.3 design.
- **26.3 Auto-Detection & Wrapper**:
  - **On 26.2**: Registers its own speedometer entry displaying speed in blocks/second (`b/s`).
  - **On 26.3+**: Automatically detects vanilla's native speed entry, intercepts it, and appends horizontal (**H**) and vertical (**V**) speeds in blocks/tick, leaving the speed calculation itself to vanilla!
- **Always-Active Toggle**: Supports native `ALWAYS_ON` status so your speed stays displayed on screen even when the main F3 debug overlay is closed.
- **Detailed Vector Breakdown**: Displays total speed alongside horizontal (**H**) and vertical (**V**) velocity components:
  - **Speed**: Total 3D movement velocity in blocks per second (b/s) or blocks per tick (on 26.3).
  - **H (Horizontal)**: Ground speed across the X/Z axis e.g., walking, sprinting, riding a horse/minecart/boat.
  - **V (Vertical)**: Up/down speed on the Y axis e.g., jumping, falling, climbing, or flying.
- **Vehicle & Riding Support**: Accurately tracks movement speed when riding horses, minecarts, boats, or pigs.
- **Fixed-Width & Flicker-Free**: Uses smooth velocity vector math and constant-width text padding (`%6.2f`) to keep the HUD line box perfectly steady. Leverages vanilla `Entity.getKnownSpeed()` (updated once per tick) to ensure absolutely zero render framerate jitter.
- **Zero External Dependencies**: Requires only Fabric Loader. No Fabric API or config libraries needed.

---

## ⚙️ How to Enable Always-Active Mode (In-Game)
1. In-game, press **`F3 + F6`** to open the native **F3 Debug Options Screen**.
2. Locate **`player_speed`** in the list.
3. Click the button to switch status to **`Always`**.
4. The Speedometer will now stay displayed on your HUD even when the main F3 debug screen is closed!

---

## 📜 Installation
1. Install Fabric Loader for Minecraft 26.2.
2. Drop `player-speed-1.2.0-26.2.jar` into your `.minecraft/mods` folder.
3. Launch Minecraft, press `F3` (or `F3 + F6`), and view your real-time movement speed!

---

## 📄 License
Copyright (C) 2026 Dasik (Rifaditya) | GNU GPLv3
