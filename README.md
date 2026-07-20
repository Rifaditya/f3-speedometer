# F3 Speedometer

A lightweight, **100% Zero-Dependency** Minecraft 26.2 client mod that adds a real-time Speedometer directly into the vanilla F3 Debug screen with full support for native `ALWAYS_ON` HUD toggling.

---

## ⚡ Features
- **Native F3 Debug Entry**: Registered directly as `speedometer` within Minecraft 26.2's `DebugScreenEntries`.
- **Clean F3 Menu Label**: Displays as **`speedometer`** in the vanilla F3 Debug Options screen (instead of raw mod identifiers).
- **Always-Active Toggle**: Supports native `ALWAYS_ON` status so your speed stays displayed on screen even when the main F3 debug overlay is closed.
- **Detailed Vector Breakdown**: Displays total speed alongside horizontal (**H**) and vertical (**V**) velocity components:
  - **Speed**: Total 3D movement velocity in blocks per second (b/s).
  - **H (Horizontal)**: Ground speed across the X/Z axis e.g., walking, sprinting, riding a horse/minecart/boat.
  - **V (Vertical)**: Up/down speed on the Y axis e.g., jumping, falling, climbing, or flying.
- **Vehicle & Riding Support**: Accurately tracks movement speed when riding horses, minecarts, boats, or pigs.
- **Fixed-Width & Flicker-Free**: Uses smooth velocity vector math and constant-width text padding (`%6.2f`) to keep the HUD line box perfectly steady without expanding/shrinking. Filters out resting gravity (`~0.0784`) so standing still cleanly displays `0.00 b/s`.
- **Zero External Dependencies**: Requires only Fabric Loader and Minecraft 26.2. No Fabric API or config libraries needed.

---

## ⚙️ How to Enable Always-Active Mode (In-Game)
1. In-game, press **`F3 + F6`** to open the native **F3 Debug Options Screen**.
2. Locate **`speedometer`** in the list.
3. Click the button to switch status to **`Always`**.
4. The Speedometer will now stay displayed on your HUD even when the main F3 debug screen is closed!

---

## 📜 Installation
1. Install Fabric Loader for Minecraft 26.2.
2. Drop `f3-speedometer-1.0.4-26.2.jar` into your `.minecraft/mods` folder.
3. Launch Minecraft, press `F3` (or `F3 + F6`), and view your real-time movement speed!

---

## 📄 License
Copyright (C) 2026 Dasik (Rifaditya) | GNU GPLv3
