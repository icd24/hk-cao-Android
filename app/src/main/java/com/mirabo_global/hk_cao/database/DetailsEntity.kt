package com.mirabo_global.hk_cao.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.mirabo_global.hk_cao.domain.Details

@Entity
data class DetailsEntity constructor(
    @PrimaryKey
    val user: String,
    val avatar: String,
    val name: String,
    val userSince: String,
    val location: String
)

fun DetailsEntity.asDomainModel(): Details {
    return Details(
        user = user,
        avatar = avatar,
        name = name,
        userSince = userSince,
        location = location
    )
}