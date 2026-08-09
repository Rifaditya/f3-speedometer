# Commands

This page documents the command integration status for **Speedometer**.

---

## 📊 Command System Infobox

| Property | Details |
| :--- | :--- |
| **Brigadier Commands** | None (Intentionally Omitted by Design) |
| **Configuration Interface** | Keybinding (`F3 + F6` Debug Menu) |
| **Permission Level Required** | None (Available to all players) |
| **Server Command Dependencies** | Zero |

---

## 💡 System Design & Keybinding Administration

**Speedometer** does not implement custom `/speedometer` Brigadier command trees or chat commands.

By design:
* All layout toggling and overlay administration are handled seamlessly via Minecraft's native **`F3 + F6` Debug Options Screen**.
* Eliminating chat commands ensures zero command clutter, zero permission node requirements, and zero risk of command collisions on multiplayer servers.

---

## 🔗 Related Pages

* [[Smart Consolidation & Layouts|Smart-Consolidation-and-Layouts]]
* [[Configuration|Configuration]]
* [[GameRules|GameRules]]
