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

import dev.d1s.vtitbidtech.config.Config
import dev.d1s.vtitbidtech.util.*
import dev.d1s.vtitbidtech.util.constant.Brand
import dev.d1s.vtitbidtech.util.constant.Path
import io.kvision.html.*
import io.kvision.panel.SimplePanel
import io.kvision.utils.rem
import org.koin.core.component.KoinComponent

class AboutPageComponent : Component, KoinComponent {

    override fun SimplePanel.render() {
        heading()
        adCampaignEndedAlert()
        aboutAlert()
        aboutList()
        ourWork()
        ourSocials()
        whyJoin()
        howToJoin()
        largeJoinButton()
    }

    private fun SimplePanel.heading() {
        displayHeading(level = 4) {
            +"Строим информационное будущее техникума. "

            highlightedSpan("Вместе.")
        }
    }

    private fun SimplePanel.aboutList() {
        displayHeading {
            +"${Brand.NAME_RUS} — это..."
        }

        ul {
            li {
                +"Насыщенная "

                highlightedSpan("командная")

                +" атмосфера."
            }

            li {
                +"Клуб, в котором студенты развивают свои навыки и получают "

                highlightedSpan("новый опыт")

                +"."
            }

            li {
                +"Вектор информационного "

                highlightedSpan("развития")

                +" ВТИТБиД."
            }

            li {
                +"Место, где "

                highlightedSpan("сами студенты")

                +" создают программный продукт для техникума."
            }
        }

        p {
            +"И не только: в клубе ${Brand.NAME_RUS} мы решаем "

            highlightedSpan("сложные и интересные задачи")

            +", применяя самые разные подходы."
        }
    }

    private fun SimplePanel.ourWork() {
        displayHeading {
            +"Что мы делаем?"
        }

        p {
            +("Говоря короче, пишем код. " +
                    "Мы создаем программный продукт для тысячи студентов, преподавателей, " +
                    "посредством которого, они ")

            highlightedSpan("\"на лету\" обмениваются информацией")

            +(". Мы верим, что эффективность обмена информацией должна соответствовать сегодняшнему веку. " +
                    "Наша деятельность не ограничивается совершенствованием инфообмена: мы ведем исследовательскую деятельность " +
                    "в IT-сфере, изучаем новые инструменты, оптимизируем существующие процессы.")
        }
    }

    private fun SimplePanel.ourSocials() {
        displayHeading {
            +"Наше медиа"
        }

        ul(className = "list-unstyled") {
            social("Telegram", Config.Social.TELEGRAM_CHANNEL_URL) {
                telegramIcon()
            }
        }
    }

    private fun Ul.social(name: String, url: String, icon: SimplePanel.() -> Unit) {
        li {
            link("", url) {
                icon()

                button("Мы в $name", style = ButtonStyle.LINK, className = "ps-0")
            }
        }
    }

    private fun SimplePanel.whyJoin() {
        displayHeading {
            +"Почему "

            highlightedSpan("стоит")

            +" вступить в наш клуб?"
        }

        p {
            +"В клубе можно получить "

            highlightedSpan("много нового опыта")

            +". Каждый участник команды вносит "

            highlightedSpan("свой вклад")

            +" в развитие ВТИТБиД. Каждый выполняет сложную, а поэтому, интересную работу."
        }
    }

    private fun SimplePanel.howToJoin() {
        displayHeading {
            +"Как вступить?"
        }

        p("Вступить очень легко. Достаточно нажать на кнопку ниже и отправить свою анкету.")

        p("Ограничения", className = "lead pb-2")

        p {
            +"В клуб приветствуются студенты, имеющие "

            highlightedSpan("базовый опыт в разработке ПО")

            +". Особенное внимание обращается студентам, "

            highlightedSpan("учащихся на техническую, информационную специальность")

            +"."
        }
    }

    private fun SimplePanel.largeJoinButton() {
        div(className = "mt-5 d-flex flex-column align-items-center") {
            link("Вступить", Path.APPLY, className = "btn btn-lg") {
                role = "button"

                width = 20.rem

                disableButtonIfNotAdCampaign()
            }

            if (Config.Phase.isAdCampaignEnded()) {
                p("В данный момент мы не набираем новых участников.", className = "text-secondary mt-3")
            }
        }
    }
}
