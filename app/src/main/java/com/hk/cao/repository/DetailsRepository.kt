package com.hk.cao.repository

import com.hk.cao.database.AppDatabase
import com.hk.cao.database.asDomainModel
import com.hk.cao.domain.Details
import com.hk.cao.network.DetailsApi
import com.hk.cao.network.model.asDatabaseModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import timber.log.Timber
import javax.inject.Inject

class DetailsRepository @Inject constructor(
    private val detailsApi: DetailsApi,
    private val appDatabase: AppDatabase
) {

    fun getUserDetails(user: String): Flow<Details?> =
        appDatabase.usersDao.getDetails(user).map { it?.asDomainModel() }

    suspend fun refreshDetails(user: String) {
        try {
            val userDetails = detailsApi.getDetails(user)
            appDatabase.usersDao.insertDetails(userDetails.asDatabaseModel())
        } catch (e: Exception) {
            Timber.w(e)
        }
    }

}