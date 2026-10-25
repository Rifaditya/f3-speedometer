# Changelog

## [1.2.15+26.3] - 2026-10-25

### Added
- **5-Pillar Testing Harness**: Adopted complete studio client-adapted 5-Pillar Test Suite:
  - Pillar 1 (`SpeedometerStressFuzzTest`): 25,000 iterations of chaos velocity vector math and extreme boundary fuzzing.
  - Pillar 2 (`SpeedometerConcurrencyLoadTest`): 50 virtual worker threads stressing velocity calculations and thread-safe support queries.
  - Pillar 3 (`SpeedometerAssetTranslationTest`): 100% key coverage and AST validation across all 19 language files and ModMenu donation links.
  - Pillar 4 (`SpeedometerStateSimulationTest`): Headless client HUD state machine and player/vehicle camera entity simulation.
  - Pillar 5 (`SpeedometerSidednessContractTest`): Client-only environment invariant, zero server entrypoints, 100% single-line GPLv3 headers, zero `ModVersionGuard`, and raw bytecode constant-pool validation.

## [1.2.14+26.3] - 2026-10-18

### Fixed
- Fixed Knot ClassLoader `NoClassDefFoundError: net/dasik/social/util/ModVersionGuard` crash when running with Dasik Library 1.11.2+
- Purged obsolete legacy reflection guard in favor of native Fabric Loader dependency constraints

## [1.2.13+26.3] - 2026-09-24

### Changed
- **Dasik Library 1.9.2 Integration**: Adopted `dasik-library` 1.9.2 runtime dependency for unified cross-mod community links, creator support helpers, and diagnostics.
- **Creator Support**: Integrated top-pinned Ko-fi creator support links.
- **Test Suite**: Added automated unit test suite verifying real-time movement velocity calculations.

## [1.2.12+26.3] - 2026-09-14

### Added
- **Minecraft 26.3 Port**: Initial release supporting Minecraft 26.3 snapshot-6.
- **Dependency Upgrades**: Compiled against Fabric Loader 0.19.3 and Fabric API 0.156.1+26.3.
- **Java 25 Baseline**: Upgraded toolchain and execution target to Java 25.
- **Multi-Version Layout**: Standardized project structure into dedicated subproject.
