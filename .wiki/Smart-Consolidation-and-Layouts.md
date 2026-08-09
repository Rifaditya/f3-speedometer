# Smart Consolidation & Layouts

This page explains how **Speedometer** handles overlay layouts and smart line consolidation in Minecraft's F3 debug screen.

---

## 📊 Layout Matrix Infobox

| `player_speed` Status | `speedometer` Status | Rendered F3 Line Output | Mode Name |
| :--- | :--- | :--- | :--- |
| **Enabled** (`In Overlay`) | **Enabled** (`In Overlay`) | `Speed: 0.215 blocks/tick, 4.30 b/s (H: 4.30, V: 0.00)` | **Smart Consolidation Mode** |
| **OFF** | **Enabled** (`In Overlay`) | `Speed: 4.30 b/s (H: 4.30, V: 0.00)` | **Standalone Speedometer Mode** |
| **Enabled** (`In Overlay`) | **OFF** | `Speed: 0.215 blocks/tick` | **Pure Vanilla Mode** |
| **OFF** | **OFF** | *(Line Hidden)* | **Disabled Mode** |

---

## ⚙️ How to Toggle Options (`F3 + F6`)

1. Press **`F3 + F6`** while in game to open the vanilla **F3 Debug Options Screen**.
2. Scroll to locate `speedometer` and `player_speed`.
3. Click to cycle the display status for each entry:
   - `Always`: Always rendered regardless of general overlay toggles.
   - `In Overlay`: Rendered whenever F3 debug overlay is active.
   - `OFF`: Completely hidden from the F3 screen.
4. Press `Done` or `Esc` to return to gameplay. Speedometer immediately re-evaluates the layout configuration without needing a game restart or world reload.

---

## 🔍 Smart Consolidation Mechanism

When both `player_speed` and `speedometer` are enabled, displaying two separate lines on screen creates unnecessary visual clutter:

```text
-- Cluttered Unconsolidated Output --
Speed: 0.215 blocks/tick
Speed: 4.30 b/s (H: 4.30, V: 0.00)
```

To solve this, `DebugEntryPlayerSpeedWrapper` intercepts the string line emitted by vanilla's `player_speed` entry. When vanilla emits `"Speed: 0.215 blocks/tick"`, our wrapper intercepts the call and appends the calculated blocks per second details directly to the existing line:

```text
-- Smart Consolidated Output --
Speed: 0.215 blocks/tick, 4.30 b/s (H: 4.30, V: 0.00)
```

Simultaneously, `DebugEntrySpeedometer` detects that the wrapper is handling the output and yields execution to avoid duplicate rendering.

---

## 🔗 Related Pages

* [[F3 Debug Integration|F3-Debug-Integration]]
* [[Dynamic HUD Formatting|Dynamic-HUD-Formatting]]
* [[Configuration|Configuration]]
