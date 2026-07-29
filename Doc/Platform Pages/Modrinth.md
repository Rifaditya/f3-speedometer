<p align="center">
    <img src="https://img.shields.io/badge/Zero_Dependencies-No_Fabric_API_Needed-success?style=for-the-badge" alt="Zero Dependencies">
    <img src="https://img.shields.io/badge/Language-Java_25-orange?style=for-the-badge&logo=java" alt="Java 25">
    <img src="https://img.shields.io/badge/License-GPLv3-green?style=for-the-badge" alt="License">
    <img src="https://img.shields.io/badge/Minecraft-26.2+-brightgreen?style=for-the-badge" alt="Minecraft 26.2+">
</p>

# ⚡ Speedometer

**Active Version Policy:** I build **1 JAR for 1 Version**. I only update and maintain the latest active Minecraft version (e.g. when 26.3 is released, 26.2 is retired). No backports or legacy version maintenance. Please do not ask.

**The Vanilla Problem:** The vanilla `player_speed` F3 entry shows your speed in **blocks/tick** — a physics unit that means nothing to most players. `0.215 blocks/tick` doesn't tell you how fast you're actually moving. Is that fast? Is that slow? Nobody knows.

**Speedometer** fixes this by adding a dedicated F3 debug entry that shows your speed in **blocks per second** — the same unit your brain actually understands. It works fully independently, uses vanilla's own tick-based physics data, and even consolidates with `player_speed` into a single clean line on Minecraft 26.3+.

---

## 🎬 Showcase

<iframe width="560" height="315" src="https://www.youtube-nocookie.com/embed/Y1DDyWD-5es" title="Speedometer Showcase" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>

*Speedometer in action — combined with a max Elytra speed mod. Works independently on its own, or consolidates with vanilla's `player_speed` into a single clean line when both are enabled.*

---

## ✨ Features

### ⚡ Fully Independent

Speedometer registers its own dedicated `speedometer` entry in Minecraft's native `DebugScreenEntries` system — completely separate from, and not requiring, vanilla's `player_speed`. Install it and it just works.

> [!NOTE]
> **No dependency on `player_speed`**: Speedometer works on **all Minecraft versions 26.2+**, whether or not vanilla's `player_speed` entry exists.

### 🛠️ Smart Layouts (F3 + F6)

Three display modes, controlled entirely through vanilla's **F3 Debug Options Screen** (`F3 + F6`). No config files. No commands. Just toggle what you want:

1. **Speedometer only** *(default — works on all versions)*:
   `Speed: 4.30 b/s (H: 4.30, V: 0.00)`
2. **Both Speedometer + vanilla Player Speed** *(26.3+ only — smart consolidated line)*:
   `Speed: 0.215 blocks/tick, 4.30 b/s (H: 4.30, V: 0.00)`
3. **Vanilla Player Speed only** *(26.3+ only — unchanged, your choice)*:
   `Speed: 0.215 blocks/tick`

> [!TIP]
> **Smart Consolidation**: When both entries are enabled on 26.3+, they automatically merge onto a **single line** — no duplicate clutter, no wasted HUD space.

<p align="center">
  <img src="https://raw.githubusercontent.com/Rifaditya/f3-speedometer/main/Doc/Assets/screenshot_combined.png" alt="Both player_speed and speedometer enabled — combined output" width="600">
</p>
<p align="center"><em>Both <code>player_speed</code> and <code>speedometer</code> enabled simultaneously — one clean consolidated line.</em></p>

### 📌 ALWAYS_ON HUD Support

Don't want to keep F3 open? Set `speedometer` to **`Always`** in the F3 Debug Options Screen and your speedometer stays pinned to the screen permanently — even when the full F3 debug overlay is closed.

### 📐 Dynamic & Jitter-Free

Powered by vanilla's own pre-calculated physics tick vector (`Entity.getKnownSpeed()`), which updates exactly **20 times per second** in sync with the physics engine. The display string dynamically scales — no fixed-width space padding, no frame-rate jitter, no flickering.

> [!NOTE]
> **Zero extra performance cost**: We read vanilla's already-computed velocity vector. No redundant physics calculations are performed.

### ↔️ H & V Speed Breakdown

The speedometer shows three values at a glance:
- **Total Speed** — your full 3D movement velocity in blocks per second
- **H (Horizontal)** — ground movement speed across the X/Z plane (walking, sprinting, flying, riding)
- **V (Vertical)** — fall or climb speed on the Y axis (jumping, falling, Elytra pitching)

### 🚗 Vehicle & Riding Support

Speedometer accurately tracks movement while riding any vehicle — horses, minecarts, boats, striders, pigs. It reads the vehicle's velocity when you're a passenger, not your own entity's.

### 🪶 100% Zero Dependencies

Drop the JAR in your mods folder and done. No Fabric API. No Cloth Config. No DasikLibrary. No anything — just Fabric Loader.

---

## 📦 Installation & Environment

### ⚛️ Environment Support

* [x] **Client-side only**: All functionality is done client-side and is compatible with vanilla servers.
  * [x] Works in singleplayer too
  * [x] Works in multiplayer (you see your own speed)
* [ ] **Server-side only**
* [ ] **Client and server**

### 📥 Install Instructions

1. Install **[Fabric Loader](https://fabricmc.net/use/installer/)**.
2. Download the latest **Speedometer** JAR for your Minecraft version.
3. Place the JAR in your `.minecraft/mods` folder.
4. Launch Minecraft — press `F3` and your speedometer is there.

> [!TIP]
> **Optional**: Press `F3 + F6` to open the Debug Options Screen and configure whether `speedometer` shows `Always`, `In Overlay`, or `OFF`.

---

## 🔗 Compatibility

| Feature | Fabric (26.2+) |
| :--- | :---: |
| Singleplayer | ✅ |
| Multiplayer (LAN/Server) | ✅ |
| Vanilla Clients | ✅ |
| Dedicated Server Only | ❌ (client mod) |
| **IG: Max Elytra Fly Speed** | ✅ |
| **IG: Creative Hyper Speed** | ✅ |

### 🎮 Version Compatibility & Support

| Minecraft Version | Status |
| :--- | :---: |
| 26.2 and above (current) | ✅ Active |
| 26.1.x and below | ❌ Not supported |

---

## ❤ Support

If you enjoy **Speedometer** and the **Vanilla Outsider** philosophy, consider fueling the next update with a coffee!

[![Ko-fi](https://img.shields.io/badge/Ko--fi-Support%20Me-FF5E5B?style=for-the-badge&logo=ko-fi&logoColor=white)](https://ko-fi.com/dasikigaijin/tip)
[![SocioBuzz](https://img.shields.io/badge/SocioBuzz-Local_Support-7BB32E?style=for-the-badge)](https://sociabuzz.com/dasikigaijin/tribe)
[![Saweria](https://img.shields.io/badge/Saweria-Local_Support-FFA500?style=for-the-badge)](https://saweria.co/DasikIgaijinn)

> [!NOTE]
> **Indonesian Users:** SocioBuzz and Saweria support local payment methods (Gopay, OVO, Dana, etc.) if you want to support me without using PayPal/Ko-fi!

---

## 👤 Credits

| Role | Author |
| :--- | :--- |
| **Creator** | Dasik (Rifaditya) |
| **Collection** | Vanilla Outsider |
| **License** | GNU GPLv3 |

---

> [!IMPORTANT]
> This mod is part of the **Vanilla Outsider** collection. You are free to use it in modpacks, videos, and servers.
>
> **Modpack Permissions:** You are free to include this mod in modpacks, **provided the modpack is hosted on the same platform** (e.g. Modrinth).
>
> **Cross-platform distribution is not permitted.** If you download this mod from Modrinth, your modpack must also be published on Modrinth.

---

<div align="center">

**Made with ❤️ for the Minecraft community**

*Part of the Vanilla Outsider Collection*

</div>
