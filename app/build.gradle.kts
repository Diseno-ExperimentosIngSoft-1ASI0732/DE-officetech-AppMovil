plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    id ("kotlin-kapt")
}

android {
    namespace = "com.example.officetech_appmovil"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.officetech_appmovil"
        minSdk = 28
        targetSdk = 35
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.retrofit)
    implementation(libs.converter.gson)
    implementation(libs.glide)
    implementation(libs.androidx.sqlite)
    implementation(libs.core.ktx)
    testImplementation(libs.junit)
    testImplementation(libs.junit.jupiter)
    androidTestImplementation(libs.androidx.junit)
    testImplementation("io.mockk:mockk:1.13.10")
    androidTestImplementation(libs.androidx.espresso.core)

    implementation("com.squareup.picasso:picasso:2.71828")
//Room
    val room_version = "2.7.0"
    implementation("androidx.room:room-runtime:$room_version")
    annotationProcessor("androidx.room:room-compiler:$room_version")
    // To use Kotlin annotation processing tool (kapt)
    kapt("androidx.room:room-compiler:$room_version")
}