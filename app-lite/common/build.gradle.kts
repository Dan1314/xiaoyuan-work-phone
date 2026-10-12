plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}
android {
    namespace = "com.xiaoyuan.workphone.common"
    compileSdk = 35
    defaultConfig { minSdk = 26 }
    buildFeatures { aidl = true }
    compileOptions { sourceCompatibility = JavaVersion.VERSION_17; targetCompatibility = JavaVersion.VERSION_17 }
    kotlinOptions { jvmTarget = "17" }
}
dependencies {
    implementation("androidx.core:core-ktx:1.15.0")
    implementation("androidx.appcompat:appcompat:1.7.0")
    api("com.squareup.okhttp3:okhttp:4.12.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.9.0")
}
