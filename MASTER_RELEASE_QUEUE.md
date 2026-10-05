# 🎛️ Master Release Queue: Vanilla Outsider — Speedometer

> **Mod Project Master Ground-Truth Document**  
> **Lead SemVer**: `1.2.13`

---

## 📊 Multi-Version Release Matrix & Queue Status

| Target MC | Generational Era | Live on Platforms | Next Queued Version | Status & Cadence Action | Feature Highlights / Notes |
| :--- | :--- | :--- | :--- | :--- | :--- |
| **MC 26.3** | Modern Lead | `1.2.13+26.3` | None | 🟢 **Up to Date** | Adopted Dasik Library 1.9.2 runtime dependency, creator support & unit tests. |
| **MC 26.2** | Modern Predecessor | `1.2.12+26.2` | `1.2.14+26.2` | 🟢 **Ready to Publish** | Fixed 26.2 build, restored Modrinth metadata, Dasik Library 1.9.2 support links & unit tests. |
| **MC 26.1.2** | Modern Predecessor | None | `1.2.13+26.1.2` | 🟢 **Ready to Publish** | Ported to Minecraft 26.1 / 26.1.2, Dasik Library 1.9.2 integration & unit tests. |
| **MC 1.21.11** | Anchor 1.21.11 | None | `1.2.13+1.21.11` | 🟢 **Ready to Publish** | Ported to Minecraft 1.21.11, Dasik Library 1.1.0+1.21.11 runtime integration & unit tests. |
| **MC 1.21.1** | Anchor 1.21.1 | None | `1.2.13+1.21.1` | 🟢 **Ready to Publish** | Ported to Minecraft 1.21.1, Dasik Library 1.1.0+1.21.1 runtime integration, unit tests, and F3 overlay speed display. |
| **MC 1.20.1** | Anchor 1.20.1 | None | `1.2.13+1.20.1` | 🟢 **Ready to Publish** | Ported to Minecraft 1.20.1, Dasik Library 1.1.0+1.20.1 runtime integration, unit tests, and F3 overlay speed display. |

---

## 🏛️ Project Operating Rules & Architectural Invariants

1. **📜 Subproject Changelog & Queue Segregation Law**:
   - Each version anchor subproject directory maintains its own dedicated `CHANGELOG.md` and `RELEASE_QUEUE.md` tracking solely that Minecraft version anchor with Strict Version Anchor Exclusivity.
