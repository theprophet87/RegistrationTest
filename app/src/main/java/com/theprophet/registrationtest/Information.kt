package com.theprophet.registrationtest

import java.io.Serializable


data class Information (
    val title: String?,
    val firstName: String,
    val lastName: String,
    val email: String,
    val phoneNumber: String,
    val password: String
    ): Serializable{
    fun getName(): String = if(title == "") "$firstName $lastName" else "$title $firstName $lastName"

    }