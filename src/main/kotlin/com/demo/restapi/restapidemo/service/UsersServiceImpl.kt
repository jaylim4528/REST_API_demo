package com.demo.restapi.restapidemo.service

import com.demo.restapi.restapidemo.dto.UserUpdateDTO
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

        if (user.email.isBlank()) {
            println("Email cannot be blank")
            throw IllegalArgumentException("Email cannot be blank")
        }

        if (!user.email.contains("@")) {
            println("Email must contain '@'")
            throw IllegalArgumentException("Email must contain '@'")
        }

        if (user.password.isBlank()) {
            println("Password cannot be blank")
            throw IllegalArgumentException("Password cannot be blank")
        }

        val savedUser = usersRepository.save(userMapper.toEntity(user))
        return userMapper.fromEntity(savedUser)
    }

    override fun getAllUsers(): List<UsersDTO> {
        val username = usersRepository.findAll().map { userMapper.fromEntity(it) }

        if (username.isEmpty()) {
            println("No users found")
            throw EntityNotFoundException("No users found")
        }

        return username
    }

    override fun getUserById(id: Long): UsersDTO {
        val user = usersRepository.findById(id).orElseThrow {
            println("User with ID $id not found")
            EntityNotFoundException("User with ID $id not found")
        }

        return userMapper.fromEntity(user)
    }

    override fun getUserByUsername(username: String): UsersDTO {
        val user = usersRepository.findByUsername(username) ?: run {
            println("User with username $username not found")
            throw EntityNotFoundException("User with username $username not found")
        }

        return userMapper.fromEntity(user)
    }

    override fun getUserByEmail(email: String): UsersDTO {
        val user = usersRepository.findByEmail(email) ?: run {
            println("User with email $email not found")
            throw EntityNotFoundException("User with email $email not found")
        }

        return userMapper.fromEntity(user)
    }

    override fun updateUser(user: UserUpdateDTO): UsersDTO {
        val existingUser = usersRepository.findById(user.id).orElseThrow {
            println("User with ID ${user.id} not found")
            EntityNotFoundException("User with ID ${user.id} not found")
        }

        if (user.username != null && user.username != existingUser.username) {
            println("Username cannot be changed")
            throw IllegalArgumentException("Username cannot be changed")
        }

        user.email?.takeIf { it.isNotBlank() }?.let {
            existingUser.email = it
        }

        user.password?.takeIf { it.isNotBlank() }?.let {
            existingUser.password = it
        }

        user.info?.takeIf { it.isNotBlank() }?.let {
            existingUser.info = it
        }

        val updatedUser = usersRepository.save(existingUser)

        return userMapper.fromEntity(updatedUser)
    }
}