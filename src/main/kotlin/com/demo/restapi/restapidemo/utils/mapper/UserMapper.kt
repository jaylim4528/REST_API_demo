package com.demo.restapi.restapidemo.utils.mapper

import com.demo.restapi.restapidemo.dto.UsersDTO
import com.demo.restapi.restapidemo.model.Users
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service

@Component
class UserMapper: Mapper<UsersDTO, Users> {
    override fun fromEntity(entity: Users): UsersDTO {
        return UsersDTO(
            id = entity.id,
            username = entity.username,
            email = entity.email,
            password = entity.password,
            info = entity.info
        )
    }

    override fun toEntity(dto: UsersDTO): Users {
        return Users(
            id = dto.id,
            username = dto.username,
            email = dto.email,
            password = dto.password,
            info = dto.info
        )
    }
}