plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}
android {
    namespace = "com.xiaoyuan.workphone.system"
    compileSdk = 35
    defaultConfig {
        applicationId = "com.xiaoyuan.workphone.system"
        minSdk = 26
        targetSdk = 35
        versionCode = 1
        versionName = "0.1.0-demo"
        buildConfigField("String", "API_BASE_URL", "\"https://api.example.com\"")
    }
    buildFeatures { buildConfig = true; aidl = true }
    compileOptions { sourceCompatibility = JavaVersion.VERSION_17; targetCompatibility = JavaVersion.VERSION_17 }
    kotlinOptions { jvmTarget = "17" }
}
dependencies {
    implementation(project(":common"))
    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("androidx.core:core-ktx:1.15.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.9.0")
}
