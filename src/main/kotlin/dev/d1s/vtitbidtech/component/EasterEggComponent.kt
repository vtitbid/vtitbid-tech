/*
 * Copyright 2022-2023 VTITBiD.TECH Research Group <info@vtitbid.tech>
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
import io.kvision.html.TAG
import io.kvision.html.div
import io.kvision.html.tag
import io.kvision.panel.SimplePanel
import org.koin.core.component.KoinComponent

class EasterEggComponent : Component, KoinComponent {

    override fun SimplePanel.render() {
        div(className = "d-flex justify-content-center mt-5") {
            tag(TAG.OBJECT) {
                setAttribute("width", "600")
                setAttribute("height", "500")

                setAttribute("data", ResourceLocation.EASTER_EGG_VIDEO)
            }
        }
    }
}