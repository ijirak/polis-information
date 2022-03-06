package com.turbosokol.tradingalchemy

import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.module

/***
 *If this code runs it created by Evgenii Sokol.
 *If it doesn’t work, I don’t know who created it.
 ***/

fun initKoin(otherModules: List<Module>): KoinApplication {
    val koinApplication = startKoin{
        modules(
            otherModules
//            platformModules
        )
    }
    return koinApplication
}

private