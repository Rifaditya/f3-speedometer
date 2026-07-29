<p align="center">
  <h1 align="center">⚡ Speedometer</h1>
  <p align="center">
    <strong>Player Speed but blocks per second.</strong>
  </p>
  <p align="center">
    <a href="https://fabricmc.net/"><img src="https://img.shields.io/badge/Loader-Fabric-dbb15a?style=for-the-badge" alt="Fabric"></a>
    <a href="https://adoptium.net/"><img src="https://img.shields.io/badge/Java-25-orange?style=for-the-badge" alt="Java 25"></a>
    <a href="https://www.gnu.org/licenses/gpl-3.0.html"><img src="https://img.shields.io/badge/License-GPLv3-blue?style=for-the-badge" alt="GPLv3"></a>
  </p>
</p>

---

> **⚠️ Backport Disclaimer**: This project targets current stable Minecraft versions. **No backports to older versions will be developed.**

## 🎬 Showcase

[![Speedometer + Max Elytra Speed Showcase](https://img.youtube.com/vi/Y1DDyWD-5es/maxresdefault.jpg)](https://youtu.be/Y1DDyWD-5es)

*Speedometer in action — combined with a max Elytra speed mod. Both `player_speed` and `speedometer` enabled simultaneously, showing consolidated real-time output.*

---

## 📖 Overview

You know the vanilla `player_speed` entry in F3 that shows `Speed: 0.215 blocks/tick`? **Speedometer** is that, but in **blocks per second** — a real-world-readable number that actually means something. It integrates directly into Minecraft's native F3 Debug Screen system, using the exact same tick-based physics data that vanilla uses.

---

## ✨ Features

- **⚡ Native F3 Entry**: Registered as a first-class `speedometer` option inside Minecraft's debug overlay system — not a hacky overlay on top.
- **🛠️ Three Configurable Layouts** via `F3 + F6` Debug Options:
  1. **Both Enabled** (Smart consolidated line):
     `Speed: 0.215 blocks/tick, 4.30 b/s (H: 4.30, V: 0.00)`
  2. **Only Speedometer Enabled** (blocks/sec only):
     `Speed: 4.30 b/s (H: 4.30, V: 0.00)`
  3. **Only Player Speed Enabled** (unchanged vanilla):
     `Speed: 0.215 blocks/tick`
- **📌 ALWAYS_ON HUD Support**: Pin your speedometer to screen even when the F3 overlay is hidden — set it to `Always` in the debug options.
- **📐 Dynamic & Jitter-Free**: Powered by vanilla's own pre-calculated physics tick vector (`getKnownSpeed()`), updating 20 times per second — no flickering, no frame-rate jitter, no extra performance cost.
- **↔️ H & V Breakdown**: See not just total speed but horizontal ground speed (**H**) and vertical fall/climb speed (**V**) separately.
- **🚗 Vehicle Support**: Accurate when riding horses, minecarts, boats, or pigs — it tracks the vehicle's movement automatically.
- **🪶 100% Zero Dependencies**: Just drop it in your mods folder. No Fabric API. No Cloth Config. Nothing else required.

---

## ⚙️ How to Use

1. Press **`F3 + F6`** in-game to open the **F3 Debug Options Screen**.
2. Find **`speedometer`** (and **`player_speed`** if on 26.3+).
3. Toggle their status: `Always`, `In Overlay`, or `OFF`.
4. The layout updates instantly based on what you enable.

---

## 👥 Credits

| Role | Contributor |
| :--- | :--- |
| **Author & Developer** | **Dasik (Rifaditya)** |

---

## 📜 License & Modpacks

> **GPLv3 Licensed**. You are free to include **Speedometer** in any modpack on any platform!

<p align="center">
  <em>Made with ❤️ for the Minecraft Modding Community.</em>
</p>
