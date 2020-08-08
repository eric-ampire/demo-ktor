plugins {
    kotlin("jvm") version "1.3.72"
    application
}

application {
    mainClassName = "com.ericampire.web.MainKt.main"
}

group = "org.ericampire.web"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    jcenter()
}

dependencies {
    val ktor_version = "1.3.2"
    implementation(kotlin("stdlib"))

    implementation("io.ktor:ktor-thymeleaf:$ktor_version")
    implementation("io.ktor:ktor-server-netty:$ktor_version")
    implementation("io.ktor:ktor-jackson:$ktor_version")
    implementation("io.ktor:ktor-gson:$ktor_version")

    implementation("ch.qos.logback:logback-classic:1.2.3")
}
