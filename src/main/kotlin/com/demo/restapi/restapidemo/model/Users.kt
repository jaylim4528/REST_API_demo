package com.demo.restapi.restapidemo.model

import com.demo.restapi.restapidemo.dto.UsersDTO
import java.util.*

import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Index
import jakarta.persistence.Table



@Entity
@Table(
    name = "users",
    indexes = [
        Index(name = "username_index", columnList = "username"),
        Index(name = "email_index", columnList = "email")
    ]
)
data class Users(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long ?= null,

    @Column(nullable = false, unique = true)
    val username: String,

    @Column(nullable = false, unique = true)
    var email: String,

    @Column(nullable = false)
    var password: String,

    @Column
    var info: String? = null,
)