package com.emob.etraderdemo.data.api

import com.emob.etraderdemo.data.model.User
import retrofit2.Response

interface ApiHelper {

    suspend fun getUsers(): Response<List<User>>
}