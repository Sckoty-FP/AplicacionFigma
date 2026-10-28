rootProject.name = "Tally"

pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
}

include(":composeApp")   // código compartido (pantallas)
include(":androidApp")   // app Android
include(":desktopApp")   // app de escritorio
