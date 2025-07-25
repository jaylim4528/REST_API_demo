package com.demo.restapi.restapidemo.repository

import com.demo.restapi.restapidemo.dto.UsersDTO
import com.demo.restapi.restapidemo.model.Users
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

interface UsersRepository: CrudRepository<Users, Long>