# 📌 Speedometer Backlog

This file tracks planned features, technical refinements, performance optimizations, and deferred bug fixes for **Speedometer**.

---

## 📊 Backlog Summary

| ID | Category | Title | Priority | Target Version | Status |
| :--- | :--- | :--- | :--- | :--- | :--- |
| `[BL-SP-001]` | `[TECH_DEBT]` | Update Speedometer MC 26.2 to use Dasik Library MC 26.2 | `[MEDIUM]` | `26.2` | `✅ RESOLVED` |
| `[BL-SP-002]` | `[TECH_DEBT]` | Update Speedometer MC 26.3 to use Dasik Library MC 26.3 | `[MEDIUM]` | `26.3` | `✅ RESOLVED` |
| `[BL-SP-003]` | `[FEATURE]` | Multi-Era Anchor Porting: Speedometer (blocked by `[BL-SP-005]`, `[BL-SP-006]`) | `[HIGH]` | `Multi-Era` | `📌 DEFERRED` |
| **[BL-SP-004]** | `[TECH_DEBT]` | Downstream Ecosystem & Toolchain Alignment | `[HIGH]` | All Anchors | `✅ RESOLVED` |
| `[BL-SP-005]` | `[BUGFIX]` | Repair MC 26.2 baseline: fabric-api compile dependency, manifest parity, publisher-readable queue | `[HIGH]` | `26.2` | `✅ RESOLVED` |
| `[BL-SP-006]` | `[TECH_DEBT]` | Purge stale root-level legacy `src/`/`build/` single-version leftovers | `[MEDIUM]` | Repo root | `📌 DEFERRED` |

---

## 🏷 Legend & Status Tags
- **Categories**: `[FEATURE]`, `[REFINEMENT]`, `[BUGFIX]`, `[PERF]`, `[TECH_DEBT]`
- **Priorities**: `[HIGH]` (Important logic fix/enhancement), `[MEDIUM]` (Quality of life), `[LOW]` (Minor polish)
- **Statuses**: `📌 DEFERRED` (Queued for future work), `🚧 IN_PROGRESS` (Active development), `✅ RESOLVED` (Implemented and verified)

---

## 📝 Detailed Backlog Entries

### [BL-SP-001] Update Speedometer MC 26.2 to use Dasik Library MC 26.2
- **Category**: `[TECH_DEBT]`
- **Priority**: `[MEDIUM]`
- **Status**: `✅ RESOLVED`
- **Target Component(s)**: `build.gradle`, `fabric.mod.json`, HUD formatting
- **Date Added**: 2026-09-24

#### ❓ Problem / Context
Speedometer MC 26.2 does not declare `dasik-library` as a runtime dependency.

#### 💡 Proposed Solution & Technical Specifications
- Add `dasik-library` dependency in `build.gradle` and `fabric.mod.json`.
- Integrate shared HUD/formatting and creator support helpers from `net.dasik.social.api.*`.

#### 🧪 Verification & Acceptance Criteria
- [x] `./gradlew check` / test suite passes.
- [x] Mod compiles cleanly with `./gradlew build`.
- [x] Built JAR is triple-archived.

---

### [BL-SP-002] Update Speedometer MC 26.3 to use Dasik Library MC 26.3
- **Category**: `[TECH_DEBT]`
- **Priority**: `[MEDIUM]`
- **Status**: `✅ RESOLVED`
- **Target Component(s)**: `build.gradle`, `fabric.mod.json`, HUD formatting
- **Date Added**: 2026-09-24

#### ❓ Problem / Context
Speedometer MC 26.3 does not declare `dasik-library` as a runtime dependency.

#### 💡 Proposed Solution & Technical Specifications
- Add `dasik-library` dependency in `build.gradle` and `fabric.mod.json`.
- Integrate shared HUD/formatting and creator support helpers from `net.dasik.social.api.*`.

#### 🧪 Verification & Acceptance Criteria
- [x] `./gradlew check` / test suite passes.
- [x] Mod compiles cleanly with `./gradlew build`.
- [x] Built JAR is triple-archived.

---

### [BL-SP-003] Multi-Era Anchor Porting: Speedometer
- **Category**: `[FEATURE]`
- **Priority**: `[HIGH]`
- **Status**: `📌 DEFERRED`
- **Target Component(s)**: Multi-subproject directories, `SpeedometerHud.java`, `SpeedometerConfig.java`, `SpeedCalculator.java`, `build.gradle`, `fabric.mod.json`, `RELEASE_QUEUE.md`
- **Date Added**: 2026-09-25

#### ❓ Problem / Context
Existing versions: `26.2`, `26.3`. Missing anchors: Modern `26.1 / 26.1.2`; Older `1.21.11`, `1.21.1`, `1.20.1`.
Per Multi-Era Version Matrix and 1 Jar 1 Version Policy, port mod across all missing anchors (Modern first, Older second).

#### 💡 Architectural Specifications & Toolchain Anchors
- **Phase 1: Modern Sovereign Anchors (Java 25+, Loom 1.15+, No Mappings Block)**:
  - `MC 26.1 / 26.1.2`: Java 25, Fabric Loom 1.15+, `Identifier.fromNamespaceAndPath`, `EntityTypes`, `dasik-library` 26.1.
  - `MC 26.2`: Java 25, Fabric Loom 1.15+, `Identifier.fromNamespaceAndPath`, `DynamicGameRuleManager` (already active baseline).
  - `MC 26.3`: Java 25, Fabric Loom 1.15+, `minecraft_version=26.3-snapshot-6`, `fabric_version=0.156.1+26.3` (already active baseline).
- **Phase 2: Older Anchors (Mojang Mappings, Java 21 / 17)**:
  - `MC 1.21.11`: Java 21, Loom 1.15-SNAPSHOT (`fabric-loom-remap`), Mojang mappings, `Identifier.of`, `Optional<T>` CompoundTag, relocated entity packages.
  - `MC 1.21.1`: Java 21, Loom 1.10+, Mojang mappings, `Identifier.of`, `DataComponents`, native `Attributes.SCALE`.
  - `MC 1.20.1`: Java 17, Loom 1.4–1.10, Mojang mappings, `new Identifier`, primitive NBT CompoundTag, `FabricItemSettings`, `GameRules.Category` enum.

#### 🧪 Verification & Acceptance Criteria

##### Phase 1: Modern Sovereign Anchors (Priority 1)
- [ ] **Anchor: MC 26.1 / 26.1.2**
  - [ ] Subproject directory & build script scaffolding (`build.gradle`, `gradle.properties`, `settings.gradle`)
  - [ ] Source adaptation, API/mixin relocation, and dasik-library wiring for target version
  - [ ] Headless unit & integration test suite pass (`./gradlew test --no-daemon`)
  - [ ] Clean binary compilation (`./gradlew build --no-daemon`)
  - [ ] Mandatory Universal 4-Point Distribution (Local Archive, Hub Archive, External Vault `D:\`, Launcher Test Profile)
  - [ ] Release queue registration in `RELEASE_QUEUE.md` (`- [ ]`) and `CHANGELOG.md` entry
- [x] **Anchor: MC 26.2 - Already established baseline** (Subproject: `Speedometer v26.2`)
- [x] **Anchor: MC 26.3 - Already established baseline** (Subproject: `Speedometer v26.3`)

##### Phase 2: Older Anchors (Priority 2)
- [ ] **Anchor: MC 1.21.11 (Java 21, Loom 1.15-SNAPSHOT `fabric-loom-remap`, Mojang mappings, `Identifier.of`, `Optional<T>` CompoundTag, relocated entity packages)**
  - [ ] Subproject directory & build script scaffolding (`build.gradle`, `gradle.properties`, `settings.gradle`)
  - [ ] Source adaptation, API/mixin relocation, and dasik-library wiring for target version
  - [ ] Headless unit & integration test suite pass (`./gradlew test --no-daemon`)
  - [ ] Clean binary compilation (`./gradlew build --no-daemon`)
  - [ ] Mandatory Universal 4-Point Distribution (Local Archive, Hub Archive, External Vault `D:\`, Launcher Test Profile)
  - [ ] Release queue registration in `RELEASE_QUEUE.md` (`- [ ]`) and `CHANGELOG.md` entry
- [ ] **Anchor: MC 1.21.1 (Java 21, Loom 1.10+, Mojang mappings, `Identifier.of`, `DataComponents`, native `Attributes.SCALE`)**
  - [ ] Subproject directory & build script scaffolding (`build.gradle`, `gradle.properties`, `settings.gradle`)
  - [ ] Source adaptation, API/mixin relocation, and dasik-library wiring for target version
  - [ ] Headless unit & integration test suite pass (`./gradlew test --no-daemon`)
  - [ ] Clean binary compilation (`./gradlew build --no-daemon`)
  - [ ] Mandatory Universal 4-Point Distribution (Local Archive, Hub Archive, External Vault `D:\`, Launcher Test Profile)
  - [ ] Release queue registration in `RELEASE_QUEUE.md` (`- [ ]`) and `CHANGELOG.md` entry
- [ ] **Anchor: MC 1.20.1 (Java 17, Loom 1.4-1.10, Mojang mappings, `new Identifier`, primitive NBT CompoundTag, `FabricItemSettings`, `GameRules.Category` enum)**
  - [ ] Subproject directory & build script scaffolding (`build.gradle`, `gradle.properties`, `settings.gradle`)
  - [ ] Source adaptation, API/mixin relocation, and dasik-library wiring for target version
  - [ ] Headless unit & integration test suite pass (`./gradlew test --no-daemon`)
  - [ ] Clean binary compilation (`./gradlew build --no-daemon`)
  - [ ] Mandatory Universal 4-Point Distribution (Local Archive, Hub Archive, External Vault `D:\`, Launcher Test Profile)
  - [ ] Release queue registration in `RELEASE_QUEUE.md` (`- [ ]`) and `CHANGELOG.md` entry

### [BL-SP-004] Downstream Ecosystem & Toolchain Alignment: watched_projects, fabric.mod.json, Queue Segregation & Archive Hierarchy
- **Category**: `[TECH_DEBT]`
- **Priority**: `[HIGH]`
- **Target Version**: All Anchors
- **Status**: `✅ RESOLVED`
- **Date Added**: 2026-10-01
- **Problem / Context**:
  Across the studio release pipeline and downstream automation tools, systemic inconsistencies exist:
  1. `dasik-mod-sync/watched_projects.json`: Many mods contain broken `icon_path` mappings (non-existent nested folder references) or stale `versions` arrays that omit active anchors.
  2. `fabric.mod.json`: Platform metadata (`custom.modrinth.projectId`, `slug`, repository URLs) occasionally drifts from authoritative entries in `minecraft-mod-release-hub/config/platform_projects.json`.
  3. `RELEASE_QUEUE.md`: Multi-version subproject directories often retain predecessor anchor changelog headers, violating the Subproject Queue Segregation Law.
  4. Archive Structure: Collection roots lack standardized `Archive Jar of all versions/` hierarchies (`MC <Version>/`), preventing `sync_archives.py` from auto-discovering compiled builds for release hub and external vault distribution.
- **Proposed Solution & Technical Specifications**:
  1. Audit and correct `icon_path` and `versions` array in `dasik-mod-sync/watched_projects.json` for Speedometer.
  2. Align `fabric.mod.json` across all active subprojects with official `platform_projects.json` metadata.
  3. Purge predecessor version headers from subproject `RELEASE_QUEUE.md` and `CHANGELOG.md` files (strict Version Anchor Exclusivity).
  4. Scaffold/verify collection root `Archive Jar of all versions/` containing dedicated `MC <Version>/` folders with existing release JARs mirrored.
  5. Scaffold root `MASTER_RELEASE_QUEUE.md` multi-anchor dashboard where absent.
- **Verification & Acceptance Criteria**:
  - [x] `watched_projects.json` icon path physically exists on disk and `versions` matches active anchors.
  - [x] `fabric.mod.json` metadata strictly aligns with `platform_projects.json`.
  - [x] Subproject `RELEASE_QUEUE.md` files contain strictly target-anchor release entries.
  - [x] Root `Archive Jar of all versions/` exists and contains release JARs discoverable by `sync_archives.py`.

---

### [BL-SP-005] Repair MC 26.2 baseline: fabric-api compile dependency, manifest parity, publisher-readable queue
- **Category**: `[BUGFIX]`
- **Priority**: `[HIGH]`
- **Target Version**: `26.2` (version-isolated: 26.3 verified green 2026-10-05)
- **Status**: `✅ RESOLVED`
- **Date Added**: 2026-10-05
- **Origin**: `/pipeline [BL-SP-003]` Stage 1 baseline audit (Sovereign Lead Health Gate).
- **Problem / Context**:
  1. `Speedometer v26.2/build.gradle` omits `fabric-api` from `dependencies`; `compileJava` fails with `cannot access AttachmentTarget` / `cannot access EntityLoadData` (Fabric API interface-injected types required transitively by `dasik-library` 1.9.2).
  2. `Speedometer v26.2/src/main/resources/fabric.mod.json` lacks the `custom.modrinth` block (`z9YkBUIj` / `vo-speedometer`), `sources`/`issues` URLs, and points `contact` at the stale `speedometer` repo instead of `Rifaditya/f3-speedometer`.
  3. `Speedometer v26.2/RELEASE_QUEUE.md` uses a legacy table with `PENDING` statuses that the cloud publisher does not parse; `1.2.13+26.2` has been stuck unpublished since 2026-09-24.
- **Proposed Solution & Technical Specifications**:
  1. Add `implementation "net.fabricmc.fabric-api:fabric-api:${project.fabric_version}"` (property name per `gradle.properties`) mirroring `Speedometer v26.3/build.gradle`.
  2. Align `fabric.mod.json` with v26.3 (modrinth block, contact URLs, `fabric-api *` depends) keeping `minecraft` bound to 26.2.
  3. Bump `mod_version` to `1.2.14+26.2` (never recompile under `1.2.13+26.2`).
  4. Convert `RELEASE_QUEUE.md` to `- [ ]` / `- [x]` checklist format matching v26.3; released history kept as `- [x]`; `1.2.13+26.2` marked superseded by `1.2.14+26.2` (its notes folded into the 1.2.14 changelog entry).
  5. `CHANGELOG.md` (26.2-only headers), `History.md`, `MASTER_RELEASE_QUEUE.md` (also repair mojibake emoji encoding to UTF-8).
- **Verification & Acceptance Criteria**:
  - [x] `git pull --rebase` absorbs publisher commit `b42c874` before edits.
  - [x] `./gradlew test` and `./gradlew build` pass in `Speedometer v26.2`.
  - [x] Built JAR's `fabric.mod.json` contains modrinth block and correct URLs.
  - [x] 4-point distribution (Local, Hub archive, `D:\` vault, release queue `- [ ] 1.2.14+26.2`).
  - [x] `platform_publisher.py --mod "Speedometer" --status` parses 26.2 queue cleanly.
  - [x] Mod repo + `minecraft-mod-release-hub` pushed.

---

### [BL-SP-006] Purge stale root-level legacy single-version leftovers
- **Category**: `[TECH_DEBT]`
- **Priority**: `[MEDIUM]`
- **Target Version**: Repo root (no JAR, no SemVer bump)
- **Status**: `📌 DEFERRED`
- **Date Added**: 2026-10-05
- **Origin**: `/pipeline [BL-SP-003]` Stage 1 baseline audit.
- **Problem / Context**: Repo root still contains a pre-split single-version project (`src/main` — 29 files, stale v26.2 snapshot without `SpeedometerSupport.java`/tests/Dasik bindings — plus `build/`, root `gradle/` and any root Gradle scripts). Agents and `sync_archives.py`-style scanners can mistake it for an anchor.
- **Proposed Solution & Technical Specifications**:
  1. Inventory root-level Gradle artifacts (`src/`, `build/`, `gradle/`, `build.gradle`, `settings.gradle`, `gradle.properties`, `gradlew*`) and confirm nothing references them (subproject `settings.gradle`, `ARCHITECTURE.md`, release-hub `platform_projects.json` `root_dir`, `watched_projects.json`).
  2. `git rm` the tracked legacy files; delete untracked `build/`. Keep `Archive/`, `Archive Jar of all versions/`, `Doc/`, master docs.
  3. Update root `ARCHITECTURE.md`/README pointers if they reference root `src/`.
- **Verification & Acceptance Criteria**:
  - [ ] No references to root `src/` remain in tooling configs.
  - [ ] Both subprojects still `./gradlew build` green after purge.
  - [ ] Commit pushed.
