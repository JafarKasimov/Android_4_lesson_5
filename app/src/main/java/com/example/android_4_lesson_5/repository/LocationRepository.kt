package com.example.android_4_lesson_5.repository

import com.example.android_4_lesson_5.base.BaseRepository
import com.example.android_4_lesson_5.data.remote.apiservices.LocationApi
import javax.inject.Inject

class LocationRepository @Inject constructor(
    private val locationApiService: LocationApi
) : BaseRepository () {

    fun fetchLocation() = doRequest {
        locationApiService.getLocation()
    }
}
