plugins {
    kotlin("multiplatform")
    id("com.android.kotlin.multiplatform.library")
    kotlin("plugin.compose")
    id("org.jetbrains.compose")
}

kotlin {
    android {
        namespace = "com.eliasb.tally.shared"
        compileSdk = 37
        minSdk = 26
        androidResources { enable = true }
    }
    jvm("desktop")

    sourceSets {
        commonMain.dependencies {
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material3)
            implementation(compose.ui)
            implementation(compose.components.resources)
        }
    }
}

compose.resources {
    packageOfResClass = "com.eliasb.tally.recursos"
}
