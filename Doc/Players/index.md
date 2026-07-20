# Player Guide - F3 Speedometer

## Quick Start
1. Install Fabric Loader for Minecraft 26.2.
2. Drop `f3-speedometer-26.2.0+build.1.jar` into your `.minecraft/mods` folder.
3. Open Minecraft, press `F3`, and view the speedometer line.

## Understanding the Speedometer Display
The Speedometer output line format is:
`Speed: 14.50 m/s (H: 12.30, V: 7.70)`

- **Speed**: Total 3D movement velocity in blocks per second (meters per second).
- **H**: Horizontal velocity component (X/Z plane).
- **V**: Vertical velocity component (Y axis).

## Always-Active HUD Toggle
In Minecraft 26.2, debug screen entries can be toggled to stay on screen even when F3 is closed.

To enable `ALWAYS_ON` mode:
- Open `.minecraft/debug-profile.json` in a text editor.
- Under the `"custom"` object or entry list, locate `f3_speedometer:speedometer` and set value to `"alwaysOn"`.
- Save the file and return to the game!
