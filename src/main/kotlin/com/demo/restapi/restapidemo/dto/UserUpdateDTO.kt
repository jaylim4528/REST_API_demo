package com.demo.restapi.restapidemo.dto

data class UserUpdateDTO(
    val id: Long,
    val username: String? = null,
    val email: String? = null,
    val password: String? = null,
    val info: String? = null
)
