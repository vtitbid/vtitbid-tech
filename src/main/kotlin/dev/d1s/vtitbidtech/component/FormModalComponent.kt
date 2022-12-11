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

package dev.d1s.vtitbidtech.component

import dev.d1s.vtitbidtech.util.deployYandexFormIframe
import io.kvision.html.*
import io.kvision.panel.SimplePanel
import org.koin.core.component.KoinComponent

// this component is not used in production due to
// https://stackoverflow.com/questions/74747140/bootstrap-error-this-config-is-undefined
class FormModalComponent : Component, KoinComponent {

    override fun SimplePanel.render() {
        div(className = "modal fade") {
            id = MODAL_ID
            tabindex = -1

            setAttribute("aria-labelledby", ARIA_LABELLED_BY)
            setAttribute("aria-hidden", "true")

            div(className = "modal-dialog") {
                div(className = "modal-content") {
                    div(className = "modal-header") {
                        h5("Анкета участника", className = "modal-title") {
                            id = ARIA_LABELLED_BY
                        }

                        button("Закрыть", type = ButtonType.BUTTON, style = ButtonStyle.SECONDARY) {
                            setAttribute("data-bs-dismiss", "modal")
                        }
                    }

                    div(className = "modal-body") {
                        deployYandexFormIframe()
                    }
                }
            }
        }
    }

    companion object {

        const val MODAL_ID = "formModal"

        private const val ARIA_LABELLED_BY = "${MODAL_ID}_label"
    }
}

fun Button.connectToFormModal() {
    setAttribute("data-bs-toggle", "modal")
    setAttribute("data-bs-target", FormModalComponent.MODAL_ID)
}