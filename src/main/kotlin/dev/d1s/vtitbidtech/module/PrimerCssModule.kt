package dev.d1s.vtitbidtech.module

import io.kvision.ModuleInitializer

import io.kvision.require

object PrimerCssModule : ModuleInitializer {

    override fun initialize() {
        require("@primer/css/index.scss")
    }
}