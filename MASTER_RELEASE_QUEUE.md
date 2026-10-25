# 🎛️ Master Release Queue: Vanilla Outsider — Speedometer

> **Mod Project Master Ground-Truth Document**  
> **Lead SemVer**: `1.2.13`

---

## 📊 Multi-Version Release Matrix & Queue Status

| Target MC | Generational Era | Live on Platforms | Next Queued Version | Status & Cadence Action | Feature Highlights / Notes |
| :--- | :--- | :--- | :--- | :--- | :--- |
| **MC 26.3** | Modern Lead | `1.2.14+26.3` | `1.2.15+26.3` | 🟢 **Ready to Publish** | Adopted 5-Pillar Testing Harness (Fuzzing, Concurrency, AST, Simulation, Sidedness Contract & Bytecode Scan). |
| **MC 26.2** | Modern Predecessor | `1.2.12+26.2` | `1.2.15+26.2` | 🟢 **Ready to Publish** | Adopted 5-Pillar Testing Harness (Fuzzing, Concurrency, AST, Simulation, Sidedness Contract & Bytecode Scan). |
| **MC 26.1.2** | Modern Predecessor | None | `1.2.15+26.1.2` | 🟢 **Ready to Publish** | Ported to MC 26.1.2; Adopted 5-Pillar Testing Harness (Fuzzing, Concurrency, AST, Simulation, Sidedness Contract). |
| **MC 1.21.11** | Anchor 1.21.11 | `1.2.13+1.21.11` | `1.2.15+1.21.11` | 🟢 **Ready to Publish** | Adopted 5-Pillar Testing Harness (Fuzzing, Concurrency, AST, Simulation, Sidedness Contract & Bytecode Scan). |
| **MC 1.21.1** | Anchor 1.21.1 | `1.2.13+1.21.1` | `1.2.15+1.21.1` | 🟢 **Ready to Publish** | Adopted 5-Pillar Testing Harness (Fuzzing, Concurrency, AST, DebugScreenOverlay Simulation, Sidedness Contract). |
| **MC 1.20.1** | Anchor 1.20.1 | `1.2.13+1.20.1` | `1.2.15+1.20.1` | 🟢 **Ready to Publish** | Adopted 5-Pillar Testing Harness (Fuzzing, Concurrency, AST, DebugScreenOverlay Simulation, Sidedness Contract). |

---

## 🏛️ Project Operating Rules & Architectural Invariants

1. **📜 Subproject Changelog & Queue Segregation Law**:
   - Each version anchor subproject directory maintains its own dedicated `CHANGELOG.md` and `RELEASE_QUEUE.md` tracking solely that Minecraft version anchor with Strict Version Anchor Exclusivity.
