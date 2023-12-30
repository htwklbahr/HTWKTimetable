enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "HTWKTimetable"
include(":androidApp")
include(":shared")
include(":shared:utils:calendar")
include(":shared:functionalities:lectures")
include(":shared:functionalities:data")
include(":shared:functionalities:data:api")
include(":shared:functionalities:data:entities")
include(":shared:functionalities:data:database")
