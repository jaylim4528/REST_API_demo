package com.demo.restapi.restapidemo.dto

data class UsersDTO(
    val id: Long? = null,
    val username: String,
    val followers: MutableSet<UsersSimpleDTO> = mutableSetOf(),
    val following: MutableSet<UsersSimpleDTO> = mutableSetOf()
)
