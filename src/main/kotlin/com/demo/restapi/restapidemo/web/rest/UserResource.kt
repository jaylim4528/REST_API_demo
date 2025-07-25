package com.demo.restapi.restapidemo.web.rest

import com.demo.restapi.restapidemo.service.UsersService
import com.demo.restapi.restapidemo.dto.UsersDTO
import jakarta.persistence.EntityNotFoundException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
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
    @PostMapping("/api/users")
    fun createUser(@RequestBody user: UsersDTO): ResponseEntity<UsersDTO> {
        return ResponseEntity.status(HttpStatus.CREATED).body(usersService.createUser(user))
    }

    @GetMapping("/api/username")
    fun getUsername(): ResponseEntity<List<UsersDTO>> {
        return ResponseEntity.ok(usersService.getAllUsername())
    }

    @GetMapping("/api/username/{id}")
    fun getUsernameById(@PathVariable id: Long): ResponseEntity<UsersDTO> {
        return try {
            ResponseEntity.ok(usersService.getUsernameById(id))
        } catch (e: EntityNotFoundException) {
            ResponseEntity.status(HttpStatus.NOT_FOUND).body(null)
        }
    }
}