package com.hk.cao.network

import com.hk.cao.network.model.UserApiModel
import retrofit2.http.GET

interface UsersApi {

    @GET("/repos/square/retrofit/stargazers")
    suspend fun getUsers(): List<UserApiModel>
}