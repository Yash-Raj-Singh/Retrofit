package com.example.retrofit

import retrofit2.Response

class Respository {

    suspend fun getCountryDetail(): Response<Post> {
       return RetrofitInstance.api.getCountryDetail()
    }

}