# Changelog - Speedometer

## [1.2.10+26.2] - 2026-08-25

### Added
- Added native Indonesian (`id_id`) translation assets and Indonesian player guide.

## [1.2.9+26.2] - 2026-08-25

### Added
- Added native Japanese (`ja_jp`) translation assets and Japanese player guide.

## [1.2.8+26.2] - 2026-08-25

### Added
- Added native Portuguese (`pt_br`, `pt_pt`) translation assets and Portuguese player guide.

## [1.2.7+26.2] - 2026-08-25

### Added
- Added native German (`de_de`) translation assets and German player guide.

## [1.2.6+26.2] - 2026-08-25

### Added
- Added native Spanish (`es_es`, `es_mx`, `es_ar`, `es_cl`, etc.) translation assets and Spanish player guide.

## [1.2.5+26.2] - 2026-08-25

### Added
- Added native Russian (`ru_ru`) translation assets and Russian player guide.

## [1.2.4+26.2] - 2026-08-25

### Added
- Added native Traditional Chinese (`zh_tw`) translation assets and documentation.

## [1.2.3-26.2] - 2026-08-25

### Added
- Added native Simplified Chinese (zh_cn) translation assets for in-game F3 debug options menu (F3 + F6) and Mod Menu metadata.
- Added base English (en_us) language asset file for standard localization mapping.
- Added Simplified Chinese player guide documentation (Doc/Players/index_zh_cn.md).

## [1.2.2-26.2] - 2026-07-21

### Changed
- Updated the mod's tagline and short description to "Player Speed but blocks per second" across all configuration files, mod registries, and platform guides.

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
