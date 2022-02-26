import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
    repositories {
        maven("https://artifacts.hyattdev.com/artifactory/plugins-release")
        maven("https://artifacts.hyattdev.com/artifactory/remote-repos")
    }
}

plugins {
    kotlin("jvm") version "1.6.10"
    application
    idea
}

group = "com.ddaypunk"
version = "1.0-SNAPSHOT"

dependencies {
    testImplementation(kotlin("test"))
}

repositories {
    maven("https://artifacts.hyattdev.com/artifactory/plugins-release")
    maven("https://artifacts.hyattdev.com/artifactory/remote-repos")
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "11"
}

application {
    mainClass.set("MainKt")
}