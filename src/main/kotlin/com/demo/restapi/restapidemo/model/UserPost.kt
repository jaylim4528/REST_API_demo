package com.demo.restapi.restapidemo.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "user_posts")
data class UserPost(
    @Id
    val id: String? = null,

    // Link to the MySQL user ID and username
    val userId: Long,
    val username: String,

    val post: List<Post> = emptyList()
    )
