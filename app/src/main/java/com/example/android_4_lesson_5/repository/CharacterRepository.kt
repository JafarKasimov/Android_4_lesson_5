package com.example.android_4_lesson_5.repository

import com.example.android_4_lesson_5.base.BaseRepository
import com.example.android_4_lesson_5.data.remote.apiservices.CharacterApiService
import javax.inject.Inject

class CharacterRepository @Inject constructor(
    private val characterApiService: CharacterApiService
) : BaseRepository() {

    fun fetchCharacter() = doRequest {
        characterApiService.getCharacter()
    }
}
