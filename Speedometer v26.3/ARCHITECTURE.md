# Architecture & Symbol Index: Speedometer (MC 26.3)

## 1. Mod Metadata & Entrypoint
- **Mod ID**: `speedometer`
- **Client Entrypoint**: `net.vanillaoutsider.speedometer.client.SpeedometerClient`
- **Target Platform**: Minecraft 26.3 (Fabric Loader >=0.19.3, Java 25)

## 2. Bytecode Mixin Target Registry
| Target Vanilla Class | Mixin Class | Purpose |
| :--- | :--- | :--- |
| `net.minecraft.client.gui.components.debug.DebugScreenEntries` | `DebugScreenEntriesMixin` | Registers `speedometer` debug screen entry and wraps vanilla `player_speed` |
| `net.minecraft.client.gui.components.debug.DebugScreenEntryList` | `DebugScreenEntryListMixin` | Ensures speedometer status defaults to `IN_OVERLAY` on rebuild |

## 3. Core Mechanics & Subsystems
- **Custom Debug Entry**: `net.vanillaoutsider.speedometer.client.DebugEntrySpeedometer`
- **Native Speed Wrapper**: `net.vanillaoutsider.speedometer.client.DebugEntryPlayerSpeedWrapper`
- **Constants**: `net.vanillaoutsider.speedometer.SpeedometerMod`

## 4. Configuration & Sidedness Isolation
- **Sidedness**: Client-only mod (`environment: client`), safely scoped to client debug HUD.
