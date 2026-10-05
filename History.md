# History - Speedometer

## Version History

### Repository Root Cleanup (2026-10-05)
- **Status**: Internal Architecture Maintenance
- **Scope**: Repository Root (No SemVer bump)
- **Backlog Reference**: [BL-SP-006] Purge stale root-level legacy single-version leftovers
- **Summary**:
  - Purged 36 tracked legacy single-version artifacts from the repository root: root `src/` (pre-split snapshot), `gradle/` wrapper, `build.gradle`, `settings.gradle`, `gradle.properties`, and root `gradlew`/`gradlew.bat`.
  - Removed untracked root `build/` and `.gradle/` directories.
  - Preserved all multi-version infrastructure (`Archive/`, `Archive Jar of all versions/`, `Doc/`, subprojects `Speedometer v26.2/` and `Speedometer v26.3/`).
  - Updated root `ARCHITECTURE.md` and `Speedometer v26.2/ARCHITECTURE.md` to accurately document the multi-version subproject layout and real symbols.
  - Verified 0-error build integrity on both `Speedometer v26.2` and `Speedometer v26.3`.

### 1.2.14+26.2 (2026-10-05)
- **Status**: Stable Release Candidate
- **Minecraft Version**: 26.2
- **Backlog Reference**: [BL-SP-005] Repair MC 26.2 baseline: fabric-api compile dependency, manifest parity, publisher-readable queue
- **Root Cause & Technical Details**:
  - `Speedometer v26.2/build.gradle` omitted `net.fabricmc.fabric-api:fabric-api` from `dependencies`, causing `compileJava` failures (`cannot access AttachmentTarget` / `cannot access EntityLoadData`) due to Fabric API interface-injected types transitively required by `dasik-library` 1.9.2. Added `implementation "net.fabricmc.fabric-api:fabric-api:${project.fabric_version}"`.
  - Version `1.2.13+26.2` was never published and is now formally superseded by `1.2.14+26.2`.
  - Restored `custom.modrinth` metadata block (`projectId: z9YkBUIj`, `slug: vo-speedometer`), repository contact URLs (`Rifaditya/f3-speedometer`), and `fabric-api *` dependency to `fabric.mod.json`.
  - Re-formatted `Speedometer v26.2/RELEASE_QUEUE.md` from legacy Markdown table format to standard checklist format (`- [ ]` / `- [x]`) parsed by `queue_engine.py`, marking obsolete/unreleased builds as SUPERSEDED.

### 1.2.13+26.3 (2026-09-24)
- **Status**: Stable Release Candidate
- **Minecraft Version**: 26.3
- **Summary**: Implemented [BL-SP-002]: Adopted Dasik Library 1.9.2 runtime dependency, added creator support integration, and added headless JUnit 5 calculation test suite.

### 1.2.13+26.2 (2026-09-24)
- **Status**: Superseded (Never Published)
- **Minecraft Version**: 26.2
- **Summary**: Implemented [BL-SP-001]: Adopted Dasik Library 1.9.2 runtime dependency, added creator support integration, and added headless JUnit 5 calculation test suite. Superseded by 1.2.14+26.2.

### 1.2.12+26.2 (2026-08-25)
- **Status**: Stable Release
- **Minecraft Version**: 26.2
- **Summary**: Added Korean (`ko_kr`) in-game localization assets and player guide.

### 1.2.11+26.2 (2026-08-25)
- **Status**: Stable Release
- **Minecraft Version**: 26.2
- **Summary**: Added French (`fr_fr`, `fr_ca`) in-game localization assets and player guide.

### 1.2.10+26.2 (2026-08-25)
- **Status**: Stable Release
- **Minecraft Version**: 26.2
- **Summary**: Added Indonesian (`id_id`) in-game localization assets and player guide.

### 1.2.9+26.2 (2026-08-25)
- **Status**: Stable Release
- **Minecraft Version**: 26.2
- **Summary**: Added Japanese (`ja_jp`) in-game localization assets and player guide.

### 1.2.8+26.2 (2026-08-25)
- **Status**: Stable Release
- **Minecraft Version**: 26.2
- **Summary**: Added Portuguese (`pt_br`, `pt_pt`) in-game localization assets and player guide.

### 1.2.7+26.2 (2026-08-25)
- **Status**: Stable Release
- **Minecraft Version**: 26.2
- **Summary**: Added German (`de_de`) in-game localization assets and player guide.

### 1.2.6+26.2 (2026-08-25)
- **Status**: Stable Release
- **Minecraft Version**: 26.2
- **Summary**: Added Spanish in-game localization assets and player guide.

### 1.2.5+26.2 (2026-08-25)
- **Status**: Stable Release
- **Minecraft Version**: 26.2
- **Summary**: Added Russian (`ru_ru`) in-game localization assets and player guide.

### 1.2.4+26.2 (2026-08-25)
- **Status**: Stable Release
- **Minecraft Version**: 26.2
- **Summary**: Added Traditional Chinese (`zh_tw`) in-game localization assets and player guide.

### 1.2.3-26.2 (2026-08-25)
- **Status**: Superseded (Never Published)
- **Minecraft Version**: 26.2
- **Summary**: Added Simplified Chinese (zh_cn) in-game localization assets and Chinese player documentation.

### 1.2.2-26.2 (2026-07-21)
- **Status**: Stable Release
- **Minecraft Version**: 26.2
- **Summary**: Updated mod tagline to "Player Speed but blocks per second" in resources and metadata.

### 1.2.1-26.2 (2026-07-21)
- **Status**: Obsolete
- **Minecraft Version**: 26.2
- **Summary**: Renamed mod back to Speedometer, implemented smart formatting consolidation, and added dynamic layout scaling (removed fixed-width space padding).

### 1.1.0-26.2 (2026-07-21)
- **Status**: Obsolete
- **Minecraft Version**: 26.2
- **Summary**: Aligned mod architecture with Mojang's official Minecraft 26.3 player speed structure, using vanilla `Entity.getKnownSpeed()`.

### 1.0.3-26.2 (2026-07-20)
- **Status**: Obsolete
- **Minecraft Version**: 26.2
- **Summary**: Filtered out resting gravity acceleration so standing still returns 0.00 b/s, and added vehicle movement support.

### 1.0.2-26.2 (2026-07-20)
- **Status**: Obsolete
- **Minecraft Version**: 26.2
- **Summary**: Updated entry identifier namespace so F3 Debug Options Screen displays label as `speedometer`.

### 1.0.1-26.2 (2026-07-20)
- **Status**: Obsolete
- **Minecraft Version**: 26.2
- **Summary**: Fixed sub-frame render flickering and applied fixed-width text formatting.

### 1.0.0-26.2 (2026-07-20)
- **Status**: Obsolete
- **Minecraft Version**: 26.2
- **Summary**: Initial release.
