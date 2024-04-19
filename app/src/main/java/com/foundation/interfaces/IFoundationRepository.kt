package com.foundation.interfaces
import com.foundation.data.FoundationPhotosItem

interface  IFoundationRepository {
  suspend fun getListOfPhotos(): List<FoundationPhotosItem>

}