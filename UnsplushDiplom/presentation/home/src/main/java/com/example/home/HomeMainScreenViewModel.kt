package com.example.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.home.models.Order
import com.example.home.usecase.GetPhotosListUserCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeMainScreenViewModel @Inject constructor(
    private val getPhotosListUserCase: GetPhotosListUserCase
) : ViewModel() {

    init {
        getPhotosList()
    }

    fun getPhotosList() {
        Log.e("HomeVM", "photos ")
        viewModelScope.launch {
            try {
                val photos = getPhotosListUserCase.getPhotosList(1, 10, Order.LATEST)
                Log.e("HomeVM", "photos = ${photos.errorMessage} data = ${photos.data}")
            } catch (e: Exception) {
                Log.e("HomeVM", "getPhotosList ERROR : ${e.message}")
            }
        }
    }
}
