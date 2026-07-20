# Changelog - F3 Speedometer

## [1.0.1-26.2] - 2026-07-20

### Fixed
- Fixed sub-frame render flickering where the speedometer line rapidly alternated between `0.00 m/s` and peak speed every frame.
- Replaced sub-frame time calculation with smooth entity velocity vector math (`entity.getDeltaMovement() * 20.0`).
- Applied fixed-width `%6.2f` column formatting to guarantee 100% constant string length, preventing the F3 text background box from constantly expanding and shrinking ("long-short-longshort" flashing).

## [1.0.0-26.2] - 2026-07-20

### Added
- Initial release targeting Minecraft 26.2 on Fabric.
- Native `DebugScreenEntry` registration for `f3_speedometer:speedometer`.
- Support for vanilla `ALWAYS_ON`, `IN_OVERLAY`, and `NEVER` F3 entry statuses.
- 100% Zero-dependency setup (Fabric Loader only).
