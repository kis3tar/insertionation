/*
 * This file was generated by the Gradle 'init' task.
 *
 * This generated file contains a sample Kotlin library project to get you started.
 * For more details take a look at the 'Building Java & JVM projects' chapter in the Gradle
 * User Manual available at https://docs.gradle.org/6.8.3/userguide/building_java_projects.html
 */

plugins {
    // Apply the org.jetbrains.kotlin.jvm Plugin to add support for Kotlin.
    id("org.jetbrains.kotlin.jvm") version "1.4.31"

    // Apply the java-library plugin for API and implementation separation.
    `java-library`
    `maven`
}

repositories {
    mavenCentral()
    maven("https://jitpack.io")
}

group = "com.github.kis3tar"
version = "0.1.2"

java {                                      
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

dependencies {
    // Align versions of all Kotlin components.
    implementation(platform("org.jetbrains.kotlin:kotlin-bom"))

    // Use the Kotlin JDK 8 standard library.
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    // Use Guava in your implementation only.
    implementation("com.google.guava:guava:30.1-jre")

    // Use the Kotlin test library.
    testImplementation("org.jetbrains.kotlin:kotlin-test")

    // Use the Kotlin JUnit integration.
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit")
}

tasks.register<Exec>("cargo-build") {
    workingDir(".")
    executable("cargo")
    args("build", "--release", "--all-features")
}

tasks.register<Copy>("copy-artifacts") {
    dependsOn("cargo-build")
    from("target/release/")
    include("*.so", "*.dll", "*.dylib")
    into("src/main/resources")
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
        attributes(mapOf("Implementation-Title" to project.name,
                         "Implementation-Version" to project.version))
    }
    // archiveAppendix.set(getJarAppendix())
}

// fun getJarAppendix(): String {
//     val nativePlatform = org.gradle.nativeplatform.platform.internal.DefaultNativePlatform("current")
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
