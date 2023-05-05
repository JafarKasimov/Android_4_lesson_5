package com.example.android_4_lesson_5.data.remote.apiservices

import com.example.android_4_lesson_5.models.LocationModel
import com.example.android_4_lesson_5.models.RickAndMortyResponse
import retrofit2.http.GET

interface LocationApi {
    @GET("location")
    suspend fun getLocation(): RickAndMortyResponse<LocationModel>
}