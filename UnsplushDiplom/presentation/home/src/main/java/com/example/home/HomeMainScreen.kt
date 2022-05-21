package com.example.home

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun HomeMainScreen(){
    val viewModel = hiltViewModel< HomeMainScreenViewModel>()
    Text("HomeMainScreen")
}