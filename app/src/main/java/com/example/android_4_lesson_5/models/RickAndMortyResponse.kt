package com.example.android_4_lesson_5.models

import com.google.gson.annotations.SerializedName

data class RickAndMortyResponse<T>(
    @SerializedName("results")
    val results: ArrayList<T>
)