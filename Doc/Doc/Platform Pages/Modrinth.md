<p align="center">
  <h1 align="center">⚡ F3 Speedometer</h1>
  <p align="center">
    <strong>A lightweight, 100% zero-dependency mod adding a real-time Speedometer to Minecraft's F3 debug screen.</strong>
  </p>
  <p align="center">
    <a href="https://fabricmc.net/"><img src="https://img.shields.io/badge/Loader-Fabric-dbb15a?style=for-the-badge" alt="Fabric"></a>
    <a href="https://adoptium.net/"><img src="https://img.shields.io/badge/Java-25-orange?style=for-the-badge" alt="Java 25"></a>
    <a href="https://www.gnu.org/licenses/gpl-3.0.html"><img src="https://img.shields.io/badge/License-GPLv3-blue?style=for-the-badge" alt="GPLv3"></a>
  </p>
</p>

---

> **⚠️ Backport Disclaimer**: This project targets current stable Minecraft versions. **No backports to older versions will be developed.**

## 📖 Overview

**F3 Speedometer** seamlessly integrates movement velocity tracking directly into Minecraft's native **F3 Debug Screen** system (`DebugScreenEntries`).

Whether you are testing minecart speeds, optimizing elytra flight angles, riding horses, or sprinting through your base, F3 Speedometer gives you real-time numerical speed feedback without bloat or external dependencies.

---

## ✨ Features

- **⚡ Native F3 Entry**: Registered as `f3_speedometer:speedometer` within Minecraft's modular debug system.
- **📌 ALWAYS_ON Support**: Fully compatible with Minecraft's `ALWAYS_ON` F3 entry status—keep your speedometer visible on HUD even when the main F3 debug overlay is closed!
- **📐 3D Vector Breakdown**: Displays total speed (in blocks/second / m/s) alongside horizontal (H) and vertical (V) components:
  ```text
  Speed: 14.50 m/s (H: 12.30, V: 7.70)
  ```
- **🪶 100% Zero Dependencies**: Built strictly with Fabric Loader and vanilla code. No Fabric API, Cloth Config, or third-party libraries required.

---

## ⚙️ How to Enable Always-Active Mode

To keep the Speedometer on screen at all times:
1. Open your `.minecraft/debug-profile.json` file (or use F3 debug profile toggles).
2. Set `f3_speedometer:speedometer` status to `"alwaysOn"`.
3. The speedometer will remain cleanly visible on your HUD without displaying the rest of the F3 debug screen!

---

## 👥 Credits

| Role | Contributor |
| :--- | :--- |
| **Author & Developer** | **Dasik (Rifaditya)** |

---

## 📜 License & Modpacks

> **GPLv3 Licensed**. You are free to include **F3 Speedometer** in any modpack on any platform!

<p align="center">
  <em>Made with ❤️ for the Minecraft Modding Community.</em>
</p>
