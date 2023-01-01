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
import io.kvision.core.Background
import io.kvision.html.TAG
import io.kvision.html.div
import io.kvision.html.tag
import io.kvision.panel.SimplePanel

fun SimplePanel.adCampaignEndedAlert() {
    if (Config.Phase.isAdCampaignEnded()) {
        alertBox("Извините, но ${Brand.NAME_RUS} больше не принимает новых участников.", AlertStyle.DANGER)
    }
}

fun SimplePanel.aboutAlert() {
    alertBox(
        "${Brand.NAME_RUS} создает программные продукты нового поколения, " +
                "совершенствующие информационную среду ВТИТБиД."
    )
}

private enum class AlertStyle {

    DARK, DANGER
}

private fun SimplePanel.alertBox(content: String, style: AlertStyle = AlertStyle.DARK) {
    div(className = "mb-4") {
        background = when (style) {
            AlertStyle.DARK -> {
                Background(Color.BrighterDark)
            }

            AlertStyle.DANGER -> {
                Background(Color.DarkRed)
            }
        }

        div(className = "alert text-center") {
            tag(TAG.BLOCKQUOTE, className = "blockquote") {
                +content
            }
        }
    }
}