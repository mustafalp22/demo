package com.emob.etraderdemo.data.api

import com.emob.etraderdemo.data.model.User
import retrofit2.Response
import javax.inject.Inject

class ApiHelperImpl @Inject constructor(private val apiService: ApiService) :
    ApiHelper {

    override suspend fun getUsers(): Response<List<User>> = apiService.getUsers()

}