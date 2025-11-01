---
tags:
  - Android
  - JVM
  - Apple
  - Linux
  - Web
  - Windows
---

# 🌍 Locale

A simple, serializable and modern Kotlin data class for handling locales.  
This library provides a type-safe alternative to `java.util.Locale`, designed for Kotlin Multiplatform and `kotlinx.serialization` projects.

## 🎯 Supported Targets

The following targets are supported:

| Platform           | Targets                                       |
|:-------------------|:----------------------------------------------|
| **JVM & Android**  | `jvm`, `android`                              |
| **Apple**          | `ios`, `macos`, `tvos`, `watchos`             |
| **Web**            | `js`, `wasmJs`                                |
| **Native & Other** | `androidNative`, `linux`, `mingw`, `wasmWasi` |

## ✨ Features

- **Serializable:** Annotated with `@Serializable`, ready for `kotlinx.serialization` (JSON, Protobuf, etc.)
- **Rich Data Models:** Provides type-safe `Country` and `Continent` classes packed with useful data like *ISO codes* (Alpha-2, Alpha-3, Numeric), *telephone codes*, *domains*, continent codes, and even *emoji flags*.
- **Flexible Parsing:** Can parse locales from common language tag strings (e.g. `en-US` or `fr_CA`) with customizable delimiters.
- **Java Interop:** Seamless integration with `java.util.Locale`
- **Apple Interop:** Seamless integration with `Foundation.NSLocale`

## 🚀 Installation

Integration using Version Catalog is highly recommended for aligned version usage.

```toml
[libraries]
kommons-locale = { group = "dev.datlag.kommons", name = "locale", version.ref = "locale" }
```

Then add the dependency to your module:

```kotlin
dependencies {
    implementation(libs.kommons.locale)
}
```

## 🛠️ Usage

### Creating a Locale

You can create a `Locale` instance in several ways:

```kotlin
// From language and country strings
val byStrings = Locale("en", "US")

// By parsing a BCP 47 language tag (handles mixed delimiters)
val byTag = Locale.forLanguageTag("sr_Latn-RS")

// Get the system's default locale
val systemDefault = Locale()

// Using the full constructor for scripts and variants
val fullLocale = Locale(
    language = "zh",
    country = "CN",
    script = "Hans",
    variant = "PINYIN"
)
```

### Working with Countries

The library includes a rich `Country` model. You can look up countries using their standard codes.

```kotlin
// Look up by Alpha-2, Alpha-3
val byString = Country.forCodeOrNull("DE")

// Look up by ISO 3166-1 numeric code
val byNumber = Country.forCodeOrNull(8) // Albania
```

### Getting Properties

Use the getter methods to access the immutable properties. The `Country` object, in particular, is rich with data.

```kotlin
// Locale properties
val locale = Locale.forLanguageTag("fr-CA")

println(locale.getLanguage()) // "fr"
println(locale.getCountry())   // Country object for Canada

// Accessing the rich Country object
val country = locale.getCountry()
if (country != null) {
    println(country.emoji)        // "🇨🇦"
    println(country.codeAlpha3)   // e.g., Code.Alpha3("CAN")
    println(country.codeNumeric)  // e.g., Code.Numeric("124")
    println(country.telephoneCodes) // e.g., [Code.Telephone("+1")]
    
    // Access nested Continent data
    val continent = country.continent
    println(continent.geoName)    // e.g., Code.GeoName("NA")
}
```

### Converting to a Language Tag

The `toString()` method is implemented to return a BCP 47 compliant language tag.

```kotlin
val locale = Locale("zh", "CN", script = "Hans")
println(locale.toString()) 
// Output: "zh-Hans-CN"
```

### Serialization (with kotlinx.serialization)

Thanks to the `@Serializable` annotation, serialization and deserialization work out of the box.

```kotlin
val locale = Locale("en", "US", variant = "POSIX")

// Serialize
val jsonString = Json.encodeToString(locale)
println(jsonString)
// Output: {"language":"en","country":{"codeAlpha2":...},"script":null,"variant":"POSIX"}

// Deserialize
val decodedLocale = Json.decodeFromString<Locale>(jsonString)
```