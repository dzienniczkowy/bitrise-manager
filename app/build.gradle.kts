plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("org.jetbrains.kotlin.plugin.serialization")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = 30
    buildToolsVersion = "30.0.3"

    defaultConfig {
        applicationId = "io.github.wulkanowy.manager"
        minSdk = 21
        targetSdk = 30
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

        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    kapt {
        correctErrorTypes = true
    }

    hilt {
        enableExperimentalClasspathAggregation = true
    }

    buildFeatures {
        compose = true
    }
}

val composeVersion = "1.0.1"
val ktorVersion = "1.6.2"
val kotlinVersion: String by rootProject.extra
val hiltVersion: String by rootProject.extra

android {
    composeOptions {
        kotlinCompilerExtensionVersion = composeVersion
    }
}

dependencies {
    coreLibraryDesugaring("com.android.tools:desugar_jdk_libs:1.1.5")

    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlinVersion")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.5.1")

    implementation("androidx.core:core-ktx:1.6.0")
    implementation("androidx.appcompat:appcompat:1.3.1")
    implementation("androidx.activity:activity-compose:1.3.1")
    implementation("androidx.navigation:navigation-compose:2.4.0-alpha06")

    implementation("androidx.compose.ui:ui:$composeVersion")
    implementation("androidx.compose.ui:ui-tooling:$composeVersion")
    implementation("androidx.compose.material:material:$composeVersion")

    implementation("com.google.android.material:material:1.4.0")

    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.3.1")

    implementation("com.google.dagger:hilt-android:$hiltVersion")
    implementation ("androidx.hilt:hilt-navigation-compose:1.0.0-alpha03")
    kapt("com.google.dagger:hilt-compiler:$hiltVersion")

    implementation("io.ktor:ktor-client-cio:$ktorVersion")
    implementation("io.ktor:ktor-client-serialization-jvm:$ktorVersion")
}
