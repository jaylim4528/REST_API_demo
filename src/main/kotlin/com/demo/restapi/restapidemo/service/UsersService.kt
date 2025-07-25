package com.demo.restapi.restapidemo.service

import com.demo.restapi.restapidemo.dto.UsersDTO
import com.demo.restapi.restapidemo.model.Users

interface UsersService {
    fun createUser(user: UsersDTO): UsersDTO

    fun getAllUsername() : List<UsersDTO>

    fun getUsernameById(id: Long) : UsersDTO
}