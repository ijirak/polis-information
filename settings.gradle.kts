
pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }

    plugins {
        val kotlinVersion = `version-catalog`.version("kotlin-version").toString()
        kotlin("multiplatform") version kotlinVersion
        kotlin("android") version kotlinVersion
        kotlin("plugin.serialization") version kotlinVersion
        kotlin("native.cocoapods") version kotlinVersion
        id("com.squareup.sqldelight") version "1.5.3"
        id("org.jetbrains.compose") version "1.2.0"
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }

    versionCatalogs {
        create("libs") {
            version("kotlin-version", "1.7.10")
            version("ktor-version", "2.1.3")
            version("coroutines-version", "1.6.4")
            version("sqldelight-version", "1.5.3")
            version("compose-version", "1.3.0")
            version("compose-activity", "1.6.1")
            version("compose-navigation", "2.5.3")
            version("koin-version", "3.2.0")
            version("hyperdrive-version", "0.1.139")
            version("androix-version", "1.9.0")
            version("multiplatform-settings-version", "0.9")
            version("accompanist-coil", "0.15.0")
            version("accompanist-navigation-animation", "0.27.0")
            version("stately-version", "1.2.2")
            version("imageloader-version", "1.2.2.1")

            //CORE
            library("androidx-core","androidx.core", "core-ktx").versionRef("androix-version")
            library("multiplatformSettings-core","com.russhwolf", "multiplatform-settings").versionRef("multiplatform-settings-version")
            library("multiplatformSettings-test","com.russhwolf", "multiplatform-settings-test").versionRef("multiplatform-settings-version")
            library("stately-common", "co.touchlab", "stately-common").versionRef("stately-version")

            //UI
            library("androidx-compose-ui-core","androidx.compose.ui", "ui").versionRef("compose-version")
            library("androidx-compose-ui-tooling","androidx.compose.ui", "ui-tooling").versionRef("compose-version")
            library("androidx-compose-foundation","androidx.compose.foundation", "foundation").versionRef("compose-version")
            library("androidx-compose-material","androidx.compose.material", "material").versionRef("compose-version")
            library("androidx-compose-activity","androidx.activity", "activity-compose").versionRef("compose-activity")
            library("androidx-compose-navigation","androidx.navigation", "navigation-compose").versionRef("compose-navigation")
            library("accompanist-coil","com.google.accompanist", "accompanist-coil").versionRef("accompanist-coil")
            library("accompanist-navigationAnimation","com.google.accompanist", "accompanist-navigation-animation").versionRef("accompanist-navigation-animation")
            library("imageLoader","io.github.qdsfdhvh", "image-loader").versionRef("imageloader-version")

            //NETWORK
            library("ktor-client-core","io.ktor", "ktor-client-core").versionRef("ktor-version")
            library("ktor-client-json","io.ktor", "ktor-client-json").versionRef("ktor-version")
            library("ktor-client-logging","io.ktor", "ktor-client-logging").versionRef("ktor-version")
            library("ktor-client-serialization","io.ktor", "ktor-client-serialization").versionRef("ktor-version")
            library("ktor-client-okhttp","io.ktor", "ktor-client-okhttp").versionRef("ktor-version")
            library("ktor-client-ios","io.ktor", "ktor-client-ios").versionRef("ktor-version")

            //MULTITHREADING
            library("kotlinx-coroutines-core","org.jetbrains.kotlinx", "kotlinx-coroutines-core").versionRef("coroutines-version")
            library("kotlinx-coroutines-android","org.jetbrains.kotlinx", "kotlinx-coroutines-android").version("coroutines-version")

            //DATABASE
            library("sqldelight-runtime","com.squareup.sqldelight", "runtime").versionRef("sqldelight-version")
            library("sqldelight-coroutines","com.squareup.sqldelight", "coroutines-extensions").versionRef("sqldelight-version")
            library("sqldelight-driver-ios","com.squareup.sqldelight", "native-driver").versionRef("sqldelight-version")
            library("sqldelight-driver-android","com.squareup.sqldelight", "android-driver").versionRef("sqldelight-version")

            //DI
            library("koin-core","io.insert-koin", "koin-core").versionRef("koin-version")
            library("koin-android","io.insert-koin", "koin-android").versionRef("koin-version")
            library("koin-test","io.insert-koin", "koin-test").versionRef("koin-version")

            //VIEWMODEL MULTIPLATFORM
            library("hyperdrive-multiplatformx-api","org.brightify.hyperdrive", "multiplatformx-api").versionRef("hyperdrive-version")
            library("hyperdrive-multiplatformx-compose","org.brightify.hyperdrive", "multiplatformx-compose").versionRef("hyperdrive-version")

            bundle("ktor-common",
                listOf(
                    "ktor-client-core",
                    "ktor-client-json",
                    "ktor-client-logging",
                    "ktor-client-serialization",
            ))

            bundle("sqldelight-common",
                listOf(
                    "sqldelight-runtime",
                    "sqldelight-coroutines"
            ))
        }
    }
}

rootProject.name = "TradingAlchemy"
include(":androidApp")
include(":sharedLogic")
include(":shredUI")
include(":iosApp")
include(":sharedUI")