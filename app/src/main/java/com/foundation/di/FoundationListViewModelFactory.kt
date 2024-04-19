package com.foundation.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.foundation.usecase.FoundationUseCase
import com.foundation.viewmodel.FoundationViewModel
import javax.inject.Inject

class FoundationListViewModelFactory : ViewModelProvider.Factory {

    @Inject
    lateinit var foundationUseCase: FoundationUseCase


    init {
        DaggerFoundationListComponent.builder().build().inject(this)
    }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(FoundationViewModel::class.java)) {
            return FoundationViewModel(foundationUseCase) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }

}