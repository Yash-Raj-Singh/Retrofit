package com.example.retrofit

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface RestCountryAPI {
    @GET("posts/5")
    suspend fun getCountryDetail(): Response<Post>
}