# Camera & Entity Tracking

This page documents how **Speedometer** resolves entity targeting for HUD rendering when camera perspective or player state changes.

---

## 📊 Entity Tracking Infobox

| Camera Context | Evaluated Target | Speed Source |
| :--- | :--- | :--- |
| **Normal First/Third Person** | Player Entity (`client.player`) | `entity.getKnownSpeed()` |
| **Spectator Mode (Free Fly)** | Spectator Camera Entity | `entity.getKnownSpeed()` |
| **Spectator Mode (Mounted/Possessing Mob)** | Target Mob / Player | `entity.getKnownSpeed()` |
| **Mounted on Boat / Horse / Minecart** | Vehicle Entity | `entity.getKnownSpeed()` |
| **Null Entity Safety** | Fallback zero string | `Speed: 0.00 b/s (H: 0.00, V: 0.00)` |

---

## 🔄 Entity Resolution Logic

```java
Entity entity = client.getCameraEntity();
if (entity == null) {
    entity = client.player;
}

if (entity == null) {
    displayer.addLine("Speed: 0.00 b/s (H: 0.00, V: 0.00)");
    return;
}
```

1. **`client.getCameraEntity()`**: Primary lookup that checks the current active rendering viewpoint.
2. **`entity == null` Fallback**: If the camera entity returns null (e.g. during world loading or camera initialization), the code falls back to `client.player`.
3. **Null-Safety Guard**: If both camera entity and player are null, Speedometer safely outputs zero speed without causing NullPointerExceptions or thread crashes.

---

## 🔗 Related Pages

* [[Vehicle & Riding Physics|Vehicle-and-Riding-Physics]]
* [[Velocity Math & Vectors|Velocity-Math-and-Vectors]]
