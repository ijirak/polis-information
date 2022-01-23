
plugins {
    kotlin("multiplatform")
    kotlin("native.cocoapods")
    id("com.android.library")
//    id("com.squareup.sqldelight")
}

kotlin {
    android()
    iosX64()
    iosArm64()
    iosSimulatorArm64()

    cocoapods {
        summary = "Some description for the Shared Module"
        homepage = "Link to the Shared Module homepage"
        version = "1.0"
        ios.deploymentTarget = "14.1"
        podfile = project.file("../iosApp/Podfile")
        framework {
            baseName = "sharedLogic"
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                api(libs.kotlinx.coroutines.core)
                api(libs.hyperdrive.multiplatformx.api)
                api(libs.bundles.ktor.common)
                api(libs.bundles.sqldelight.common)
                api(libs.stately.common)
                api(libs.koin.core)

            }
        }
        val commonTest by getting {