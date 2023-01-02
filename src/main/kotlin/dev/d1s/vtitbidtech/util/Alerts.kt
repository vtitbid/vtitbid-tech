/*
 * Copyright 2022 VTITBiD.TECH Research Group <info@vtitbid.tech>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package dev.d1s.vtitbidtech.util

import dev.d1s.vtitbidtech.config.Config
import dev.d1s.vtitbidtech.util.constant.Brand
import dev.d1s.vtitbidtech.util.constant.Color
import dev.d1s.vtitbidtech.util.constant.Path
import io.kvision.core.Background
import io.kvision.core.Outline
import io.kvision.core.onClick
import io.kvision.html.TAG
import io.kvision.html.div
import io.kvision.html.tag
import io.kvision.panel.SimplePanel
import io.kvision.utils.rem
import kotlinx.browser.document

private enum class AlertStyle {

    DARK, DANGER
}

fun SimplePanel.adCampaignEndedAlert() {
    if (Config.Phase.isAdCampaignEnded()) {
        alertBox("Извините, но ${Brand.NAME_RUS} больше не принимает новых участников.", AlertStyle.DANGER, addGreenOutline = false)
    }
}

fun SimplePanel.aboutAlert() {
    alertBox(
        "${Brand.NAME_RUS} создает программные продукты нового поколения, " +
                "совершенствующие информационную среду ВТИТБиД."
    )
}

private fun SimplePanel.alertBox(
    content: String,
    style: AlertStyle = AlertStyle.DARK,
    addGreenOutline: Boolean = true
) {
    div(className = "mb-4") {
        div(className = "alert text-center") {
            setBackground(style)

            tag(TAG.BLOCKQUOTE, className = "blockquote") {
                +content
            }

            if (addGreenOutline) {
                addGreenOutline()
            }

            addEasterEggHandler()
        }
    }
}

private fun SimplePanel.addGreenOutline() {
    outline = Outline(color = Color.Green, width = 3.rem)
}

private fun SimplePanel.setBackground(style: AlertStyle) {
    background = when (style) {
        AlertStyle.DARK -> {
            Background(Color.BrighterDark)
        }

        AlertStyle.DANGER -> {
            Background(Color.DarkRed)
        }
    }
}

private fun SimplePanel.addEasterEggHandler() {
    onClick {
        document.location?.href = Path.EASTER_EGG
    }
}