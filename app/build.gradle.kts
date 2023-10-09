plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    // Hilt - DI
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.tc.mytest"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.tc.mytest"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
}

dependencies {

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")


    //Hilt ViewModel
    implementation("androidx.hilt:hilt-navigation-compose:1.0.0")

    //Truth library
    testImplementation("com.google.truth:truth:1.1.4")

    //Kotlin Coroutines Testing
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6.4")

    //RETROFIT IMPLEMENTATION TO HANDLE THE API
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.10.0")

    //GSON TO CONVERT
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")

    //Hilt -> Dependency Injection
    implementation("com.google.dagger:hilt-android:2.48")
    kapt("com.google.dagger:hilt-compiler:2.48")

    //Mockito
    testImplementation ("org.mockito:mockito-core:3.12.4")
    //Mockk
    testImplementation("io.mockk:mockk:1.12.0")
}