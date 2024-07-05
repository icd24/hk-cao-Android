package com.mirabo_global.hk_cao.repository

import com.mirabo_global.hk_cao.database.AppDatabase
import com.mirabo_global.hk_cao.database.asDomainModel
import com.mirabo_global.hk_cao.domain.Details
import com.mirabo_global.hk_cao.network.DetailsApi
import com.mirabo_global.hk_cao.network.model.asDatabaseModel
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