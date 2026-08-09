# API & Addon Integration

This document outlines how developers can interface with **Speedometer** or inspect its registration patterns for custom F3 debug entries.

---

## 📊 API Summary Infobox

| Property | Specification |
| :--- | :--- |
| **Public Constants Class** | `net.vanillaoutsider.speedometer.SpeedometerMod` |
| **Speedometer Identifier** | `Identifier.withDefaultNamespace("speedometer")` |
| **Vanilla Player Speed Identifier** | `Identifier.withDefaultNamespace("player_speed")` |
| **Custom Entry Interface** | `net.minecraft.client.gui.components.debug.DebugScreenEntry` |

---

## 💡 Spy-Wrapper Pattern Reference

Developers seeking to extend or wrap vanilla debug entries can reference Speedometer's `DebugEntryPlayerSpeedWrapper` spy-wrapper pattern:

```java
public class DebugEntryPlayerSpeedWrapper implements DebugScreenEntry {
    private final DebugScreenEntry parent;

    public DebugEntryPlayerSpeedWrapper(DebugScreenEntry parent) {
        this.parent = parent;
    }

    @Override
    public void display(DebugScreenDisplayer displayer, Level level, LevelChunk clientChunk, LevelChunk serverChunk) {
        DebugScreenDisplayer spyDisplayer = new DebugScreenDisplayer() {
            @Override
            public void addLine(String line) {
                displayer.addLine(modifyLine(line));
            }
            
            private String modifyLine(String original) {
                if (original != null && original.startsWith("Speed: ")) {
                    // Append custom data
                    return original + ", custom suffix";
                }
                return original;
            }
        };
        parent.display(spyDisplayer, level, clientChunk, serverChunk);
    }
}
```

This pattern delegates rendering to the underlying vanilla entry while allowing dynamic string modification without breaking compatibility with other mods.

---

## 🔗 Related Pages

* [[Architecture & Mixins|Architecture-and-Mixins]]
* [[Developer Setup & Building|Developer-Setup-and-Building]]
