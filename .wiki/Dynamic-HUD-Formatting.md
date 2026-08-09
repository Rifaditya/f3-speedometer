# Dynamic HUD Formatting

This page documents the dynamic string formatting engine used by **Speedometer** to eliminate HUD jitter and text box resizing issues.

---

## 📊 Formatting Specification Infobox

| Property | Details |
| :--- | :--- |
| **Locale System** | `Locale.ROOT` (Guarantees `.` decimal separator worldwide) |
| **Format Specifier** | `%.2f` (Dynamic floating point conversion) |
| **Legacy Rigid Pattern (Banned)** | `%6.2f` (Fixed 6-char width with space padding) |
| **Current Pattern** | `String.format(Locale.ROOT, "Speed: %.2f b/s (H: %.2f, V: %.2f)", targetSpeed, targetHoriz, targetVert)` |

---

## 🛠 Solving String Jitter & Padding Issues

### Legacy Fixed Width Bug (`%6.2f`)
In early iterations, fixed-width string specifiers like `%6.2f` produced rigid space padding:
```text
"Speed:   4.30 b/s (H:   4.30, V:   0.00)"  <-- Unnecessary space gaps
```
This caused F3 debug text boxes to twitch and jump whenever speed shifted between single, double, and triple digits.

### Modern Dynamic Specifier (`%.2f`)
By adopting unpadded floating point specifiers (`%.2f`) evaluated under `Locale.ROOT`, Speedometer produces clean, dynamic text output:
```text
"Speed: 4.30 b/s (H: 4.30, V: 0.00)"
"Speed: 70.00 b/s (H: 70.00, V: 0.00)"
```
This ensures smooth text box resizing, zero horizontal jitter, and consistent decimal separation regardless of system language settings.

---

## 🔗 Related Pages

* [[Smart Consolidation & Layouts|Smart-Consolidation-and-Layouts]]
* [[Ground Rest Fixes|Ground-Rest-Fixes]]
