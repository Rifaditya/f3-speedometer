# 玩家指南 - 速度計 (Speedometer)

## 快速上手 (Quick Start)
1. 安裝 Fabric Loader。
2. 將 `speedometer-1.2.4+<version>.jar` 放入遊戲目錄的 `.minecraft/mods` 資料夾。
3. 開啟 Minecraft 遊戲，按下 **`F3`** (或 **`F3 + F6`**) 即可檢視速度計資訊。

---

## 切換 F3 介面配置 (`F3 + F6`)
在遊戲中按下 **`F3 + F6`** 開啟 F3 除錯選項選單 (Debug Options Screen)。你可以自由自訂速度顯示的配置模式：

1. **同時開啟兩項** (單行智慧合併顯示)：
   `Speed: 0.215 blocks/tick, 4.30 b/s (H: 4.30, V: 0.00)`
2. **僅開啟 `speedometer` (速度計)**：
   `Speed: 4.30 b/s (H: 4.30, V: 0.00)`
3. **僅開啟 `player_speed` (原版)**：
   `Speed: 0.215 blocks/tick`

---

## 理解速度計顯示數值
- **Speed (總速度)**: 當前玩家在三度空間中的實際移動速度，單位為方塊每秒 (b/s)。
- **H (Horizontal / 水平速度)**: X/Z 地面軸向的移動速度 (例如步行、疾跑、騎馬、乘礦車、划船)。
- **V (Vertical / 垂直速度)**: Y 軸升降速度 (例如跳躍、落下、爬梯、鞘翅滑翔/拉升)。

---

## 常駐 HUD 懸浮顯示 (Always-Active HUD)
- 按下 **`F3 + F6`** 開啟 F3 除錯選項選單。
- 找到 **速度計 (speedometer)** 選項，將其狀態切換為 **`Always` (永遠顯示)**。
- 返回遊戲，即可在畫面上保持常駐輕量化速度 HUD，無需展開大面積的 F3 除錯介面！
