package com.demo.restapi.restapidemo.service

import com.demo.restapi.restapidemo.dto.UsersDTO
import com.demo.restapi.restapidemo.repository.UsersRepository
import com.demo.restapi.restapidemo.utils.mapper.UserMapper
import org.springframework.stereotype.Service
import jakarta.persistence.EntityNotFoundException
import org.springframework.http.HttpStatus

@Service
class UsersServiceImpl (
    private val usersRepository: UsersRepository,
    private val userMapper: UserMapper
) : UsersService {
    override fun createUser(user: UsersDTO): UsersDTO {
        if (user.id != null) {
            println("New user should not have an ID")
            throw IllegalArgumentException("New user should not have an ID")
        }

        if (user.username.isBlank()) {
            println("Username cannot be blank")
            throw IllegalArgumentException("Username cannot be blank")
        }

        val savedUser = usersRepository.save(userMapper.toEntity(user))
        return userMapper.fromEntity(savedUser)
    }

    override fun getAllUsername(): List<UsersDTO> {
        val username = usersRepository.findAll().map { userMapper.fromEntity(it) }

        if (username.isEmpty()) {
            println("No users found")
            throw EntityNotFoundException("No users found")
        }

        return username
    }

    override fun getUsernameById(id: Long): UsersDTO {
        val user = usersRepository.findById(id).orElseThrow {
            println("User with ID $id not found")
            EntityNotFoundException("User with ID $id not found")
        }

        return userMapper.fromEntity(user)
    }
}