package com.demo.restapi.restapidemo.model

data class Post(
    val id: String,
    var picture: String,
    var description: String? = null,
)
