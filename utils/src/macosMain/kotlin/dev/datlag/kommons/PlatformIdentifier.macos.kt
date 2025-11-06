package dev.datlag.kommons

internal actual val PlatformIdentifier.Companion.current: PlatformIdentifier
    get() = PlatformIdentifier.MacOS