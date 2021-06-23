package com.example.retrofit

import retrofit2.Response

class Respository {

    suspend fun getCountryDetail(): Response<Post> {
        return RetrofitInstance.api.getCountryDetail()
    }


    suspend fun getCountryDetail2(number: Int): Response<Post> {
        return RetrofitInstance.api.getCountryDetail2(number)
    }

    suspend fun getCustomPost(userId: Int, sort: String, order: String): Response<List<Post>> {
        return RetrofitInstance.api.getCustomPost(userId, sort, order)
    }

    suspend fun getCustomPost2(userId: Int, options: Map<String, String>): Response<List<Post>> {
        return RetrofitInstance.api.getCustomPost2(userId, options)
    }
}