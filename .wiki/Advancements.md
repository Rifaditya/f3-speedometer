# Advancements

This page documents the advancement integration status for **Speedometer**.

---

## 📊 Advancement System Infobox

| Property | Details |
| :--- | :--- |
| **Custom Advancements** | None (Intentionally Omitted by Design) |
| **Advancement Framework** | Vanilla Minecraft Advancement System |
| **Mod Category** | Pure Client-Side Diagnostic Utility |
| **Data Pack Hooks** | None Required |

---

## 💡 System Design & Vanilla Reliance

**Speedometer** is a lightweight, client-side diagnostic utility designed solely to render player velocity in the F3 Debug Screen. 

By design:
* Speedometer **does not add custom advancement JSONs** or advancement trees to the game.
* Speedometer **relies entirely on vanilla Minecraft advancements** and does not alter achievement progression or vanilla gameplay rewards.
* Because the mod runs purely on the client side, it can be added or removed without affecting server-side advancement state or world save files.

---

## 🔗 Related Pages

* [[GameRules|GameRules]]
* [[Commands|Commands]]
* [[Home|Home]]
