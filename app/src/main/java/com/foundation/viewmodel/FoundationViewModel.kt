package com.foundation.viewmodel

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.foundation.data.FoundationPhotosItem
import com.foundation.usecase.FoundationUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class FoundationViewModel @Inject constructor(private val foundationUseCase: FoundationUseCase):
    ViewModel() , LifecycleObserver {

    var photosItem = MutableLiveData<List<FoundationPhotosItem>>()

    fun getListOfPhotos(){
        viewModelScope.launch {
            val data = foundationUseCase.getListOfPhotos()
            photosItem.postValue(data)
        }
    }

    override fun onCleared() {
        super.onCleared()
    }
}