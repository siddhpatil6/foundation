package com.foundation.interfaces

import com.foundation.data.FoundationPhotosItem

interface IFoundationUseCase {
    suspend fun getListOfPhotos(): List<FoundationPhotosItem>

}