package dev.datlag.kommons

import java.util.Locale

internal sealed interface OperatingSystem {

    val names: Array<String>

    val isMacOS: Boolean
        get() = this is MacOS

    val isLinux: Boolean
        get() = this is Linux

    val isWindows: Boolean
        get() = this is Windows

    fun matches(name: String): Boolean {
        return names.any {
            name.startsWith(it, true)
        } || this.names.contains(name.lowercase(Locale.ROOT))
    }

    data object MacOS : OperatingSystem {
        override val names = arrayOf("mac", "darwin", "osx")
    }

    data object Linux : OperatingSystem {
        override val names = arrayOf("linux")
    }

    data object Windows : OperatingSystem {
        override val names = arrayOf("win", "windows", "dos")
    }

    companion object {
        private const val PROPERTY_OS_NAME = "os.name"

        fun matching(name: String) : OperatingSystem? {
            return when {
                MacOS.matches(name) -> MacOS
                Linux.matches(name) -> Linux
                Windows.matches(name) -> Windows
                else -> null
            }
        }

        fun matching(): OperatingSystem? {
            val name = Kommons.systemProperty(PROPERTY_OS_NAME) ?: return null
            return matching(name)
        }
    }
}