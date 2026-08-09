# Developer Setup & Building

This guide documents the environment prerequisites, repository setup, build workflow, and automated testing instructions for technical contributors working on **Speedometer**.

---

## 📊 Developer Prerequisites Infobox

| Tool | Version Requirement | Purpose |
| :--- | :--- | :--- |
| **JDK** | **Java 25** (`org.gradle.java.home=E:/JDK25`) | Primary compilation Java Development Kit |
| **Gradle** | **9.3+** | Project build engine |
| **Fabric Loom** | **1.15+** | Minecraft mod development plugin |
| **Fabric Loader** | **0.19.1** | Runtime loader |
| **Minecraft Target** | **26.2** | Decompiled source mapping target |

---

## 🛠 Building from Source

### 1. Clone Repository
```bash
git clone https://github.com/Rifaditya/f3-speedometer.git
cd f3-speedometer
```

### 2. Execute Gradle Compilation
Run the Gradle build command using `--no-daemon` to ensure a clean build environment:

```bash
./gradlew build --no-daemon
```

Upon successful completion, the compiled JAR artifact will be located at:
```text
build/libs/speedometer-1.2.2-26.2.jar
```

---

## 🧪 Automated Testing Protocol

To execute unit tests and headless GameTest verification suites:

```bash
./gradlew test --no-daemon
```

---

## 🔗 Related Pages

* [[Architecture & Mixins|Architecture-and-Mixins]]
* [[API & Addon Integration|API-and-Addon-Integration]]
* [[Version Compatibility|Version-Compatibility]]
