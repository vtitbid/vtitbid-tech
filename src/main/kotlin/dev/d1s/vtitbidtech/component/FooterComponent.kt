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

import dev.d1s.vtitbidtech.Version
import dev.d1s.vtitbidtech.config.Config
import dev.d1s.vtitbidtech.util.constant.Brand
import dev.d1s.vtitbidtech.util.githubIcon
import io.kvision.html.div
import io.kvision.html.link
import io.kvision.html.p
import io.kvision.panel.SimplePanel
import org.koin.core.component.KoinComponent

class FooterComponent : Component, KoinComponent {

    override fun SimplePanel.render() {
        div(className = "container mt-5 text-center text-secondary") {
            p(Brand.COPYRIGHT)
            p("v${Version.VERSION}")
            link("", Config.Git.ORIGIN_REPOSITORY_URL) {
                githubIcon()
                +"Исходный код на GitHub"
            }
        }
    }
}