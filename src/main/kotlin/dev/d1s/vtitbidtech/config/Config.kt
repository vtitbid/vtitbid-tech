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

package dev.d1s.vtitbidtech.config

object Config {

    object Git {

        const val ORIGIN_REPOSITORY_URL = "https://github.com/vtitbid/vtitbid-tech"
    }

    object Social {

        const val TELEGRAM_CHANNEL_URL = "https://t.me/vtitbid_tech"

        const val E_MAIL = "info@vtitbid.tech"
    }

    enum class Phase {
        AD_CAMPAIGN, EDUCATION, WORKING;

        companion object {

            val Current = AD_CAMPAIGN

            fun isAdCampaignEnded() = Current != AD_CAMPAIGN
        }
    }

    object EnrollmentFormIframe {

        const val SRC = "https://forms.yandex.com/cloud/639365d6e010dbc6931639f8/?iframe=1"

        const val NAME = "ya-form-639365d6e010dbc6931639f8"
    }
}