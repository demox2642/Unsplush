package com.example.home.repository

import com.example.home.models.Order
import com.example.home.models.Photo
import com.example.home.models.UnsplashResource

interface HomeRepository {

    suspend fun getPhotosList(
        page: Int?,
        perPage: Int?,
        order: Order?
    ): UnsplashResource<List<Photo>>
}
