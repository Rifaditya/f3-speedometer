# Ground Rest Fixes

This page documents the historical resolution of standing-still velocity artifacts (`1.57 m/s` or residual gravity deltas) while resting on blocks.

---

## 📊 Ground Rest Fix Infobox

| Aspect | Legacy Implementation (v1.0.0) | Modern Implementation (v1.1.0+) |
| :--- | :--- | :--- |
| **Physics Method** | Custom position delta ($\Delta p = p_t - p_{t-1}$) | Vanilla `Entity.getKnownSpeed()` API |
| **Resting Speed Issue** | Showed $1.57\text{ m/s}$ due to gravity resets | Shows $0.00\text{ b/s}$ cleanly when stationary |
| **Ground Detection** | Ad-hoc block collision checks | Native Minecraft velocity vector management |
| **Accuracy** | Prone to tick rounding errors | 100% precision aligned with vanilla physics |

---

## 🛠 Problem & Solution Analysis

### The Legacy Resting Artifact
In early releases (v1.0.0), calculating velocity by subtracting coordinates between consecutive render frames caused a bug: when standing on solid ground, Minecraft continuously resets the player's downward velocity downward vector ($v_y \approx -0.0784$). Custom delta calculations recorded this as active movement, resulting in phantom speed readings of $1.57\text{ m/s}$ while standing completely still.

### The Fix: Native `getKnownSpeed()` Integration
Starting in v1.1.0, Speedometer eliminated custom position delta calculations in favor of Minecraft's native `Entity.getKnownSpeed()` API:

```java
Vec3 knownSpeed = entity.getKnownSpeed();
```

Because vanilla's `getKnownSpeed()` accounts for block collisions and ground friction state before committing the movement vector, stationary players and entities cleanly report $(0.00, 0.00, 0.00)$, yielding $0.00\text{ b/s}$.

---

## 🔗 Related Pages

* [[Velocity Math & Vectors|Velocity-Math-and-Vectors]]
* [[Version Compatibility|Version-Compatibility]]
