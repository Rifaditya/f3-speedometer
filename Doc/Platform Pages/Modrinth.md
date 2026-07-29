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

*Speedometer in action — combined with a max Elytra speed mod. Works independently on its own, or consolidates with vanilla's `player_speed` into a single clean line when both are enabled.*

---

## 📖 Overview

You know the vanilla `player_speed` entry in F3 that shows `Speed: 0.215 blocks/tick`? **Speedometer** is that, but in **blocks per second** — a real-world-readable number that actually means something. It integrates directly into Minecraft's native F3 Debug Screen system, using the exact same tick-based physics data that vanilla uses.

---

## ✨ Features

- **⚡ Fully Independent**: Works on its own out of the box — no dependency on vanilla's `player_speed`. Just install and go.
- **🛠️ Smart Layouts** via `F3 + F6` Debug Options — three modes depending on what you enable:
  1. **Speedometer only** *(default)*:
     `Speed: 4.30 b/s (H: 4.30, V: 0.00)`
  2. **Both Speedometer + vanilla Player Speed** *(consolidated into one clean line on 26.3+)*:
     `Speed: 0.215 blocks/tick, 4.30 b/s (H: 4.30, V: 0.00)`
  3. **Vanilla Player Speed only** *(unchanged, if you prefer blocks/tick)*:
     `Speed: 0.215 blocks/tick`
- **📌 ALWAYS_ON HUD Support**: Pin your speedometer to screen even when the F3 overlay is hidden — set it to `Always` in the debug options.
- **📐 Dynamic & Jitter-Free**: Powered by vanilla's own pre-calculated physics tick vector (`getKnownSpeed()`), updating 20 times per second — no flickering, no frame-rate jitter, no extra performance cost.
- **↔️ H & V Breakdown**: See not just total speed but horizontal ground speed (**H**) and vertical fall/climb speed (**V**) separately.
- **🚗 Vehicle Support**: Accurate when riding horses, minecarts, boats, or pigs — it tracks the vehicle's movement automatically.
- **🪶 100% Zero Dependencies**: Just drop it in your mods folder. No Fabric API. No Cloth Config. Nothing else required.

---

## ⚙️ How to Use

**Speedometer works immediately after install — no setup needed.** It registers its own independent `speedometer` entry in F3.

1. Press **`F3 + F6`** in-game to open the **F3 Debug Options Screen**.
2. Find **`speedometer`** and toggle its status: `Always`, `In Overlay`, or `OFF`.
3. On Minecraft 26.3+, you'll also see vanilla's **`player_speed`** entry. If you enable both, they automatically **consolidate into one combined line** — no duplicate clutter.
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
