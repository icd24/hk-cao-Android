package com.mirabo_global.hk_cao.network

import com.mirabo_global.hk_cao.network.model.UserApiModel
import retrofit2.http.GET

interface UsersApi {

    @GET("/repos/square/retrofit/stargazers")
    suspend fun getUsers(): List<UserApiModel>
}