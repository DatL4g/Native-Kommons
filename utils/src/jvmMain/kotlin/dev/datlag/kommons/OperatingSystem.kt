package dev.datlag.kommons

import java.awt.Desktop
import java.net.URI
import java.util.Locale

internal sealed interface OperatingSystem {

    val names: Array<String>
    val openArguments: Array<Array<String>>

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

    fun openUri(uri: URI): Boolean {
        fun openByCommands(): Boolean {
            openArguments.forEach { open ->
                Kommons.suspendCatching {
                    val command = arrayOfNulls<String>(open.size)
                    for (i in open.indices) {
                        if (open[i] == "$1") {
                            command[i] = uri.toString()
                        } else {
                            command[i] = open[i]
                        }
                    }

                    if (Runtime.getRuntime().exec(command).waitFor() == 0) {
                        return true
                    }
                }
            }
            return false
        }

        return browseUri(uri) || openByCommands()
    }

    data object MacOS : OperatingSystem {
        override val names = arrayOf("mac", "darwin", "osx")
        override val openArguments: Array<Array<String>> = arrayOf(
            arrayOf("open", "$1")
        )
    }

    data object Linux : OperatingSystem {
        override val names = arrayOf("linux")
        override val openArguments: Array<Array<String>> = arrayOf(
            arrayOf("xdg-open", "$1"),
            arrayOf("gio", "open", "$1"),
            arrayOf("gvfs-open", "$1"),
            arrayOf("gnome-open", "$1"),
            arrayOf("mate-open", "$1"),
            arrayOf("exo-open", "$1"),
            arrayOf("enlightenment_open", "$1"),
            arrayOf(
                "gdbus", "call", "--session", "--dest", "org.freedesktop.portal.Desktop",
                "--object-path", "/org/freedesktop/portal/desktop",
                "--method", "org.freedesktop.portal.OpenURI.OpenURI",
                "", "$1", "{}"
            )
        )
    }

    data object Windows : OperatingSystem {
        override val names = arrayOf("win", "windows", "dos")
        override val openArguments: Array<Array<String>> = arrayOf(
            arrayOf("rundll32", "url.dll,FileProtocolHandler", "$1")
        )
    }

    companion object {
        private const val PROPERTY_OS_NAME = "os.name"

        internal fun browseUri(uri: URI): Boolean {
            return Kommons.suspendCatching {
                if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                    Desktop.getDesktop().browse(uri)
                    true
                } else {
                    false
                }
            }.getOrNull() ?: false
        }

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