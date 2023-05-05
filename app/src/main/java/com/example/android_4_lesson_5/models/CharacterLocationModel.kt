package com.example.android_4_lesson_5.models

data class CharacterLocationModel(
    val character: CharacterModel,
    val location: LocationModel,
    val id: Int = 0
)
