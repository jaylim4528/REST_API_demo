package com.demo.restapi.restapidemo.dto

data class UsersDTO(
    val id: Long? = null,
    val username: String,
    var email: String,
    var password: String,
    var info: String? = null
)
