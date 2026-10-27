plugins {
    id("com.android.application")
    id("com.android.legacy-kapt")
}

android {
    namespace = "com.sharmadhiraj.photoalbummvvm"
    compileSdk = 37

    defaultConfig {
        applicationId = "com.sharmadhiraj.photoalbummvvm"
        minSdk = 24
        targetSdk = 37
        versionCode = 2
        versionName = "2.0"
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    buildFeatures {
        dataBinding = true
    }
}

dependencies {
    implementation("androidx.appcompat:appcompat:1.8.0")
    implementation("com.google.android.material:material:1.14.0")
    implementation("androidx.recyclerview:recyclerview:1.4.0")
    implementation("androidx.swiperefreshlayout:swiperefreshlayout:1.2.0")
    implementation("androidx.activity:activity-ktx:1.13.0")
    implementation("androidx.lifecycle:lifecycle-viewmodel:2.11.0")
    implementation("androidx.lifecycle:lifecycle-livedata:2.11.0")
}
