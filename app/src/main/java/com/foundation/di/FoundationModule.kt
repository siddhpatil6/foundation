package com.foundation.di


import com.foundation.interfaces.IFoundationRepository
import com.foundation.interfaces.IFoundationUseCase
import com.foundation.networking.APIClient

import com.foundation.repository.FoundationRepository
import com.foundation.usecase.FoundationUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class FoundationModule {
    @Provides
    fun getFoundationCase(forthCodeRepository: FoundationRepository): IFoundationUseCase = FoundationUseCase(forthCodeRepository = forthCodeRepository)

    @Provides
    fun getFoundationRepository(apiClient: APIClient): IFoundationRepository = FoundationRepository(apiClient)


}