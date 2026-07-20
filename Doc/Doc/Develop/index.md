# Developer Guide - F3 Speedometer Architecture

## Technical Architecture

### 1. F3 Debug Entry System (`DebugScreenEntries`)
Minecraft 26.2 modularized the debug HUD via `DebugScreenEntry`.

- **Entry Identifier**: `f3_speedometer:speedometer`
- **Class**: [DebugEntrySpeedometer.java](file:///e:/Minecraft%20Project/Instant%20Gratification%20Collection/F3%20Speedometer/f3-speedometer/src/main/java/net/instantgratification/f3speedometer/client/DebugEntrySpeedometer.java)
- **Mixins**:
  - [DebugScreenEntriesMixin.java](file:///e:/Minecraft%20Project/Instant%20Gratification%20Collection/F3%20Speedometer/f3-speedometer/src/main/java/net/instantgratification/f3speedometer/mixin/DebugScreenEntriesMixin.java): Uses `@Invoker("register")` on static class initialization to register the speedometer entry into `ENTRIES_BY_ID`.
  - [DebugScreenEntryListMixin.java](file:///e:/Minecraft%20Project/Instant%20Gratification%20Collection/F3%20Speedometer/f3-speedometer/src/main/java/net/instantgratification/f3speedometer/mixin/DebugScreenEntryListMixin.java): Hooks into `rebuildCurrentList` to assign default `IN_OVERLAY` status when first loaded.

### 2. Velocity Calculation Math
```java
double speedBps = Math.sqrt(dx * dx + dy * dy + dz * dz) / deltaSec;
double horizBps = Math.sqrt(dx * dx + dz * dz) / deltaSec;
double vertBps = Math.abs(dy) / deltaSec;
```
Falls back to `entity.getDeltaMovement() * 20.0` when frame time delta is uniform.

### 3. Build & Gradle Environment
- **JDK Target**: Java 25 (`options.release = 25`)
- **Loom**: 1.15.2
- **Minecraft**: 26.2 (Mojang mappings sovereign era)
- **Dependencies**: 100% Zero-Dependency (Fabric Loader only).
