package com.hk.cao.ui.users

import com.hk.cao.domain.User

data class UsersUiState(
    val list: List<User> = listOf(),
    val offline: Boolean = false
)