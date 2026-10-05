# Architecture & Symbol Index: Speedometer

## 1. Multi-Version Subproject Layout
Speedometer is organized according to the Studio Constitution's Multi-Era 1 Jar 1 Version Policy as independent standalone subprojects:
- **MC 26.2 Anchor**: `Speedometer v26.2/` (Minecraft 26.2, Fabric Loader >=0.18.2, Java 25)
- **MC 26.3 Anchor**: `Speedometer v26.3/` (Minecraft 26.3, Fabric Loader >=0.19.3, Java 25)

## 2. Mod Metadata & Entrypoint
- **Mod ID**: `speedometer`
- **Client Entrypoint**: `net.vanillaoutsider.speedometer.client.SpeedometerClient`
- **Environment**: Client-only (`client`)

## 3. Bytecode Mixin Target Registry
| Target Vanilla Class | Mixin Class | Purpose |
| :--- | :--- | :--- |
| `net.minecraft.client.gui.components.debug.DebugScreenEntries` | `net.vanillaoutsider.speedometer.mixin.DebugScreenEntriesMixin` | Registers `speedometer` debug screen entry and wraps vanilla `player_speed` |
| `net.minecraft.client.gui.components.debug.DebugScreenEntryList` | `net.vanillaoutsider.speedometer.mixin.DebugScreenEntryListMixin` | Ensures speedometer status defaults to `IN_OVERLAY` on HUD rebuild |

## 4. Core Mechanics & Subsystems
- **Custom Debug Entry**: `net.vanillaoutsider.speedometer.client.DebugEntrySpeedometer`
- **Native Speed Wrapper**: `net.vanillaoutsider.speedometer.client.DebugEntryPlayerSpeedWrapper`
- **Velocity & Riding Calculation**: `net.vanillaoutsider.speedometer.util.SpeedometerSupport`
- **Mod Constants & Metadata**: `net.vanillaoutsider.speedometer.SpeedometerMod`
- **Shared Library Dependency**: `net.dasik.social:dasik-library` (creator support, formatting utilities)

## 5. Configuration & Sidedness Isolation
- **Sidedness**: Client-only mod (`environment: client`), hooks exclusively into client-side debug HUD entries (`F3 + F6`).
