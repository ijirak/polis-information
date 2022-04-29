plugins {
    kotlin("multiplatform")
    kotlin("native.cocoapods")
    id("com.android.library")
    id("org.jetbrains.compose")
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
        framework {
            baseName = "sharedFront"
        }
    }
    
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(project(":sharedLogic"))
                api(libs.kotlinx.coroutines.core)
                api(libs.multiplatformSettings.core)

                implementation(libs.bundles.ktor.common)
                implementation(libs.bundles.sqldelight.common)

                implementation(libs.stately.common)
                implementation(libs.koin.core)

                implementation(compose.ui)
                implementation(compose.foundation)
                implementation(compose.material)
                implementation(compose.runtime)

                implementation(libs.hyperdrive.multiplatformx.api)
                implementation(libs.hyperdrive.multiplatformx.compose)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("