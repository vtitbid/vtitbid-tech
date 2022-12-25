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

import io.kvision.core.Background
import io.kvision.core.Color
import io.kvision.html.span
import io.kvision.panel.SimplePanel

fun SimplePanel.highlightedSpan(content: String) {
    span(content) {
        highlight()
    }
}

private fun SimplePanel.highlight() {
    val lightGreen = Color.hex(0xdbfee3)

    background = Background(lightGreen)
}