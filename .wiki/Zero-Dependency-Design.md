# Zero-Dependency Design

This document details the engineering rationale behind **Speedometer**'s **100% Zero-Dependency** design architecture.

---

## 📊 Dependency Comparison Infobox

| Category | Standard Fabric Mod | Speedometer |
| :--- | :--- | :--- |
| **Fabric Loader Requirement** | `0.15.0+` | `0.15.0+` |
| **Fabric API Requirement** | Required (`fabric-api`) | **Not Required (0 Dependencies)** |
| **GUI Framework Requirement** | Required (`cloth-config` / `yacl`) | **Not Required (Uses Vanilla F3+F6)** |
| **JAR File Size** | $\sim 500\text{ KB} - 2\text{ MB}$ | **$\sim 78\text{ KB}$** |
| **Initialization Overhead** | $\sim 50 - 200\text{ ms}$ | **$< 1\text{ ms}$** |

---

## 💡 Rationale & Benefits

1. **Maximum Portability & Compatibility**:
   By depending exclusively on standard Fabric Loader and native Minecraft APIs, Speedometer remains resilient against breaking Fabric API updates and third-party library deprecations.
2. **Zero Overhead**:
   Without extra library initialization code or external config engines, Speedometer loads in less than $1\text{ ms}$ during game launch.
3. **Ultra-Lightweight Footprint**:
   The entire compiled JAR artifact is under $80\text{ KB}$, making it ideal for client modpacks where storage and startup performance are critical.

---

## 🔗 Related Pages

* [[Performance & Rendering|Performance-and-Rendering]]
* [[Architecture & Mixins|Architecture-and-Mixins]]
