package com.example.android_4_lesson_5.data.remote

import com.example.android_4_lesson_5.data.remote.apiservices.CharacterApiService
import com.example.android_4_lesson_5.data.remote.apiservices.LocationApi
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitClient {

    private val okHttpClient = OkHttpClient().newBuilder()
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS).build()

    val retrofitClient = Retrofit.Builder()
        .baseUrl("https://rickandmortyapi.com/api/")
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun fetchCharacter() = retrofitClient.create(CharacterApiService::class.java)

    fun fetchLocation() = retrofitClient.create(LocationApi::class.java)
}