package com.example.jaytennis

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

// https://gist.githubusercontent.com/jaykallen/<key1>/raw/<key2>/tennis.json

interface ApiService {
    @GET("jaykallen//{key1}//raw//{key2}//tennis.json")
    fun queryApi(@Path("key1") key1:String, @Path("key2") key2: String): Call<Players>
}