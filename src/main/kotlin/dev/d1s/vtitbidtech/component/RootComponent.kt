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

import dev.d1s.vtitbidtech.di.Qualifier
import dev.d1s.vtitbidtech.util.deploy
import io.kvision.html.div
import io.kvision.panel.SimplePanel
import io.kvision.utils.perc
import io.kvision.utils.rem
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class RootComponent : Component.Root, KoinComponent {

    private val navbarComponent by inject<Component>(Qualifier.NavbarComponent)
    private val pageContentComponent by inject<Component>(Qualifier.PageContentComponent)
    private val footerComponent by inject<Component>(Qualifier.FooterComponent)

    override fun SimplePanel.render() {
        height = 100.perc

        deploy(navbarComponent)

        div(className = "container h-100 flex-column") {
            marginTop = 5.rem
            marginBottom = 5.rem

            deploy(pageContentComponent)
            deploy(footerComponent)
        }
    }
}