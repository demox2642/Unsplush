package com.example.home.services

import com.example.home.models.Photo
import retrofit2.http.GET
import retrofit2.http.Query

interface HomeService {

    @GET("photos")
    suspend fun getSuspend(
        @Query("page") page: Int?,
        @Query("per_page") perPage: Int?,
        @Query("order_by") orderBy: String?
    ): List<Photo>
}