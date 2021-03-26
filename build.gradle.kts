buildscript {
    val kotlinVersion by extra("1.4.30")
    val hiltVersion by extra("2.33-beta")

    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:7.0.0-alpha12")
        classpath(kotlin("gradle-plugin", version = kotlinVersion))
        classpath("org.jetbrains.kotlin:kotlin-serialization:$kotlinVersion")
        classpath("com.google.dagger:hilt-android-gradle-plugin:$hiltVersion")
    }
}

@Suppress("JcenterRepositoryObsolete")
allprojects {
    repositories {
        mavenCentral()
        google()
        jcenter {
            content {
                includeModule("org.jetbrains.kotlinx", "kotlinx-collections-immutable-jvm")
            }
        }
    }
}

tasks.register<Delete>("clean").configure {
    delete(rootProject.buildDir)
}
