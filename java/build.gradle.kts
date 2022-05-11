/*
 * This file was generated by the Gradle 'init' task.
 *
 * This generated file contains a sample Kotlin library project to get you started.
 * For more details take a look at the 'Building Java & JVM projects' chapter in the Gradle
 * User Manual available at https://docs.gradle.org/6.8.3/userguide/building_java_projects.html
 */

import org.gradle.api.tasks.testing.logging.*

plugins {
    // Apply the org.jetbrains.kotlin.jvm Plugin to add support for Kotlin.
    kotlin("jvm") version "1.5.21"

    // Apply the java-library plugin for API and implementation separation.
    `java-library`
    `maven-publish`
}

repositories {
    mavenCentral()
    maven("https://jitpack.io")
}

group = "com.github.kis3tar"

version = "0.1.5"

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

tasks.test {
    useJUnitPlatform()
    testLogging {
        exceptionFormat = TestExceptionFormat.FULL
        showStandardStreams = true
        showExceptions = true
        showCauses = true
        showStackTraces = true
        events =
                setOf(
                        TestLogEvent.FAILED,
                        TestLogEvent.PASSED,
                        TestLogEvent.SKIPPED,
                        TestLogEvent.STANDARD_OUT
                )
    }
}

dependencies {
    // Align versions of all Kotlin components.
    // implementation(platform(kotlin("bom")))

    // Use the Kotlin JDK 8 standard library.
    // implementation(kotlin("stdlib-jdk8"))

    // Use Guava in your implementation only.
    // implementation("com.google.guava:guava:30.1.1-jre")

    // Use the Kotlin test library.
    testImplementation(kotlin("test"))
}

publishing {
    publications { register("mavenJava", MavenPublication::class) { from(components["java"]) } }
    repositories { mavenLocal() }
}

tasks.register<Exec>("cargo-build") {
    workingDir(".")
    executable("cargo")
    args("+nightly", "build", "--release", "--all-features")
}

tasks.register<Copy>("copy-artifacts") {
    dependsOn("cargo-build")
    from("target/release/")
    include("*.so", "*.dll", "*.dylib")
    into("src/main/resources")
}

tasks.register("full-build-test") { 
    dependsOn("copy-artifacts")
    dependsOn("test")
 }

// tasks.processResources { dependsOn("copy-artifacts") }
// tasks.test { dependsOn("copy-artifacts") }

tasks.register<Jar>("sourcesJar") {
    dependsOn("classes")
    archiveClassifier.set("sources")
    from("src/main")
}

tasks.jar {
    manifest {
        attributes(
                mapOf(
                        "Implementation-Title" to project.name,
                        "Implementation-Version" to project.version
                )
        )
    }
    // archiveAppendix.set(getJarAppendix())
}

// fun getJarAppendix(): String {
//     val nativePlatform =
// org.gradle.nativeplatform.platform.internal.DefaultNativePlatform("current")
//     val arch = "x64"
//     val os = nativePlatform.operatingSystem
//     if (os.isMacOsX()) {
//         return "darwin-$arch"
//     } else if (os.isLinux()) {
//         return "linux-$arch"
//     } else if (os.isWindows()) {
//         return "windows-$arch"
//     } else {
//         throw RuntimeException("Platform " + os.getName() + " is not supported.")
//     }
// }
