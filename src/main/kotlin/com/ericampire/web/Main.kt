package com.ericampire.web

import io.ktor.application.Application
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty

fun main() {
    embeddedServer(
        factory = Netty,
        port = 8080,
        watchPaths = listOf("MainKt"),
        module = Application::module
    ).start()
}