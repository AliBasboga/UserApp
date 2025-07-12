package com.example.userapp.service

import com.example.userapp.model.User
import retrofit2.Response
import retrofit2.http.GET

interface UserAPI {
    @GET("atilsamancioglu/UsersJSONPlaceHolder/refs/heads/main/users.json")
    suspend fun getData(): Response<List<User>>  // Yanıtın Response tipi olmalı
}
