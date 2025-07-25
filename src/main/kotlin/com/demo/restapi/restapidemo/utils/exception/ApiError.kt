package com.demo.restapi.restapidemo.utils.exception

import org.springframework.http.HttpStatus

data class ApiError(
    val status: HttpStatus = HttpStatus.BAD_REQUEST,
    val code: Int = status.value(),
    val timestamp: Long = System.currentTimeMillis()
)