plugins {
	id("com.android.application")
	id("org.jetbrains.kotlin.android")
	id("com.google.dagger.hilt.android")
	id("com.google.devtools.ksp")
}

android {
	namespace = "com.polygon.geolocation"
	compileSdk = 34

	defaultConfig {
		applicationId = "com.polygon.geolocation"
		minSdk = 24
		targetSdk = 34
		versionCode = 1
		versionName = "1.0"

		testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
	}

	buildTypes {
		release {
			isMinifyEnabled = false
			proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
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
		kotlinCompilerExtensionVersion = "1.5.4"
	}
}

dependencies {

	val composeBom = platform("androidx.compose:compose-bom:2023.10.01")
	implementation(composeBom)
	androidTestImplementation(composeBom)

	// Choose one of the following:
	// Material Design 3
	implementation("androidx.compose.material3:material3")
	// or skip Material Design and build directly on top of foundational components
	implementation("androidx.compose.foundation:foundation")
	// or only import the main APIs for the underlying toolkit systems,
	// such as input and measurement/layout
	implementation("androidx.compose.ui:ui")

	// Android Studio Preview support
	implementation("androidx.compose.ui:ui-tooling-preview")
	debugImplementation("androidx.compose.ui:ui-tooling")

	// UI Tests
	androidTestImplementation("androidx.compose.ui:ui-test-junit4")
	debugImplementation("androidx.compose.ui:ui-test-manifest")

	// Optional - Included automatically by material, only add when you need
	// the icons but not the material library (e.g. when using Material3 or a
	// custom design system based on Foundation)
	implementation("androidx.compose.material:material-icons-core")
	// Optional - Add full set of material icons
	implementation("androidx.compose.material:material-icons-extended")
	// Optional - Add window size utils
	implementation("androidx.compose.material3:material3-window-size-class")

	// Optional - Integration with activities
	implementation("androidx.activity:activity-compose:1.8.1")
	// Optional - Integration with ViewModels
	implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.2")
	// Optional - Integration with LiveData
	implementation("androidx.compose.runtime:runtime-livedata")
	// Optional - Integration with RxJava
	implementation("androidx.compose.runtime:runtime-rxjava2")
	// Optional - Add navigation
	implementation("androidx.navigation:navigation-compose:2.7.5")

	// implementation("com.google.android.catalog.framework:casa-ui:0.4.4")

	implementation("androidx.appcompat:appcompat:1.6.1")


	implementation("com.google.dagger:hilt-android:2.48.1")
	ksp("com.google.dagger:hilt-android-compiler:2.48.1")

	implementation("io.coil-kt:coil:2.3.0")

	implementation("com.google.accompanist:accompanist-permissions:0.32.0")

	implementation("com.google.android.gms:play-services-location:21.0.1")
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-play-services:1.7.3")
	implementation("androidx.work:work-runtime-ktx:2.8.1")
}