# Configuration

This page documents how to configure **Speedometer** using Minecraft's native debug screen options.

---

## 📊 Configuration Infobox

| Configuration System | Method |
| :--- | :--- |
| **Config Framework** | Native Vanilla F3 Options Screen (`DebugScreenEntryList`) |
| **Access Keybinding** | **`F3 + F6`** |
| **ConfigFile Location** | Native `options.txt` (Vanilla Debug Options) |
| **External Dependencies** | **None** (No ModMenu, Cloth Config, or YACL required) |

---

## ⚙️ How to Access & Adjust Options

```text
Press F3 + F6 in-game -> Navigate to F3 Options -> Locate "speedometer" -> Toggle Status
```

1. Launch Minecraft and enter any singleplayer world or multiplayer server.
2. Press **`F3 + F6`** on your keyboard to open the vanilla **F3 Debug Options Screen**.
3. Scroll through the entry list to locate `speedometer` (and `player_speed` on 26.3+).
4. Click on the entry to cycle between three display modes:
   - **`In Overlay`** (Default): Rendered whenever F3 debug mode is active.
   - **`Always`**: Continuously rendered on screen regardless of general F3 state.
   - **`OFF`**: Completely hidden.
5. Click **`Done`** to save.

---

## 🔗 Related Pages

* [[Smart Consolidation & Layouts|Smart-Consolidation-and-Layouts]]
* [[HUD & Diagnostics|HUD-and-Diagnostics]]
