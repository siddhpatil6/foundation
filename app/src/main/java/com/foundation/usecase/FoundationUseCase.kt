package com.foundation.usecase


import com.foundation.interfaces.IFoundationUseCase
import com.foundation.data.FoundationPhotosItem
import com.foundation.repository.FoundationRepository
import javax.inject.Inject

class FoundationUseCase @Inject constructor(private val forthCodeRepository: FoundationRepository) :
    IFoundationUseCase {
    override suspend fun getListOfPhotos(): List<FoundationPhotosItem> {
        return forthCodeRepository.getListOfPhotos()
    }

}