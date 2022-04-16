/*
 * This file was generated by the Gradle 'init' task.
 *
 * This generated file contains a sample Kotlin application project to get you started.
 * For more details take a look at the 'Building Java & JVM projects' chapter in the Gradle
 * User Manual available at https://docs.gradle.org/6.8.3/userguide/building_java_projects.html
 */

plugins {
    // Apply the org.jetbrains.kotlin.jvm Plugin to add support for Kotlin.
    id("org.jetbrains.kotlin.jvm") version "1.5.10"

    // Apply the application plugin to add support for building a CLI application in Java.
    application
}

repositories {
    mavenCentral()
    maven("https://jitpack.io")
}

dependencies {
    implementation("com.github.kis3tar:RuAnnoy:master-SNAPSHOT")
    implementation("com.spotify:annoy:0.2.6")
    
    testImplementation("org.jetbrains.kotlin:kotlin-test")
}

application {
    // Define the main class for the application.
    mainClass.set("ru.annoy.test.AppKt")
}
