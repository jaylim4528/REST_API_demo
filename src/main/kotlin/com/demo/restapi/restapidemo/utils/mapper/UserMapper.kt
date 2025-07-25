package com.demo.restapi.restapidemo.utils.mapper

import com.demo.restapi.restapidemo.dto.UsersDTO
import com.demo.restapi.restapidemo.dto.UsersSimpleDTO
import com.demo.restapi.restapidemo.model.Users
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service

@Component
class UserMapper: Mapper<UsersDTO, Users> {
    override fun fromEntity(entity: Users): UsersDTO {
        return UsersDTO(
            id = entity.id,
            username = entity.username,
            followers = entity.followers.map { toSimpleDTO(it) }.toMutableSet(),
            following = entity.following.map { toSimpleDTO(it) }.toMutableSet()
        )
    }

    override fun toEntity(dto: UsersDTO): Users {
        return Users(
            id = dto.id,
            username = dto.username
        )
    }

    private fun toSimpleDTO(user: Users): UsersSimpleDTO {
        return UsersSimpleDTO(
            id = user.id ?: throw IllegalArgumentException("User ID must not be null"),
            username = user.username
        )
    }
}