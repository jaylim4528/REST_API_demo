package com.demo.restapi.restapidemo.web.rest

import com.demo.restapi.restapidemo.dto.UserUpdateDTO
import com.demo.restapi.restapidemo.service.UsersService
import com.demo.restapi.restapidemo.dto.UsersDTO
import jakarta.persistence.EntityNotFoundException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.PutMapping

@RestController
class UserResource (
    private val usersService: UsersService
) {
    @PostMapping("/api/user")
    fun createUser(@RequestBody user: UsersDTO): ResponseEntity<UsersDTO> {
        return ResponseEntity.status(HttpStatus.CREATED).body(usersService.createUser(user))
    }

    @GetMapping("/api/users")
    fun getUsers(): ResponseEntity<List<UsersDTO>> {
        return ResponseEntity.ok(usersService.getAllUsers())
    }

    @GetMapping("/api/users/id/{id}")
    fun getUserById(@PathVariable id: Long): ResponseEntity<UsersDTO> {
        return try {
            ResponseEntity.ok(usersService.getUserById(id))
        } catch (e: EntityNotFoundException) {
            ResponseEntity.status(HttpStatus.NOT_FOUND).body(null)
        }
    }

    @GetMapping("/api/users/username/{username}")
    fun getUserByUsername(@PathVariable username: String): ResponseEntity<UsersDTO> {
        return try {
            ResponseEntity.ok(usersService.getUserByUsername(username))
        } catch (e: EntityNotFoundException) {
            ResponseEntity.status(HttpStatus.NOT_FOUND).body(null)
        }
    }

    @GetMapping("/api/users/email/{email}")
    fun getUserByEmail(@PathVariable email: String): ResponseEntity<UsersDTO> {
        return try {
            ResponseEntity.ok(usersService.getUserByEmail(email))
        } catch (e: EntityNotFoundException) {
            ResponseEntity.status(HttpStatus.NOT_FOUND).body(null)
        }
    }

    @PutMapping("/api/users/update")
    fun updateUser(@RequestBody user: UserUpdateDTO): ResponseEntity<UsersDTO> {
        return try {
            ResponseEntity.ok(usersService.updateUser(user))
        } catch (e: EntityNotFoundException) {
            ResponseEntity.status(HttpStatus.NOT_FOUND).body(null)
        }
    }

    @DeleteMapping("/api/users/delete/id/{id}")
    fun deleteUserById(@PathVariable id: Long): ResponseEntity<Void> {
        return try {
            usersService.deleteUserById(id)
            ResponseEntity.noContent().build()
        } catch (e: EntityNotFoundException) {
            ResponseEntity.status(HttpStatus.NOT_FOUND).build()
        }
    }

    @DeleteMapping("/api/users/delete/username/{username}")
    fun deleteUserByUsername(@PathVariable username: String): ResponseEntity<Void> {
        return try {
            usersService.deleteUserByUsername(username)
            ResponseEntity.noContent().build()
        } catch (e: EntityNotFoundException) {
            ResponseEntity.status(HttpStatus.NOT_FOUND).build()
        }
    }

    @DeleteMapping("/api/users/delete/email/{email}")
    fun deleteUserByEmail(@PathVariable email: String): ResponseEntity<Void> {
        return try {
            usersService.deleteUserByEmail(email)
            ResponseEntity.noContent().build()
        } catch (e: EntityNotFoundException) {
            ResponseEntity.status(HttpStatus.NOT_FOUND).build()
        }
    }
}