## Introduction
Provide APIs to draw huds in Minecraft

## Gradle
Change `repositories` block in `build.gradle` like this
```groovy
repositories {
    maven {
        name = "llj2003"
        url = "https://gitee.com/llj2003/maven/raw/master/repository"
    }
}
```
Change `dependencies` block in `build.gradle` like this

```groovy
dependencies {
    minecraft "com.mojang:minecraft:${project.minecraft_version}"
    mappings "net.fabricmc:yarn:${project.yarn_mappings}:v2"
    modImplementation "net.fabricmc:fabric-loader:${project.loader_version}"
    modImplementation "llj2003.hudapi:hud-api:1.0-SNAPSHOT"
}
```
