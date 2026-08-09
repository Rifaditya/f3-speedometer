# Vehicle & Riding Physics

This page details how **Speedometer** accurately measures movement velocity while riding mounts, boats, minecarts, or flying with Elytra.

---

## 📊 Vehicle Physics Infobox

| Vehicle / State | Velocity Source | Typical Speed Range ($\text{b/s}$) | Peak Speed ($\text{b/s}$) |
| :--- | :--- | :--- | :--- |
| **Vanilla Boat (Water)** | Boat Entity | $8.00 - 9.00\text{ b/s}$ | $9.00\text{ b/s}$ |
| **Boat on Blue Ice** | Boat Entity | $40.00 - 70.00\text{ b/s}$ | $72.70\text{ b/s}$ |
| **Minecart (Powered Rail)** | Minecart Entity | $8.00\text{ b/s}$ | $8.00\text{ b/s}$ |
| **Horse (Max Stats)** | Horse Entity | $14.50 - 14.75\text{ b/s}$ | $14.75\text{ b/s}$ |
| **Pig (Carrot on a Stick)** | Pig Entity | $4.20 - 5.00\text{ b/s}$ | $6.80\text{ b/s}$ |
| **Elytra Glide / Dive** | Player Entity | $15.00 - 45.00\text{ b/s}$ | $67.50\text{ b/s}$ |

---

## 🏎 Camera Entity Velocity Resolution

When a player mounts an entity (e.g. a boat or horse), Minecraft shifts the client's camera entity or delegates movement authority. Speedometer retrieves velocity using:

```java
Entity entity = client.getCameraEntity();
if (entity == null) {
    entity = client.player;
}
Vec3 knownSpeed = entity.getKnownSpeed();
```

* **Riding Mounts**: `client.getCameraEntity()` automatically resolves to the ridden vehicle entity (or player camera attachment), extracting the exact server/client synced velocity vector of the mount.
* **Spectator Mode**: When spectating another player or entity, Speedometer displays the target entity's real-time movement velocity rather than zero.

---

## 🔗 Related Pages

* [[Velocity Math & Vectors|Velocity-Math-and-Vectors]]
* [[Camera & Entity Tracking|Camera-and-Entity-Tracking]]
