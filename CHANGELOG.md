# Changelog - F3 Speedometer

## [1.0.4-26.2] - 2026-07-20

### Changed
- Changed displayed speed unit suffix from `m/s` (meters per second) to `b/s` (blocks per second).

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
