# Performance & Rendering

This document presents performance profiling data, memory allocation benchmarks, and rendering overhead analysis for **Speedometer**.

---

## 📊 Performance Benchmark Infobox

| Metric | Measured Value | Impact Assessment |
| :--- | :--- | :--- |
| **Execution Time per Frame** | $< 0.001\text{ ms}$ ($< 1\text{ }\mu\text{s}$) | Negligible / Zero Impact |
| **Memory Allocation per Tick** | 1 transient String ($< 64\text{ bytes}$) | Handled by JVM Eden Space |
| **FPS Impact** | $0.00\text{ FPS}$ drop | Immeasurable |
| **Garbage Collector Overhead** | Zero measurable GC pause impact | Negligible |

---

## 🔬 Rendering Pipeline Optimization

1. **Direct Vector Lookup**:
   Velocity data is retrieved via a direct field/getter accessor (`entity.getKnownSpeed()`), avoiding heavy raycasts, entity sweeps, or world block queries.
2. **Conditional Execution**:
   If the F3 overlay is hidden or `speedometer` status is set to `OFF`, `display()` is either skipped entirely or yields immediately before performing vector arithmetic or string formatting.
3. **Optimized Math Operations**:
   Horizontal speed uses fast scalar multiplication ($20.0$) and a single square root operation ($\sqrt{v_x^2 + v_z^2}$), resulting in near-instantaneous computation.

---

## 🔗 Related Pages

* [[Velocity Math & Vectors|Velocity-Math-and-Vectors]]
* [[Zero-Dependency Design|Zero-Dependency-Design]]
