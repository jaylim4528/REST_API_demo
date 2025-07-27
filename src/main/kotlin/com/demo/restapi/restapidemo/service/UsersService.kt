package com.demo.restapi.restapidemo.service

import com.demo.restapi.restapidemo.dto.UsersDTO
import com.demo.restapi.restapidemo.model.Users

interface UsersService {
    // Create operations
    fun createUser(user: UsersDTO): UsersDTO

    // Read operations
    fun getAllUsers() : List<UsersDTO>
    fun getUserById(id: Long) : UsersDTO
    fun getUserByUsername(username: String): UsersDTO
    fun getUserByEmail(email: String): UsersDTO

    // Update operations
    // fun updateUser(user: UsersDTO): UsersDTO
}