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

import dev.d1s.vtitbidtech.component.Component
import io.kvision.core.*
import io.kvision.core.Color
import io.kvision.html.*
import io.kvision.panel.SimplePanel

private const val YANDEX_FORM_IFRAME_SRC = "https://forms.yandex.com/cloud/639365d6e010dbc6931639f8/?iframe=1"
private const val YANDEX_FORM_IFRAME_NAME = "ya-form-639365d6e010dbc6931639f8"

fun SimplePanel.deploy(component: Component) {
    with(component) {
        render()
    }
}

fun SimplePanel.deployYandexFormIframe() {
    iframe(YANDEX_FORM_IFRAME_SRC, name = YANDEX_FORM_IFRAME_NAME) {
        setAttribute("frameborder", "0")

        iframeWidth = 650
    }
}

fun SimplePanel.displayHeading(level: Int = 6, addReturnButton: Boolean = false, block: SimplePanel.() -> Unit) {
    div(className = "container mt-5 mb-4 border-bottom") {
        div(className = "pb-3 d-flex align-content-center") {
            h1(className = "display-$level flex-fill") {
                add(SimplePanel().apply(block))
            }

            if (addReturnButton) {
                div(className = "flex-fill d-flex justify-content-end") {
                    link("", "/", className = "d-flex align-items-center") {
                        textDecoration = TextDecoration(line = TextDecorationLine.NONE)

                        button("Вернуться назад", style = ButtonStyle.OUTLINEDANGER)
                    }
                }
            }
        }
    }
}

fun SimplePanel.highlight() {
    val lightGreen = Color.hex(0xdbfee3)

    background = Background(lightGreen)
}