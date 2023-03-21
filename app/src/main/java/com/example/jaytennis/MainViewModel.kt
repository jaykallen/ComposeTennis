package com.example.jaytennis

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// 2023-03-20 The repository is injected as the parameter of the view model via Koin DI
// Todo: How to pass state flow from repository to view model and then to compose

class MainViewModel(
    private val mainRepositoryImpl: MainRepositoryImpl
): ViewModel() {

    var playerPass = mainRepositoryImpl.playerFlow
    var apiPass = mainRepositoryImpl.apiCode

    fun doNetworkCall() {
        mainRepositoryImpl.callApi()
    }
}