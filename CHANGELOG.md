# Changelog - F3 Speedometer

## [1.1.0-26.2] - 2026-07-21

### Changed
- Re-structured the mod's architecture to align with Mojang's official **Minecraft 26.3** player speed entry.
- Renamed HUD display entry class to `DebugEntryPlayerSpeed`.
- Registered display entry under the official identifier `player_speed` (appears in `F3 + F6` as `player_speed`).
- Replaced custom velocity tracking methods with vanilla `Entity.getKnownSpeed()`, eliminating sub-frame render calculations and improving performance.
- Retained horizontal (**H**) and vertical (**V**) speed breakdown calculations in blocks per second (`b/s`).

## [1.0.3-26.2] - 2026-07-20

### Fixed
- Fixed standing still velocity artifact (`1.57 m/s` / `1.nnn m/s`) caused by vanilla downward gravity acceleration when standing on blocks. Standing still now correctly displays `0.00 b/s`.
- Added vehicle support (`entity.getVehicle()`) so riding horses, boats, or minecarts accurately reflects entity speed.

## [1.0.2-26.2] - 2026-07-20

### Fixed
- Fixed F3 Debug Options Screen label displaying raw identifier (`f3_speedometer:speedometer`).
- Changed entry identifier to default namespace (`minecraft:speedometer`), allowing F3 options menu to display cleanly as `speedometer`.

## [1.0.1-26.2] - 2026-07-20

### Fixed
- Fixed sub-frame render flickering and applied fixed-width `%6.2f` column formatting.

## [1.0.0-26.2] - 2026-07-20

### Added
- Initial release targeting Minecraft 26.2 on Fabric.
