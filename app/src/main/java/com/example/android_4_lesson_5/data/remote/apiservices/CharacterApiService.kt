package com.example.android_4_lesson_5.data.remote.apiservices

import com.example.android_4_lesson_5.models.CharacterModel
import com.example.android_4_lesson_5.models.LocationModel
import com.example.android_4_lesson_5.models.RickAndMortyResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface CharacterApiService {

   @GET("character")
   suspend fun getCharacter(): RickAndMortyResponse<CharacterModel>
}