plugins { id("com.android.application") }
android {
 namespace = "com.bookmyturf.app"
 compileSdk = 36
 defaultConfig {
  applicationId = "com.bookmyturf.app"
  minSdk = 26
  targetSdk = 36
  versionCode = 15
  versionName = "1.1.0-java-demo"
  testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
 }
 buildTypes {
  debug { applicationIdSuffix = ".demo"; versionNameSuffix = "-demo"; buildConfigField("boolean", "DEMO_MODE", "true") }
  release { isMinifyEnabled = false; buildConfigField("boolean", "DEMO_MODE", "false") }
 }
 buildFeatures { buildConfig = true }
 compileOptions { sourceCompatibility = JavaVersion.VERSION_17; targetCompatibility = JavaVersion.VERSION_17 }
}
dependencies {
 implementation("androidx.appcompat:appcompat:1.7.0")
 implementation("com.google.android.material:material:1.12.0")
 implementation("androidx.activity:activity:1.10.1")
 implementation("androidx.lifecycle:lifecycle-viewmodel:2.8.7")
 implementation("androidx.lifecycle:lifecycle-livedata:2.8.7")
 testImplementation("junit:junit:4.13.2")
}
