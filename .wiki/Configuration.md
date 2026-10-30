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

## 📦 Uninstallation & World Save Lifecycle

Because this mod utilizes native vanilla GameRules for per-world configuration (rather than a static global config file), active rule values are saved directly inside each world's data file (`saves/<world>/level.dat` under `Data.GameRules`).

### What Happens If You Remove the Mod:
If you uninstall this mod and load an existing world that was previously played with it:
1. **Informational Log Warning:** Vanilla Minecraft will log warning lines in `latest.log`:
   `Unknown registry key in ResourceKey[minecraft:root / minecraft:game_rule]: speedometer:...`
2. **`minecraft:root` is an in-memory Java registry, NOT a folder:** `ResourceKey[minecraft:root / ...]` is Mojang's internal code identifier for the game's in-memory registry hierarchy. It is strictly an in-memory data structure in Java, not a physical directory on your drive. Zero files in your `.minecraft` directory or system are modified or overwritten.
3. **Identical to Mojang's Engine Mechanics:** This operates **exactly like how Mojang handles removed, renamed, or changed GameRules between vanilla updates** (or disabled experimental data packs). Minecraft safely skips over unknown keys during gameplay.
4. **Automatic Vanilla Pruning on Save:** Vanilla Minecraft only serializes active, registered GameRules when saving. The moment you save the world (**"Save and Quit to Title"** or after an auto-save), vanilla writes a clean `level.dat` containing only recognized keys, permanently purging all orphaned rules. Subsequent world loads will produce zero warnings.
5. **Harmless:** The warning is completely safe to ignore.

---

## 🔗 Related Pages

* [[Smart Consolidation & Layouts|Smart-Consolidation-and-Layouts]]
* [[HUD & Diagnostics|HUD-and-Diagnostics]]
