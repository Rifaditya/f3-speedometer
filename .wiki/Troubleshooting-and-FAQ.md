# Troubleshooting & FAQ

This page provides answers to frequently asked questions and troubleshooting procedures for **Speedometer**.

---

## 📊 FAQ Infobox

| Question | Short Answer |
| :--- | :--- |
| **Is Speedometer required on the server?** | **No.** It is 100% client-side. |
| **Does it work on vanilla servers?** | **Yes.** Works on vanilla, Spigot, Paper, Fabric, and Forge servers. |
| **Why is speed shown as 0.00 b/s when standing still?** | Fixed in v1.1.0+ using native `Entity.getKnownSpeed()`. |
| **How do I toggle the display mode?** | Press **`F3 + F6`** in game. |

---

## ❓ Frequently Asked Questions

### Q1: Why do I see both `blocks/tick` and `b/s` on the same line?
This is **Smart Consolidation Mode**. When both vanilla's native `player_speed` (`blocks/tick`) and Speedometer's `speedometer` (`b/s`) are enabled in the `F3 + F6` menu, Speedometer combines them into one clean line:
`Speed: 0.215 blocks/tick, 4.30 b/s (H: 4.30, V: 0.00)`.

### Q2: How can I show ONLY blocks per second (`b/s`)?
1. Press **`F3 + F6`** to open Debug Options.
2. Set `player_speed` to **`OFF`**.
3. Set `speedometer` to **`In Overlay`**.

### Q3: Does Speedometer work when riding horses or boats?
Yes. Speedometer automatically tracks the velocity of whatever entity your camera is attached to (boats, minecarts, horses, pigs, or spectator targets).

---

## 🔧 Diagnostic Checklist

If Speedometer does not appear in your F3 overlay:
- [ ] Confirm `speedometer-1.2.2-26.2.jar` is in your `.minecraft/mods/` folder.
- [ ] Verify Fabric Loader is updated to version `0.15.0+`.
- [ ] Press `F3 + F6` and verify `speedometer` is NOT set to `OFF`.
- [ ] Ensure `F3` debug screen is active.

---

## 🔗 Related Pages

* [[Smart Consolidation & Layouts|Smart-Consolidation-and-Layouts]]
* [[Configuration|Configuration]]
* [[Home|Home]]
