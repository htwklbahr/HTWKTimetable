plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.kotlinCocoapods)
    alias(libs.plugins.androidLibrary)
    id("app.cash.sqldelight") version "2.0.1"

}

kotlin {
    val sqlDelightVersion = "2.0.1"
    val coroutinesVersion = "1.7.3"

    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }
    iosX64()
    iosArm64()
    iosSimulatorArm64()

    cocoapods {
        summary = "Some description for the Shared Module"
        homepage = "Link to the Shared Module homepage"
        version = "1.0"
        ios.deploymentTarget = "16.0"
        framework {
            baseName = "database"
            isStatic = true
        }
    }
    
    sourceSets {
        commonMain.dependencies {
            //put your multiplatform dependencies here
            implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion")
            implementation("app.cash.sqldelight:runtime:$sqlDelightVersion")

            //shared modules
            implementation(projects.shared.functionalities.data.entities)
            implementation(projects.shared.functionalities.data.api)
        }

        androidMain.dependencies {
            implementation("app.cash.sqldelight:android-driver:$sqlDelightVersion")
        }
        iosMain.dependencies {
            implementation("app.cash.sqldelight:native-driver:$sqlDelightVersion")
        }
    }
}

sqldelight {
    databases {
        create("LecturesDatabase") {
            packageName.set("com.lb.functionalities.data.database")
        }
    }
}

android {
    namespace = "com.lb.functionalities.data.database"
    compileSdk = 34
    defaultConfig {
        minSdk = 24
    }
}