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

package dev.d1s.vtitbidtech

import dev.d1s.vtitbidtech.component.renderer.ComponentRenderer
import dev.d1s.vtitbidtech.di.setupDi
import io.kvision.*
import io.kvision.panel.root
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class VtitbidTechApplication : Application(), KoinComponent {

    private val componentRenderer by inject<ComponentRenderer>()

    override fun start() {
        root(ROOT_ELEMENT_ID) {
            componentRenderer.render(this)
        }
    }

    private companion object {

        private const val ROOT_ELEMENT_ID = "root"
    }
}

fun main() {
    setupDi()

    startApplication(
        ::VtitbidTechApplication,
        module.hot,
        CoreModule,
        BootstrapModule,
        BootstrapCssModule
    )
}
