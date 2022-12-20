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

import dev.d1s.vtitbidtech.util.constant.Brand
import dev.d1s.vtitbidtech.util.constant.Path
import dev.d1s.vtitbidtech.util.displayHeading
import dev.d1s.vtitbidtech.util.highlight
import dev.d1s.vtitbidtech.util.telegramIcon
import io.kvision.html.*
import io.kvision.panel.SimplePanel
import io.kvision.utils.rem
import org.koin.core.component.KoinComponent

class AboutPageComponent : Component, KoinComponent {

    override fun SimplePanel.render() {
        heading()
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

            span("Вместе.") {
                highlight()
            }
        }
    }

    private fun SimplePanel.aboutAlert() {
        div(className = "mb-5") {
            div(className = "alert alert-success text-center") {
                tag(TAG.BLOCKQUOTE, className = "blockquote") {
                    +("${Brand.NAME_RUS} создает программные продукты нового поколения, " +
                            "совершенствующие информационную среду ВТИТБиД.")
                }
            }
        }
    }

    private fun SimplePanel.aboutList() {
        displayHeading {
            +"${Brand.NAME_RUS} — это..."
        }

        ul {
            li {
                +"Насыщенная "

                span("командная") {
                    highlight()
                }

                +" атмосфера."
            }

            li {
                +"Клуб, в котором студенты развивают свои навыки и получают "

                span("новый опыт") {
                    highlight()
                }

                +"."
            }

            li {
                +"Вектор информационного "

                span("развития") {
                    highlight()
                }

                +" ВТИТБиД."
            }

            li {
                +"Место, где "

                span("сами студенты") {
                    highlight()
                }

                +" создают программный продукт для техникума."
            }
        }

        p {
            +"И не только: в клубе ${Brand.NAME_RUS} мы решаем "

            span("сложные и интересные задачи") {
                highlight()
            }

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

            span("\"на лету\" обмениваются информацией") {
                highlight()
            }

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
            li {
                telegramIcon()
                link("", Brand.TELEGRAM_CHANNEL_URL) {
                    button("Мы в Telegram", style = ButtonStyle.LINK, className = "ps-0")
                }
            }
        }
    }

    private fun SimplePanel.whyJoin() {
        displayHeading {
            +"Почему "

            span("стоит") {
                highlight()
            }

            +" вступить в наш клуб?"
        }

        p {
            +"В клубе можно получить "

            span("много нового опыта") {
                highlight()
            }

            +". Каждый участник команды вносит "

            span("свой вклад") {
                highlight()
            }

            +" в развитие ВТИТБиД. Каждый выполняет сложную, а поэтому, интересную работу."
        }
    }

    private fun SimplePanel.howToJoin() {
        displayHeading {
            +"Как вступить?"
        }

        p("Вступить очень легко. Достаточно нажать на кнопку нижу и отправить свою анкету.")

        p("Ограничения", className = "lead pb-2 border-bottom")

        p {
            +"В клуб приветствуются студенты, имеющие "

            span("базовый опыт в разработке ПО") {
                highlight()
            }

            +". Особенное внимание обращается студентам, "

            span("учащихся на техническую, информационную специальность") {
                highlight()
            }

            +"."
        }
    }

    private fun SimplePanel.largeJoinButton() {
        div(className = "mt-5 d-flex justify-content-center align-content-center") {
            link("", Path.APPLY) {
                button("Вступить", style = ButtonStyle.OUTLINESUCCESS, className = "btn-lg text-center") {
                    width = 20.rem
                    height = 5.rem
                }
            }
        }
    }
}