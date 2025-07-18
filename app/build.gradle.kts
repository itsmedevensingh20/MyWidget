plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android) // <- this handles `kotlin("android")`
//    kotlin("parcelize")                           // <- this adds Parcelize support
    id("kotlin-kapt")                             // <- annotation processing
    alias(libs.plugins.android.dagger.hilt)       // <- Hilt
}

android {
    namespace = "com.alpha.mywidgets"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.alpha.mywidgets"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(project(":domain"))
    implementation(project(":data"))

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)

    implementation(libs.androidx.splash.screen)

    implementation(libs.androidx.navigation)

    implementation(libs.androidx.viewmodel)
    implementation(libs.androidx.viewmodel.compose)

//    implementation(libs.retrofit)
//    implementation(libs.retrofit.gson.converter)
//    implementation(libs.retrofit.interceptor)
//    implementation(libs.retrofit.okhttp)

    implementation(libs.coroutines.core)
    implementation(libs.coroutines.android)

    implementation(libs.hilt.navigation.compose)
    implementation(libs.dagger.hilt)
//
    kapt(libs.dagger.hilt.compiler)

    // glide
//    implementation ("com.github.bumptech.glide:glide:4.11.0")
//    kapt ("com.github.bumptech.glide:compiler:4.11.0")

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}