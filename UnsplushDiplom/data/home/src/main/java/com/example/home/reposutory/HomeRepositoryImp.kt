package com.example.home.reposutory

import com.example.home.models.Order
import com.example.home.models.Photo
import com.example.home.models.UnsplashResource
import com.example.home.repository.HomeRepository
import com.example.home.services.HomeService

class HomeRepositoryImp(
    private val homeService: HomeService,
    private var responseHandler: UnsplashResponseHandler
) : HomeRepository {
    override suspend fun getPhotosList(
        page: Int?,
        perPage: Int?,
        order: Order?
    ): UnsplashResource<List<Photo>> {
        return try {
            val res = homeService.getSuspend(page, perPage, order?.order)
            responseHandler.handleSuccess(res)
        } catch (e: Exception) {
            responseHandler.handleException(e)
        }
    }
}
