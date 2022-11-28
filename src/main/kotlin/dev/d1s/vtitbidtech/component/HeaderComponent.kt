package dev.d1s.vtitbidtech.component

import io.kvision.core.Container
import io.kvision.core.style
import io.kvision.html.button
import io.kvision.html.div
import io.kvision.html.image
import io.kvision.html.link
import io.kvision.utils.em

fun Container.header() {
    installHeader {
        headerItem("mr-3", increaseFont = false) {
            headerLink("/") {
                vtitbidTechLogo()
            }
        }

        headerItem {
            headerLink("/", "О проекте")
        }

        headerItem {
            headerLink("/", "Новости")
        }

        headerItem {
            headerLink("/", "Контакты")
        }

        headerItem(increaseFont = false, last = true, moveToEnd = true) {
            showOnDesktop()

            becomeMemberButton()
        }
    }
}

private fun Container.installHeader(block: Container.() -> Unit) {
    div(className = "Header color-bg-subtle color-shadow-medium", init = block)
}

private fun Container.headerItem(
    className: String = "",
    increaseFont: Boolean = true,
    last: Boolean = false,
    moveToEnd: Boolean = false,
    block: Container.() -> Unit
) {
    val builtClassName = buildString {
        append("Header-item ")

        if (className.isNotEmpty()) {
            append(className)
        }

        if (increaseFont) {
            append(" f4")
        }

        if (last) {
            append(" mr-0")
        }

        if (moveToEnd) {
            append(" ml-auto")
        }
    }

    div(className = builtClassName, init = block)
}

private fun Container.headerLink(
    url: String,
    label: String = "",
    className: String = "",
    block: Container.() -> Unit = {}
) {
    val builtClassName = buildString {
        append("Header-link color-fg-default ")

        if (className.isNotEmpty()) {
            append(className)
        }
    }

    link(label, url = url, className = builtClassName, init = block)
}

private fun Container.becomeMemberButton() {
    button("Стать участником", className = "btn-mktg")
}

private fun Container.vtitbidTechLogo() {
    image("/vtitbid.tech-logo-no-padding.png") {
        width = 4.em
    }
}

private fun Container.showOnDesktop() {
    addCssStyle(
        style {
            mediaQuery = "min-width: 540px"
        }
    )
}