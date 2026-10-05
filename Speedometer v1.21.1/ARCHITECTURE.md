# Architecture & Symbol Index: Speedometer (MC 1.21.1)

## 1. Mod Metadata & Entrypoint
- **Mod ID**: `speedometer`
- **Main Entrypoint**: None (Client-only)
- **Client Entrypoint**: `net.vanillaoutsider.speedometer.client.SpeedometerClient`

## 2. Bytecode Mixin Target Registry
| Target Vanilla Class | Mixin Class | Purpose |
| :--- | :--- | :--- |
| `net.minecraft.client.gui.components.DebugScreenOverlay` | `net.vanillaoutsider.speedometer.mixin.DebugScreenOverlayMixin` | Injects real-time b/s velocity calculations directly into F3 debug information text |

## 3. Core Mechanics & Subsystems
- **Source Root**: `src/main/java/`
- **Resource Root**: `src/main/resources/`
- **Speed Calculation**: Multiplies per-tick displacement vectors (`deltaMovement`) by 20.0 for 3D total, horizontal, and vertical b/s.
- **Riding Entity Support**: Detects `player.getVehicle()` to report vehicle velocity when mounted.

## 4. Dependencies & Ecosystem
- **Dasik Library**: `net.dasik.social:dasik-library:1.1.0+1.21.1` for community and creator support integration.
- **Fabric Loader**: `>=0.16.0`
- **Minecraft**: `1.21.1`
