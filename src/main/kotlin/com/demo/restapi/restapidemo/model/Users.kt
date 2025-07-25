package com.demo.restapi.restapidemo.model

import com.demo.restapi.restapidemo.dto.UsersDTO
import com.demo.restapi.restapidemo.dto.UsersSimpleDTO
import java.util.*

import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table
import jakarta.persistence.JoinColumn
import jakarta.persistence.JoinTable
import jakarta.persistence.ManyToMany
import org.hibernate.annotations.Cascade
import org.hibernate.annotations.CascadeType
import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.OneToMany


@Entity
@Table(name = "users")
data class Users(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long ?= null,

    @Column(nullable = false, unique = true)
    val username: String,

    @ManyToMany(mappedBy = "following", fetch = FetchType.LAZY)
    @Cascade(CascadeType.PERSIST)
    val followers: MutableSet<Users> = mutableSetOf(),

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "user_following",
        joinColumns = [JoinColumn(name = "user_id")],
        inverseJoinColumns = [JoinColumn(name = "following_id")]
    )
    @Cascade(CascadeType.PERSIST)
    val following: MutableSet<Users> = mutableSetOf()
)