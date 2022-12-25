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

import dev.d1s.vtitbidtech.resource.ResourceLocation
import dev.d1s.vtitbidtech.util.constant.Brand
import dev.d1s.vtitbidtech.util.constant.Color
import dev.d1s.vtitbidtech.util.constant.Path
import dev.d1s.vtitbidtech.util.disableButtonIfNotAdCampaign
import dev.d1s.vtitbidtech.util.pathName
import io.kvision.core.Container
import io.kvision.core.Display
import io.kvision.core.style
import io.kvision.html.div
import io.kvision.html.image
import io.kvision.html.link
import io.kvision.html.nav
import io.kvision.panel.SimplePanel
import io.kvision.utils.em
import org.koin.core.component.KoinComponent

class NavbarComponent : Component, KoinComponent {

    override fun SimplePanel.render() {
        nav(className = "navbar navbar-expand-lg navbar-light bg-light fixed-top shadow") {
            div(className = "container") {
                logo()
                name()
                becomeMemberButton()
            }
        }
    }

    private fun Container.logo() {
        link("", className = "navbar-brand", url = "/") {
            image(ResourceLocation.LOGO) {
                width = 4.em
            }
        }
    }

    private fun Container.name() {
        div {
            if (pathName != Path.APPLY) {
                showOnDesktopOnly()
            }

            link(Brand.NAME_RUS, "/", className = "navbar-brand") {
                fontSize = 2.em
                color = Color.Green
            }
        }
    }

    private fun Container.becomeMemberButton() {
        if (pathName != Path.APPLY) {
            link("Стать участником", Path.APPLY, className = "btn btn-lg") {
                role = "button"

                disableButtonIfNotAdCampaign()
            }
        }
    }

    private fun SimplePanel.showOnDesktopOnly() {
        style {
            mediaQuery = "max-width: 700px"
            display = Display.NONE
        }
    }
}