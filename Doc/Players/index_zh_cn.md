# 玩家指南 - 速度计 (Speedometer)

## 快速上手 (Quick Start)
1. 安装 Fabric Loader。
2. 将 speedometer-1.2.3-26.2.jar 放入游戏目录的 .minecraft/mods 文件夹。
3. 打开 Minecraft 游戏，按下 **F3** (或 **F3 + F6**) 即可查看速度计信息。

---

## 切换 F3 界面布局 (F3 + F6)
在游戏中按下 **F3 + F6** 打开 F3 调试选项菜单 (Debug Options Screen)。你可以自由定制速度显示的布局模式：

1. **同时开启两项** (单行智能合并显示)：
   Speed: 0.215 blocks/tick, 4.30 b/s (H: 4.30, V: 0.00)
2. **仅开启 speedometer (速度计)**：
   Speed: 4.30 b/s (H: 4.30, V: 0.00)
3. **仅开启 player_speed (原版)**：
   Speed: 0.215 blocks/tick

---

## 理解速度计显示数值
- **Speed (总速度)**: 当前玩家在三维空间中的实际移动速度，单位为方块每秒 (b/s)。
- **H (Horizontal / 水平速度)**: X/Z 地面轴向的移动速度 (例如步行、疾跑、骑马、乘矿车、开船)。
- **V (Vertical / 垂直速度)**: Y 轴升降速度 (例如跳跃、下落、爬梯、鞘翅滑翔/拉升)。

---

## 常驻 HUD 悬浮显示 (Always-Active HUD)
- 按下 **F3 + F6** 打开 F3 调试选项菜单。
- 找到 **速度计 (speedometer)** 选项，将其状态切换为 **Always (始终显示)**。
- 返回游戏，即可在屏幕上保持常驻轻量级速度 HUD，无需展开大面积的 F3 调试界面！
