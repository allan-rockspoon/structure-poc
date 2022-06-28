// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
	id("com.android.application") version "7.2.1" apply false
	id("com.android.library") version "7.2.1" apply false
	id("org.jetbrains.kotlin.android") version "1.7.0" apply false
	id("com.android.dynamic-feature") version "7.2.1" apply false
	id("com.android.test") version "7.2.1" apply false
	id("androidx.benchmark") version "1.1.0-beta04" apply false
	id("com.google.devtools.ksp") version "1.7.0-1.0.6" apply false
	id("com.google.protobuf") version "0.8.17" apply false

	//id("dagger.hilt.android.plugin") version "2.40.5" apply false
}

tasks.register<Delete>("clean") {
	delete(rootProject.buildDir)
}
	