package com.demo.restapi.restapidemo.repository

import com.demo.restapi.restapidemo.dto.UsersDTO
import com.demo.restapi.restapidemo.model.Users
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

interface UsersRepository: CrudRepository<Users, Long> {
    @Query("SELECT u FROM Users u WHERE u.username = ?1")
    fun findByUsername(username: String): Users?

    @Query("SELECT u FROM Users u WHERE u.email = ?1")
    fun findByEmail(email: String): Users?
}