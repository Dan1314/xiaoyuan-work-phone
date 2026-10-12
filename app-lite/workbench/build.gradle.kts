plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}
android {
    namespace = "com.xiaoyuan.workphone.workbench"
    compileSdk = 35
    defaultConfig {
        applicationId = "com.xiaoyuan.workphone.workbench"
        minSdk = 26
        targetSdk = 35
        versionCode = 1
        versionName = "0.1.0-demo"
        buildConfigField("String", "API_BASE_URL", "\"https://api.example.com\"")
    }
    buildFeatures { buildConfig = true; viewBinding = true }
    compileOptions { sourceCompatibility = JavaVersion.VERSION_17; targetCompatibility = JavaVersion.VERSION_17 }
    kotlinOptions { jvmTarget = "17" }
    // 本仓库不包含任何签名配置 / keystore，请使用本地 debug 调试。
}
dependencies {
    implementation(project(":common"))
    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("com.google.android.material:material:1.12.0")
    implementation("androidx.recyclerview:recyclerview:1.3.2")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.8.7")
}
