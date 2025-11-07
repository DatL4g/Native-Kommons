---
tags:
  - Android
  - JVM
  - Apple
  - Linux
  - Web
  - Windows
---

# NanoId

A Kotlin Multiplatform port of [this JavaScript library](https://github.com/ai/nanoid), providing a fast, secure, and URL-friendly unique ID generator.

## 🎯 Supported Targets

The following targets are supported:

| Platform           | Targets                                  |
|:-------------------|:-----------------------------------------|
| **JVM & Android**  | `jvm`, `android`                         |
| **Apple**          | `ios`, `macos`, `tvos`, `watchos`        |
| **Web**            | `js`, `wasmJs`                           |
| **Native & Other** | `linux`, `mingw`                         |

## ✨ Features

- **Fast & Compact:** Generates small, URL-safe IDs very quickly
- **Secure:** Uses a cryptographically strong random number generator to ensure uniqueness and prevent collisions
- **Customizable:** Allows you to specify the random number generator, the ID size and the alphabet

## 🚀 Installation

Integration using Version Catalog is highly recommended for aligned version usage.

=== "Version Catalog"

    First declare the library in your Version Catalog:

    ```toml
    [libraries]
    kommons-nanoid = { group = "dev.datlag.kommons", name = "nanoid", version.ref = "kommons" }
    ```
    
    Then add the dependency to your module:
    
    ```kotlin
    dependencies {
        implementation(libs.kommons.nanoid)
    }
    ```

=== "Gradle"

    Simply add the dependency like this:

    ```kotlin
    dependencies {
        implementation("dev.datlag.kommons:nanoid:<version>")
    }
    ```

## 🛠️ Usage

Creating a default URL-friendly unique identifier:

```kotlin
val id = NanoId.generate()
```

Customizing the generated output:

```kotlin
val generator = Random()
val alphabet = "0123456789"
val size = 20

val id = NanoId.generate(generator, alphabet, size)
```