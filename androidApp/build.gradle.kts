
plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    namespace = "com.turbosokol.tradingalchemy.android"
    compileSdk = 33
    defaultConfig {
        applicationId = "com.turbosokol.tradingalchemy.android"
        minSdk = 26
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.3.0"
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}

dependencies {
    implementation(project(":sharedLogic"))
    implementation(project(":sharedUI"))
    implementation("androidx.compose.ui:ui:1.2.1")