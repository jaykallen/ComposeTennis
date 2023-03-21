package com.example.jaytennis

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// 2023-03-20 Koin will inject the apiService initialization through the appModule

class MainRepositoryImpl(
    private val apiService: ApiService
): MainRepository {
    private var _playerFlow = MutableStateFlow<List<Player>>(listOf())
    val playerFlow = _playerFlow.asStateFlow()
    var apiCode by mutableStateOf("000")
        private set

    override fun callApi() {
        val key1 = "5f796471e567fbe532f54a1210089938"
        val key2 = "6084b459e584b226361c9fa2e0658fbb50a80974"
        val apiCall = apiService.queryApi(key1, key2)
        println("Attempting URL: ${apiCall.request().url}")
        apiCall.enqueue(object : retrofit2.Callback<Players> {
            override fun onFailure(call: Call<Players>, t: Throwable) {
                println("Failed retrofit call")
                apiCode = "666"
            }

            override fun onResponse(call: Call<Players>, response: retrofit2.Response<Players>) {
                val players: Players? = response.body()
                println("call is ${response.code()}")
                val playerList = players?.players ?: listOf()
                if (playerList.isNotEmpty()) {
                    println("Retrieved ${playerList.size} items from JSON Data")
                    println("Got name ${playerList[0].name} from JSON Data")
                    println("Got age ${playerList[0].age} from JSON Data")
                    println("Got birthdate ${playerList[0].born} from JSON Data")
                    println("Got country ${playerList[0].country} from JSON Data")
                }
                apiCode = response.code().toString()
                _playerFlow.value = playerList
            }
        })
    }
}