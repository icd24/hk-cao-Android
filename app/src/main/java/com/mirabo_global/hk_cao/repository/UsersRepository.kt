package com.mirabo_global.hk_cao.repository

import com.mirabo_global.hk_cao.database.AppDatabase
import com.mirabo_global.hk_cao.database.asDomainModel
import com.mirabo_global.hk_cao.domain.User
import com.mirabo_global.hk_cao.network.UsersApi
import com.mirabo_global.hk_cao.network.model.asDatabaseModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import timber.log.Timber
import javax.inject.Inject

class UsersRepository @Inject constructor(
    private val usersApi: UsersApi,
    private val appDatabase: AppDatabase
) {

    val users: Flow<List<User>?> =
        appDatabase.usersDao.getUsers().map { it?.asDomainModel() }

    suspend fun refreshUsers() {
        try {
            val users = usersApi.getUsers()
            appDatabase.usersDao.insertUsers(users.asDatabaseModel())
        } catch (e: Exception) {
            Timber.w(e)
        }
    }
}