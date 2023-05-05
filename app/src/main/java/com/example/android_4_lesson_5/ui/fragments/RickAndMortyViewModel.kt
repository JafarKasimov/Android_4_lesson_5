package com.example.android_4_lesson_5.ui.fragments

import androidx.lifecycle.*
import com.example.android_4_lesson_5.base.BaseViewModel
import com.example.android_4_lesson_5.models.CharacterLocationModel
import com.example.android_4_lesson_5.repository.LocationRepository
import com.example.android_4_lesson_5.repository.CharacterRepository
import com.example.android_4_lesson_5.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RickAndMortyViewModel @Inject constructor(
    private val characterRepository: CharacterRepository,
    private val locationRepository: LocationRepository
) : BaseViewModel() {

    private val _noteLiveData =
        MutableLiveData<Resource<List<CharacterLocationModel>>>(Resource.Loading())
    val noteLiveData: LiveData<Resource<List<CharacterLocationModel>>> = _noteLiveData

    init {
        getData()
    }

    private fun getData() {
        val character = viewModelScope.async {
            characterRepository.fetchCharacter()
        }
        val location = viewModelScope.async {
            locationRepository.fetchLocation()
        }
        viewModelScope.launch {
            character.await().combine(location.await()) { character, location ->
                Pair(character, location)
            }.collect {
                when {
                    it.first is Resource.Error && it.second is Resource.Error -> {
                        _noteLiveData.value = Resource.Error(it.first.message + it.second.message)
                    }
                    it.first is Resource.Success && it.second is Resource.Success -> {
                        val modelsList = mutableListOf<CharacterLocationModel>()
                        it.first.data!!.results.zip(it.second.data!!.results).forEach { models ->
                            modelsList.add(
                                CharacterLocationModel(
                                    models.first,
                                    models.second,
                                    models.first.id
                                )
                            )
                        }
                        _noteLiveData.value = Resource.Success(modelsList)
                    }
                }
            }
        }
    }
}