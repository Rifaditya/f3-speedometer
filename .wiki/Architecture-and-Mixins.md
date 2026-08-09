# Architecture & Mixins

This technical reference details the package hierarchy, source layout, and Mixin injection target breakdown for **Speedometer**.

---

## 📊 Package Architecture Diagram

```text
net.vanillaoutsider.speedometer
├── SpeedometerMod.java               <-- Constants & Identifier definitions
├── client
│   ├── SpeedometerClient.java        <-- ClientModInitializer entrypoint
│   ├── DebugEntrySpeedometer.java     <-- Custom DebugScreenEntry implementation
│   └── DebugEntryPlayerSpeedWrapper.java <-- Interceptor spy-wrapper for player_speed
└── mixin
    ├── DebugScreenEntriesMixin.java   <-- Hooks into DebugScreenEntries static init
    └── DebugScreenEntryListMixin.java <-- Enforces default IN_OVERLAY status
```

---

## 🧩 Mixin Target Breakdown Table

| Mixin Class | Target Minecraft Class | Target Method / Point | Injection Type | Purpose |
| :--- | :--- | :--- | :--- | :--- |
| `DebugScreenEntriesMixin` | `net.minecraft.client.gui.components.debug.DebugScreenEntries` | `<clinit>` `@At("TAIL")` | `@Inject` | Registers `speedometer` entry ID and wraps native `player_speed` entry if present. |
| `DebugScreenEntriesMixin` | `net.minecraft.client.gui.components.debug.DebugScreenEntries` | `register` | `@Invoker` | Invokes private vanilla `register(Identifier, DebugScreenEntry)` method. |
| `DebugScreenEntryListMixin` | `net.minecraft.client.gui.components.debug.DebugScreenEntryList` | `rebuildCurrentList` `@At("HEAD")` | `@Inject` | Ensures `speedometer` status defaults to `DebugScreenEntryStatus.IN_OVERLAY`. |

---

## 🔒 Thread Safety & Looper Rules

* **Render Thread Isolation**: All Mixin injections execute exclusively on Minecraft's Client Render Thread during static initialization or UI list rebuilding.
* **Non-Blocking Guarantee**: Zero blocking latches, thread synchronization locks, or futures are used in `DebugEntrySpeedometer.display()`, guaranteeing zero frame drops ($<0.001\text{ ms}$ cost).

---

## 🔗 Related Pages

* [[Developer Setup & Building|Developer-Setup-and-Building]]
* [[API & Addon Integration|API-and-Addon-Integration]]
* [[Zero-Dependency Design|Zero-Dependency-Design]]
