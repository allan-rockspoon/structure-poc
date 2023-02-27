plugins {
	id("com.android.dynamic-feature")
	id("org.jetbrains.kotlin.android")
}

android {

	compileSdk = 32

	defaultConfig {
		minSdk = 23

		testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
//		testInstrumentationRunnerArguments["clearPackageData"] = "true"

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

	buildFeatures {
		viewBinding = true
	}

	testOptions {
		animationsDisabled = true
//		execution = "ANDROIDX_TEST_ORCHESTRATOR"
	}
}

dependencies {
	implementation(project(":app:poc"))
	implementation(project(":core:common"))
	implementation(project(":core:data"))
	implementation(project(":core:domain"))
	implementation(project(":core:ui"))

	androidTestImplementation(project(":app:poc"))


	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.2")
	testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6.2")

	// Needs both otherwise the test will miss the style/FragmentScenarioEmptyFragmentActivityTheme
	debugImplementation("androidx.fragment:fragment-testing:1.5.2")

	testImplementation("junit:junit:4.13.2")

//	androidTestImplementation("androidx.test:runner:1.1.0")
	androidTestImplementation("androidx.test:core-ktx:1.4.0")
	androidTestImplementation("androidx.test.ext:junit:1.1.3")
	androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
	androidTestImplementation("androidx.annotation:annotation:1.1.0")

//	androidTestUtil("androidx.test:orchestrator:1.1.0")

}