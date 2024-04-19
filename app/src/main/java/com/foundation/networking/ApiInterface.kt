package com.foundation.networking


import com.foundation.data.FoundationPhotosItem
import retrofit2.http.GET


interface ApiInterface {
    @GET("/photos")
    suspend fun getPhotosList(): List<FoundationPhotosItem>


}