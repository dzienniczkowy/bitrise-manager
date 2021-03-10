buildscript {
    val kotlinVersion by extra("1.4.30")

    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:7.0.0-alpha09")
        classpath(kotlin("gradle-plugin", version = kotlinVersion))
        classpath("org.jetbrains.kotlin:kotlin-serialization:$kotlinVersion")
    }
}

allprojects {
    repositories {
        mavenCentral()
        google()
        jcenter()
    }
}

tasks.register<Delete>("clean").configure {
    delete(rootProject.buildDir)
}
