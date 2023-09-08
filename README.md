## Introduction
Provide APIs to draw huds in Minecraft

## Gradle
Change `repositories` block in `build.gradle` like this
```groovy
repositories {
    maven {
        credentials {
            username '63f608d25bcd108b0765c428'
            password 'At(L(RH7g5sv'
        }
        url 'https://packages.aliyun.com/maven/repository/2334497-release-xYw66J/'
    }
    maven {
        credentials {
            username '63f608d25bcd108b0765c428'
            password 'At(L (RH7g5sv'
        }
        url 'https://packages.aliyun.com/maven/repository/2334497-snapshot-qUPlEb/'
    }
}
```
Change `dependencies` block in `build.gradle` like this

```groovy
dependencies {
    minecraft "com.mojang:minecraft:${project.minecraft_version}"
    mappings "net.fabricmc:yarn:${project.yarn_mappings}:v2"
    modImplementation "net.fabricmc:fabric-loader:${project.loader_version}"
    modImplementation "ykkz000.hudapi:hud-api:1.0-SNAPSHOT"
}
```
