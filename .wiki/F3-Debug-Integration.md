# F3 Debug Integration

This page documents how **Speedometer** integrates into Minecraft's client-side debug rendering pipeline using `DebugScreenEntries` and `DebugScreenEntryList`.

---

## 📊 Debug Integration Infobox

| Property | Value |
| :--- | :--- |
| **Speedometer Registry Key** | `Identifier.withDefaultNamespace("speedometer")` |
| **Native Vanilla Key** | `Identifier.withDefaultNamespace("player_speed")` |
| **Interface Implemented** | `net.minecraft.client.gui.components.debug.DebugScreenEntry` |
| **Mixin Target 1** | `net.minecraft.client.gui.components.debug.DebugScreenEntries` |
| **Mixin Target 2** | `net.minecraft.client.gui.components.debug.DebugScreenEntryList` |
| **Default Display State** | `DebugScreenEntryStatus.IN_OVERLAY` |

---

## 🏗 Architecture Diagram

```
+----------------------------------------------------------------+
|                     Minecraft F3 Debug Screen                   |
+----------------------------------------------------------------+
                               |
                   DebugScreenEntries.<clinit>()
                               |
                     DebugScreenEntriesMixin
                               |
       +-----------------------+-----------------------+
       |                                               |
  register()                                      put()
  Speedometer ID                                  Player Speed ID
       |                                               |
DebugEntrySpeedometer                     DebugEntryPlayerSpeedWrapper
  (Standalone Line)                         (Consolidated Line)
```

---

## ⚙️ Registration Workflow

1. **Static Class Loading Injection (`DebugScreenEntriesMixin`)**:
   During tail initialization (`<clinit>`) of `DebugScreenEntries`, Speedometer invokes the private static `register` method to add `speedometer` to vanilla's entry registry (`ENTRIES_BY_ID`).
2. **Default Status Initialization (`DebugScreenEntryListMixin`)**:
   When `DebugScreenEntryList.rebuildCurrentList()` executes, Speedometer verifies if `speedometer` exists in `allStatuses`. If absent, it automatically registers `speedometer` with `DebugScreenEntryStatus.IN_OVERLAY`.
3. **Spy Wrapper Replacement**:
   If vanilla natively registers `player_speed` (e.g. in Minecraft 26.3+), `DebugScreenEntriesMixin` replaces vanilla's `DebugScreenEntry` object in `ENTRIES_BY_ID` with our `DebugEntryPlayerSpeedWrapper`.

---

## 🔗 Related Pages

* [[Smart Consolidation & Layouts|Smart-Consolidation-and-Layouts]]
* [[Architecture & Mixins|Architecture-and-Mixins]]
* [[API & Addon Integration|API-and-Addon-Integration]]
