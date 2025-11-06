package dev.datlag.kommons

internal enum class PlatformIdentifier {
    Android,
    AndroidNative,

    JVM,

    JS,
    WASM_JS,

    Linux,
    MingW,

    IOS,
    TVOS,
    WatchOS,
    MacOS,

    WASM_WASI;

    companion object
}

internal expect val PlatformIdentifier.Companion.current: PlatformIdentifier