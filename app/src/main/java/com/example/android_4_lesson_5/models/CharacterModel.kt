package com.example.android_4_lesson_5.models

import com.google.gson.annotations.SerializedName

data class CharacterModel(

    @SerializedName("id")
    val id: Int,

    @SerializedName("name")
    val name: String,

    @SerializedName("image")
    val image: String,

    @SerializedName("gender")
    val gender: String,

    @SerializedName("status")
    val status: String
)