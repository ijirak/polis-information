
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
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val androidMain by getting {
            dependencies {
                    implementation(libs.sqldelight.driver.android)
                    implementation(libs.kotlinx.coroutines.android)
                    implementation(libs.ktor.client.okhttp)
                    implementation(libs.androidx.core)
            }
        }
        val androidTest by getting
        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)

            dependencies {
                implementation(libs.sqldelight.driver.ios)
                implementation(libs.ktor.client.ios)
            }
        }
        val iosX64Test by getting
        val iosArm64Test by getting
        val iosSimulatorArm64Test by getting
        val iosTest by creating {
            dependsOn(commonTest)
            iosX64Test.dependsOn(this)
            iosArm64Test.dependsOn(this)
            iosSimulatorArm64Test.dependsOn(this)
        }
    }
}

android {
    namespace = "com.turbosokol.tradingalchemy"
    compileSdk = 33
    defaultConfig {