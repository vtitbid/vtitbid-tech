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

package dev.d1s.vtitbidtech.util.constant

import dev.d1s.vtitbidtech.config.Config

object Brand {

    const val NAME_RUS = "ВТИТБиД.ТЕХ"

    const val COPYRIGHT = "© Copyright 2022 \"${NAME_RUS}\" <${Config.Social.E_MAIL}>, " +
            "Apache License, Version 2.0"
}