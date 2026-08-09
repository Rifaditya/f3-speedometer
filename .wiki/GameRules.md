# GameRules

This page documents the GameRule configuration status for **Speedometer**.

---

## 📊 GameRule System Infobox

| Property | Details |
| :--- | :--- |
| **Namespaced GameRules** | None (Intentionally Omitted by Design) |
| **Server State Modification** | Zero (Pure Client-Side Mod) |
| **Multiplayer Compatibility** | Vanilla Servers, Fabric, Forge, Paper, Spigot |
| **Configuration Interface** | In-Game `F3 + F6` Debug Options Screen |

---

## 💡 System Design & Client-Side Scope

**Speedometer** operates strictly as a client-side mod.

By design:
* Speedometer **does not register namespaced GameRules** or modify server-side gamerule registries.
* Because velocity calculations occur locally on the client using the player camera entity's motion vector, Speedometer works on **any Minecraft server** (including pure vanilla servers) without requiring server-side mod installation or server administrator permissions.
* Display options are managed client-side via Minecraft's native `F3 + F6` Debug Options Screen.

---

## 🔗 Related Pages

* [[Configuration|Configuration]]
* [[Commands|Commands]]
* [[Zero-Dependency Design|Zero-Dependency-Design]]
