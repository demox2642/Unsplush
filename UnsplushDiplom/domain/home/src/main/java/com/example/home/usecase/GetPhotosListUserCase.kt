package com.example.home.usecase

import com.example.home.models.Order
import com.example.home.models.Photo
import com.example.home.models.UnsplashResource
import com.example.home.repository.HomeRepository

class GetPhotosListUserCase(private val homeRepository: HomeRepository) {

    suspend fun getPhotosList(
        page: Int?,
        perPage: Int?,
        order: Order?
    ): UnsplashResource<List<Photo>> = homeRepository.getPhotosList(page, perPage, order)
}
