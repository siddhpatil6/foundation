package com.foundation.repository

import com.foundation.networking.APIClient
import com.foundation.networking.ApiInterface
import com.foundation.interfaces.IFoundationRepository
import com.foundation.data.FoundationPhotosItem
import javax.inject.Inject

class FoundationRepository @Inject constructor (var apiClient: APIClient): IFoundationRepository {

    override suspend fun getListOfPhotos(): List<FoundationPhotosItem> {
        val apiInterface = apiClient.getInstance().create(ApiInterface::class.java)
        return apiInterface.getPhotosList()
    }


}