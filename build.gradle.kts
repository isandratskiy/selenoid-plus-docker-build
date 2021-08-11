import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import java.lang.System.getenv

plugins {
    kotlin("jvm") version "1.5.10"
}

group = "io.isandratskyi"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.codeborne:selenide:5.23.2")
    testImplementation(kotlin("test"))
}

tasks.test {
    testLogging.showStandardStreams = true
    testLogging.showExceptions = true
    testLogging.showStackTraces = true
    testLogging.showCauses = true
    useJUnitPlatform()
}

task<Exec>("pull") {
    commandLine("docker", "pull", "selenoid/chrome:${getenv("BROWSER_VERSION")}")
}

task<Exec>("start") {
    commandLine("docker-compose", "up", "--build", "--abort-on-container-exit", "--force-recreate")
}

task<Exec>("stop") {
    commandLine("docker-compose", "down", "--rmi", "all")
}

task<Exec>("browsers") {
    commandLine("sed", "-i", "-e", "s/browser.version/${getenv("BROWSER_VERSION")}/g", "browsers.json")
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "11"
}