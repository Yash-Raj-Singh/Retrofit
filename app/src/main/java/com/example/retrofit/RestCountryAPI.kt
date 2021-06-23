package com.example.retrofit

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface RestCountryAPI {
    @GET("posts/5")
    suspend fun getCountryDetail(): Response<Post>

    @GET("posts/{postNumber}")
    suspend fun getCountryDetail2(
        @Path("postNumber") number : Int
    ): Response<Post>

    @GET("posts")
    suspend fun getCustomPost(
        @Query("userId") userId: Int,
        @Query("_sort") sort : String,
        @Query("_order") order : String
    ) : Response<List<Post>>

    @GET("posts")
    suspend fun getCustomPost2(
        @Query("userId") userId: Int,
        @QueryMap options : Map<String, String>
    ) : Response<List<Post>>
}