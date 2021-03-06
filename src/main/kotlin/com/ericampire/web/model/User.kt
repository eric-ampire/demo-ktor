package com.ericampire.web.model

import java.io.Serializable

data class User(
    val firstName: String = "",
    val lastName: String = "",
    val email: String = ""
) : Serializable