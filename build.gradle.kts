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

import org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpackConfig

plugins {
    kotlin("js")
    kotlin("plugin.serialization")
    id("io.kvision")
}

val projectGroup: String by project
val projectVersion: String by project

group = projectGroup
version = projectVersion

repositories {
    mavenCentral()
}

val kotlinVersion: String by project
val kvisionVersion: String by project

dependencies {
    implementation(npm("@primer/css", "20.7.1"))
    implementation(npm("sass-loader", "13.2.0"))
    implementation(npm("sass", "1.56.1"))
    implementation("io.kvision:kvision:$kvisionVersion")
    implementation("io.kvision:kvision-state:$kvisionVersion")
}

val webDir = file("src/main/web")

kotlin {
    js {
        browser {
            val outputFile = "main.bundle.js"

            runTask {
                outputFileName = outputFile
                sourceMaps = false
                devServer = KotlinWebpackConfig.DevServer(
                    open = false,
                    port = 8080,
                    static = mutableListOf("$buildDir/processedResources/js/main")
                )
            }

            webpackTask {
                outputFileName = outputFile
            }

            testTask {
                useKarma {
                    useChromeHeadless()
                }
            }
        }

        binaries.executable()
    }

    sourceSets["main"].resources.srcDir(webDir)
}
