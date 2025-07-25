package com.demo.restapi.restapidemo.utils.mapper

interface Mapper<D, E> {
    fun fromEntity(entity: E): D
    fun toEntity(dto: D): E
}