# Fepar Client Project

This is the first actual Fepar codebase: a Windows-friendly Java launcher starter plus a Minecraft client-core starter for 1.21.11.

## Launcher
Requires Java 21.

Compile:
```text
javac -d out src/com/fepar/launcher/FeparLauncher.java
jar --create --file FeparLauncher.jar --main-class com.fepar.launcher.FeparLauncher -C out .
java -jar FeparLauncher.jar
```

On Windows, turn the JAR into an installer with:
```text
jpackage --type exe --name FeparLauncher --input . --main-jar FeparLauncher.jar --main-class com.fepar.launcher.FeparLauncher
```

## Client
The client-core is intentionally a starter. It does not contain cheats or authentication bypasses. Connect it to a Fabric 1.21.11 development environment to implement the actual Minecraft modules.

Planned modules:
- Fullbright
- Freelook
- Custom HUD/settings
- Free cosmetics/capes
- Replay
- Version adapters for later Minecraft releases
