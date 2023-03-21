package com.example.jaytennis

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

val appModule = module {
    single {
        val gson: Gson = GsonBuilder().setLenient().create()
        Retrofit.Builder()
            .baseUrl("https://gist.githubusercontent.com/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(ApiService::class.java)
    }

    // If set to Single, it creates a singleton
    // If set to Factory, then creates a new instance for each view model
    single<MainRepositoryImpl> {
        // The get() takes the instantiation from above
        MainRepositoryImpl(get())
    }

    // This gets injected into the Main Activity
    viewModel {
        MainViewModel(get())
    }
}