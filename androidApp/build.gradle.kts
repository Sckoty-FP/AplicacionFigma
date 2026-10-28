plugins {
    id("com.android.application")
    kotlin("plugin.compose")
}

android {
    namespace = "com.eliasb.tally"
    compileSdk = 37

    defaultConfig {
        applicationId = "com.eliasb.tally"
        minSdk = 26
        targetSdk = 37
        versionCode = 1
        versionName = "1.0"
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    buildFeatures { compose = true }
}

dependencies {
    implementation(project(":composeApp"))
    implementation("androidx.activity:activity-compose:1.11.0")
}
