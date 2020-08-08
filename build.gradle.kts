plugins {
    kotlin("jvm") version "1.3.72"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    val ktor_version = ""
    implementation(kotlin("stdlib"))
    implementation("io.ktor:ktor-thymeleaf:$ktor_version")
}
