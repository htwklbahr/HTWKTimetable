plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.kotlinCocoapods)
}

kotlin {

    val exportedModules: List<Project> = listOf(
        project(":shared:utils:calendar"),
        project(":shared:functionalities:lectures"),
        project(":shared:functionalities:data"),
        project(":shared:functionalities:data:api"),
        project(":shared:functionalities:data:database"),
        project(":shared:functionalities:data:entities"),
    )

    iosX64()
    iosArm64()
    iosSimulatorArm64()

    cocoapods {
        summary = "Some description for the Shared Module"
        homepage = "Link to the Shared Module homepage"
        version = "1.0"
        ios.deploymentTarget = "16.0"
        podfile = project.file("../iosApp/Podfile")
        framework {
            baseName = "shared"
            isStatic = true
            exportedModules.forEach { module ->
                export(module)
            }
        }
    }

    sourceSets {
        iosMain.dependencies {
            exportedModules.forEach { module -> api(module) }
        }
    }
}