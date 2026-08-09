# Velocity Math & Vectors

This page details the mathematical formulas, vector mechanics, and tick-to-second conversions used by **Speedometer** to compute player and entity movement speed.

---

## 📊 Mathematical Mechanics Infobox

| Property | Formula / Value |
| :--- | :--- |
| **Vanilla Tick Rate** | $20.0\text{ ticks} = 1.0\text{ second}$ |
| **Native Speed Source** | `entity.getKnownSpeed()` ($\text{Vec3}$) |
| **Total 3D Speed ($S$)** | $S = \sqrt{v_x^2 + v_y^2 + v_z^2} \times 20.0$ |
| **Horizontal Speed ($H$)** | $H = \sqrt{v_x^2 + v_z^2} \times 20.0$ |
| **Vertical Speed ($V$)** | $V = |v_y| \times 20.0$ |
| **Unit of Measurement** | Blocks per Second ($\text{b/s}$) |
| **Display Precision** | Floating point formatted to 2 decimals (`%.2f`) |

---

## 🧮 Mathematical Formulas

Minecraft calculates entity movement internally per tick. Let $\vec{v} = (v_x, v_y, v_z)$ represent the velocity vector returned by `entity.getKnownSpeed()` in units of $\text{blocks/tick}$.

### 1. Total 3D Velocity Conversion
To convert total 3D velocity from $\text{blocks/tick}$ to $\text{blocks/second}$ ($\text{b/s}$):

$$S_{\text{bps}} = \|\vec{v}\| \times 20.0 = \sqrt{v_x^2 + v_y^2 + v_z^2} \times 20.0$$

### 2. Horizontal Velocity ($H$)
Ground speed across the Cartesian $X$ and $Z$ axes (ignoring elevation changes):

$$H_{\text{bps}} = \sqrt{v_x^2 + v_z^2} \times 20.0$$

### 3. Vertical Velocity ($V$)
Vertical speed along the $Y$ axis (climbing, falling, flying, or jumping):

$$V_{\text{bps}} = |v_y| \times 20.0$$

---

## 🔄 Tick-to-Second Conversion Matrix

Below are sample velocity values comparing raw vanilla $\text{blocks/tick}$ with Speedometer's $\text{blocks/second}$ output:

| Movement Action | Raw Velocity ($\text{blocks/tick}$) | Horizontal ($H$) | Vertical ($V$) | Speedometer Output ($\text{b/s}$) |
| :--- | :--- | :--- | :--- | :--- |
| **Walking** | $0.215\text{ b/t}$ | $4.30\text{ b/s}$ | $0.00\text{ b/s}$ | `Speed: 4.30 b/s (H: 4.30, V: 0.00)` |
| **Sprinting** | $0.280\text{ b/t}$ | $5.60\text{ b/s}$ | $0.00\text{ b/s}$ | `Speed: 5.60 b/s (H: 5.60, V: 0.00)` |
| **Sprinting + Jumping** | $0.340\text{ b/t}$ | $6.20\text{ b/s}$ | $2.42\text{ b/s}$ | `Speed: 6.66 b/s (H: 6.20, V: 2.42)` |
| **Boat (Blue Ice)** | $3.500\text{ b/t}$ | $70.00\text{ b/s}$ | $0.00\text{ b/s}$ | `Speed: 70.00 b/s (H: 70.00, V: 0.00)` |
| **Elytra Terminal Dive** | $2.500\text{ b/t}$ | $30.00\text{ b/s}$ | $40.00\text{ b/s}$ | `Speed: 50.00 b/s (H: 30.00, V: 40.00)` |

---

## 🔗 Related Pages

* [[F3 Debug Integration|F3-Debug-Integration]]
* [[Dynamic HUD Formatting|Dynamic-HUD-Formatting]]
* [[Ground Rest Fixes|Ground-Rest-Fixes]]
