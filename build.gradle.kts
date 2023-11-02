import org.jetbrains.kotlin.gradle.tasks.KotlinCompile


plugins {
    kotlin("jvm") version "1.8.0"
}

allprojects {
    apply(plugin = "org.jetbrains.kotlin.jvm")

	repositories {
		mavenCentral()
		mavenLocal()
		maven("https://raw.githubusercontent.com/Zelaux/MindustryRepo/master/repository")
		maven("https://jitpack.io")
	}

	dependencies {
		compileOnly("com.github.Anuken.Arc", "arc-core", "v146")
		compileOnly("com.github.Anuken", "Mindustry", "v146")
		implementation("com.github.mnemotechnician", "mkui", "v1.3.2")
	}

	tasks.withType<JavaCompile> {
		sourceCompatibility = "1.8"
		targetCompatibility = "1.8"
	}

	tasks.withType<KotlinCompile> {
		kotlinOptions {
			// target java version - 8. do not increase unless you really need to
			// this will not change a lot but will break mobile compatibility.
			jvmTarget = "1.8"
			// kotlin compiler argument
			freeCompilerArgs += arrayOf(
				// use the experimental kotlin compiler - x2 speed
				"-Xuse-k2",
				// enable context receivers
				// note: context receivers seem to be kinda broken in the k2 compiler.
				"-Xcontext-receivers"
			)
		}
	}
}
