package com.demo.restapi.restapidemo.utils.exception

import jakarta.persistence.EntityNotFoundException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ExceptionHandler {
    @ExceptionHandler(Exception::class)
    fun exceptionHandler(ex: Exception): ResponseEntity<ApiError> {
        val apiError = ApiError()
        return ResponseEntity(apiError, apiError.status)
    }
}