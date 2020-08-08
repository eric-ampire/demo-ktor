package com.ericampire.web

import com.ericampire.web.model.User
import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.application.install
import io.ktor.features.CallLogging
import io.ktor.features.ContentNegotiation
import io.ktor.features.DefaultHeaders
import io.ktor.gson.GsonConverter
import io.ktor.gson.gson
import io.ktor.http.ContentType
import io.ktor.http.parametersOf
import io.ktor.jackson.JacksonConverter
import io.ktor.request.receive
import io.ktor.request.receiveOrNull
import io.ktor.request.receiveParameters
import io.ktor.response.respond
import io.ktor.response.respondRedirect
import io.ktor.routing.Routing
import io.ktor.routing.get
import io.ktor.routing.post
import io.ktor.thymeleaf.Thymeleaf
import io.ktor.thymeleaf.ThymeleafContent
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver
import java.text.DateFormat

fun Application.module() {
    install(DefaultHeaders)
    install(CallLogging)
    install(Thymeleaf) {
        setTemplateResolver(ClassLoaderTemplateResolver().apply {
            prefix = "templates/"
            suffix = ".html"
            characterEncoding = "utf-8"
        })
    }

    install(ContentNegotiation) {
        register(ContentType.Application.FormUrlEncoded, JacksonConverter())
    }

    install(Routing) {
        get("/") {
            val page = ThymeleafContent("index", mapOf("user" to User()))
            call.respond(page)
        }

        post("/save") {
            val params = call.receiveParameters()
            val postedUser = User(
                firstName = params["firstName"] ?: "Undefined",
                lastName = params["lastName"] ?: "Undefined",
                email = params["email"] ?: "Undefined"
            )
            val successPage = ThymeleafContent("success", mapOf("name" to postedUser.firstName))
            call.respond(successPage)
        }
    }
}