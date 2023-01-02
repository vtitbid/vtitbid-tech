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

package dev.d1s.vtitbidtech.di

import dev.d1s.vtitbidtech.component.*
import dev.d1s.vtitbidtech.component.renderer.ComponentRenderer
import dev.d1s.vtitbidtech.component.renderer.RootComponentRenderer
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

fun setupDi() {
    startKoin {
        modules(mainModule)
    }
}

private val mainModule = module {
    components()
    componentRenderer()
}

private fun Module.components() {
    singleOf<Component.Root>(::RootComponent)

    singleOf<Component>(::NavbarComponent) {
        qualifier = Qualifier.NavbarComponent
    }

    singleOf<Component>(::PageContentComponent) {
        qualifier = Qualifier.PageContentComponent
    }

    singleOf<Component>(::AboutPageComponent) {
        qualifier = Qualifier.AboutPageComponent
    }

    singleOf<Component>(::EnrollmentFormPageComponent) {
        qualifier = Qualifier.FormPageComponent
    }

    singleOf<Component>(::FooterComponent) {
        qualifier = Qualifier.FooterComponent
    }

    singleOf<Component>(::EasterEggComponent) {
        qualifier = Qualifier.EasterEggComponent
    }
}

private fun Module.componentRenderer() {
    singleOf<ComponentRenderer>(::RootComponentRenderer)
}