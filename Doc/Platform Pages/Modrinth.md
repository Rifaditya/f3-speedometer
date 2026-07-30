<p align="center">
    <img src="https://img.shields.io/badge/Zero_Dependencies-No_Fabric_API_Needed-success?style=for-the-badge" alt="Zero Dependencies">
    <img src="https://img.shields.io/badge/Language-Java_25-orange?style=for-the-badge&logo=java" alt="Java 25">
    <img src="https://img.shields.io/badge/License-GPLv3-green?style=for-the-badge" alt="License">
    <img src="https://img.shields.io/badge/Minecraft-26.2+-brightgreen?style=for-the-badge" alt="Minecraft 26.2+">
</p>

# ⚡ Speedometer

> **Player Speed but blocks per second.**

**Active Version Policy:** I build **1 JAR for 1 Version**. I only update and maintain the latest active Minecraft version (e.g. when 26.3 is released, 26.2 is retired). No backports or legacy version maintenance. Please do not ask.

Every Minecraft player knows the frustration: you press F3, look for your speed, and vanilla gives you `0.215 blocks/tick`. A raw physics calculation unit that means nothing during normal gameplay. Is that fast? Is that slow? How fast are you actually flying with Elytra or riding a horse?

**Speedometer** fixes this foundation. It adds a native F3 debug entry that converts your movement into real-world readable **blocks per second (b/s)**. Powered directly by vanilla's 20 tps physics engine (`getKnownSpeed()`), it updates dynamically, breaks down horizontal vs vertical velocity, works on vehicles, and seamlessly consolidates with vanilla's `player_speed` on Minecraft 26.3+.

Part of the **Vanilla Outsider Collection** — mods that refine the vanilla experience with modern standards.

---

## 🎬 Showcase Video

<iframe width="560" height="315" src="https://www.youtube-nocookie.com/embed/Y1DDyWD-5es" title="Speedometer Showcase" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>

*Click the player above to watch the mod showcase in action!*

---

## ✨ Features

### ⚡ Fully Independent F3 Debug Entry
Speedometer registers its own dedicated `speedometer` option inside Minecraft's native `DebugScreenEntries` system (`F3 + F6`). It operates completely on its own — requiring zero external libraries or vanilla `player_speed` entries.

> [!NOTE]
> **Native Integration**: Registered as a first-class debug entry in Minecraft's debug overlay system — not a hacky screen overlay.

### 🛠️ Smart Display Layouts (F3 + F6)
Choose your preferred display mode directly in the in-game **F3 Debug Options Screen** (`F3 + F6`):

1. **Speedometer Only** *(Default — all versions)*:
   `Speed: 58.79 b/s (H: 58.62, V: 4.47)`
2. **Both Enabled (Smart Consolidation)** *(26.3+)*:
   `Speed: 2.049 blocks/tick, 40.97 b/s (H: 37.46, V: 16.60)`
3. **Vanilla Player Speed Only** *(26.3+)*:
   `Speed: 0.215 blocks/tick`

> [!TIP]
> **Smart Consolidation**: When both `player_speed` and `speedometer` are enabled in F3 options, they automatically merge into a single clean line to save HUD space.

**Speedometer Only (Standalone):**

<p align="center">
  <img src="https://raw.githubusercontent.com/Rifaditya/f3-speedometer/main/Doc/Assets/screenshot_speedometer_only.png" alt="Speedometer Only" width="100%">
</p>

**Both Enabled (Consolidated):**

<p align="center">
  <img src="https://raw.githubusercontent.com/Rifaditya/f3-speedometer/main/Doc/Assets/screenshot_combined.png" alt="Both Speedometer and Player Speed Enabled" width="100%">
</p>

### 📌 ALWAYS_ON HUD Pinning
Want to track your speed without keeping the entire F3 debug wall open? Toggle `speedometer` to **`Always`** in the `F3 + F6` menu to keep a minimal speedometer pinned to your screen at all times.

### 📐 Dynamic Scaling & Jitter-Free Physics
Unlike static formatted debug text, Speedometer uses dynamic string sizing that expands and shrinks flawlessly as your velocity changes. By sampling vanilla's pre-calculated `Entity.getKnownSpeed()` vector once per tick, it provides smooth, jitter-free output with **zero performance overhead**.

### ↔️ Horizontal (H) & Vertical (V) Breakdown
Get instant insight into your movement dynamics:
- **Total Speed**: Complete 3D velocity vector magnitude.
- **H (Horizontal)**: Ground, sprinting, and lateral movement speed.
- **V (Vertical)**: Jump height velocity, falling speed, and Elytra pitch rate.

### 🚗 Vehicle & Mount Tracking
Speedometer automatically detects when you are riding a horse, minecart, boat, pig, or strider, tracking the vehicle's actual movement velocity instead of player entity position.

### 🪶 100% Zero Dependencies
Built for pure performance. No Fabric API required. No Cloth Config. No third-party library dependencies. Just drop the JAR into your `mods` folder.

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
4. Launch Minecraft — press `F3` (or `F3 + F6` to configure).

---

## 🔗 Compatibility

| Feature | Fabric (26.2+) |
| :--- | :---: |
| Singleplayer | ✅ |
| Multiplayer (LAN/Server) | ✅ |
| Vanilla Servers | ✅ |
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
