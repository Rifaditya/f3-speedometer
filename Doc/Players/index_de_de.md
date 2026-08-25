# Spielerhandbuch - Geschwindigkeitsmesser (Speedometer)

## Schnellstart (Quick Start)
1. Installiere Fabric Loader.
2. Platziere die Datei `speedometer-1.2.7+<version>.jar` in deinem `.minecraft/mods`-Ordner.
3. Starte Minecraft und drücke **`F3`** (oder **`F3 + F6`**), um die Geschwindigkeitsanzeige zu sehen.

---

## F3-Overlay-Layouts anpassen (`F3 + F6`)
Drücke im Spiel **`F3 + F6`**, um das Menü für Debug-Optionen (Debug Options Screen) zu öffnen. Du kannst das Anzeigeformat flexibel anpassen:

1. **Beide Optionen aktiviert** (Intelligente Zusammenführung in einer Zeile):
   `Speed: 0.215 blocks/tick, 4.30 b/s (H: 4.30, V: 0.00)`
2. **Nur `speedometer` aktiviert (Geschwindigkeitsmesser)**:
   `Speed: 4.30 b/s (H: 4.30, V: 0.00)`
3. **Nur `player_speed` aktiviert (Vanilla)**:
   `Speed: 0.215 blocks/tick`

---

## Bedeutung der Geschwindigkeitsanzeige
- **Speed (Gesamtgeschwindigkeit)**: Tatsächliche dreidimensionale Bewegungsgeschwindigkeit in Blöcken pro Sekunde (b/s).
- **H (Horizontal)**: Geschwindigkeit auf der X/Z-Bodenebene (Gehen, Sprinten, Reiten, Lore, Boot).
- **V (Vertikal)**: Vertikale Geschwindigkeit auf der Y-Achse (Springen, Fallen, Klettern, Elytrenflug).

---

## Dauerhafter HUD-Modus (Always-Active HUD)
- Drücke **`F3 + F6`**, um die F3-Optionen zu öffnen.
- Finde den Eintrag **Geschwindigkeitsmesser (speedometer)** und setze den Status auf **`Always` (Immer)**.
- Kehre ins Spiel zurück: Der Geschwindigkeitsmesser bleibt als schlankes HUD permanent sichtbar, ohne den gesamten F3-Bildschirm öffnen zu müssen!
