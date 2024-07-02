package com.hk.cao.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.hk.cao.domain.User

@Entity
data class UserEntity constructor(
    @PrimaryKey
    val id: Int,
    val avatar: String,
    val username: String
)

fun List<UserEntity>.asDomainModel(): List<User> {
    return map {
        User(
            id = it.id,
            avatar = it.avatar,
            username = it.username
        )
    }
}