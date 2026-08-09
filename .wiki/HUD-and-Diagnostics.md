# HUD & Diagnostics

This page provides a detailed breakdown of the HUD text output formats rendered by **Speedometer** under different configuration conditions.

---

## 📊 HUD Output Infobox

| Display Mode | Rendered Line Format |
| :--- | :--- |
| **Smart Consolidated** | `Speed: 0.215 blocks/tick, 4.30 b/s (H: 4.30, V: 0.00)` |
| **Standalone Speedometer** | `Speed: 4.30 b/s (H: 4.30, V: 0.00)` |
| **Pure Vanilla** | `Speed: 0.215 blocks/tick` |
| **Stationary / Rest** | `Speed: 0.00 b/s (H: 0.00, V: 0.00)` |

---

## 🔍 Line Element Breakdown

```text
Speed: 4.30 b/s (H: 4.30, V: 0.00)
|---1---| |-2--|      |-3--|   |-4--|
```

1. **Total Speed (`Speed: 4.30 b/s`)**: Total 3D movement speed computed across all axes ($X, Y, Z$) in blocks per second.
2. **Unit Label (`b/s`)**: Blocks per second ($20.0\text{ ticks} = 1.0\text{ second}$).
3. **Horizontal Component (`H: 4.30`)**: Ground velocity across the horizontal $X/Z$ plane in blocks per second.
4. **Vertical Component (`V: 0.00`)**: Elevation velocity along the vertical $Y$ axis in blocks per second.

---

## 🔗 Related Pages

* [[Smart Consolidation & Layouts|Smart-Consolidation-and-Layouts]]
* [[Velocity Math & Vectors|Velocity-Math-and-Vectors]]
* [[Dynamic HUD Formatting|Dynamic-HUD-Formatting]]
