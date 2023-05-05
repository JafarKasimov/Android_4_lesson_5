package com.example.android_4_lesson_5.di

import com.example.android_4_lesson_5.data.remote.RetrofitClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    val retrofitClient = RetrofitClient()

    @Singleton
    @Provides
    fun characterApiService() = retrofitClient.fetchCharacter()

    @Singleton
    @Provides
    fun locationApiService() = retrofitClient.fetchLocation()
}