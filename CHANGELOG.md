# Changelog - Speedometer

## [1.2.1-26.2] - 2026-07-21

### Added
- Implemented smart consolidation formatting for F3 overlays. If both vanilla's `player_speed` (blocks/tick) and our mod's `speedometer` are enabled, they dynamically consolidate onto a single line matching vanilla's format:
  `Speed: 0.215 blocks/tick, 4.30 b/s (H: 4.30, V: 0.00)`
- If `player_speed` is disabled and `speedometer` is enabled, outputs standalone line:
  `Speed: 4.30 b/s (H: 4.30, V: 0.00)`
- Removed rigid space padding (`%6.2f`), allowing the speedometer line length to scale dynamically and smoothly without jitter.

### Changed
- Renamed the mod back to **Speedometer** (independent F3 registration option `minecraft:speedometer` alongside `minecraft:player_speed`).

## [1.1.0-26.2] - 2026-07-21

### Changed
- Re-structured mod to align with native player speed mechanics.
- Replaced custom physics formulas with vanilla `Entity.getKnownSpeed()`.

## [1.0.3-26.2] - 2026-07-20

### Fixed
- Fixed standing still velocity artifact (`1.57 m/s` / `1.nnn m/s`) when resting on blocks.

## [1.0.2-26.2] - 2026-07-20

### Fixed
- Fixed F3 Debug Options Screen label displaying raw identifier.

## [1.0.1-26.2] - 2026-07-20

### Fixed
- Fixed sub-frame render flickering and text box resizing.

## [1.0.0-26.2] - 2026-07-20

### Added
- Initial release targeting Minecraft 26.2 on Fabric.
