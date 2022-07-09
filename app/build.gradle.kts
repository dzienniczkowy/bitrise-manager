plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("org.jetbrains.kotlin.plugin.serialization")
    id("dagger.hilt.android.plugin")
}

val composeVersion = "1.0.5"
val ktorVersion = "2.0.3"
val kotlinVersion: String by rootProject.extra
val hiltVersion: String by rootProject.extra

android {
    compileSdk = 31

    defaultConfig {
        applicationId = "io.github.wulkanowy.manager"
        minSdk = 21
        targetSdk = 31
        versionCode = 1
        versionName = "0.1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        named("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        isCoreLibraryDesugaringEnabled = true

        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = "11"
    }

    kapt {
        correctErrorTypes = true
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = composeVersion
    }
}

dependencies {
    coreLibraryDesugaring("com.android.tools:desugar_jdk_libs:1.1.5")

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.5.2")

    implementation("androidx.core:core-ktx:1.7.0")
    implementation("androidx.core:core-splashscreen:1.0.0-alpha02")
    implementation("androidx.appcompat:appcompat:1.4.0")
    implementation("androidx.activity:activity-compose:1.5.0")
    implementation("androidx.navigation:navigation-compose:2.4.0-beta02")

    implementation("androidx.compose.ui:ui:$composeVersion")
    implementation("androidx.compose.ui:ui-tooling:$composeVersion")
    implementation("androidx.compose.material:material:$composeVersion")
    implementation("androidx.compose.material:material-icons-extended:1.0.5")
    implementation("com.google.accompanist:accompanist-swiperefresh:0.24.13-rc")


    implementation("io.coil-kt:coil-compose:2.1.0")

    implementation("com.google.android.material:material:1.6.1")

    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.4.0")

    implementation("com.google.dagger:hilt-android:$hiltVersion")
    implementation("androidx.hilt:hilt-navigation-compose:1.0.0")
    kapt("com.google.dagger:hilt-compiler:$hiltVersion")

    implementation("io.ktor:ktor-client-cio:$ktorVersion")
    implementation("io.ktor:ktor-client-serialization-jvm:$ktorVersion")
    implementation("io.ktor:ktor-client-logging:$ktorVersion")

    implementation("com.jakewharton.timber:timber:5.0.1")
    implementation("ch.qos.logback:logback-classic:1.2.11")
    implementation("com.google.accompanist:accompanist-systemuicontroller:0.23.1")

}
