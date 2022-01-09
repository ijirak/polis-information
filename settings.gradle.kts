
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