package com.alpha.data.module.di

import com.alpha.data.module.ApiInterface
import com.alpha.data.module.HomeRepositoryImpl
import com.alpha.domain.model.ApiRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun provideHomeRepository(apiInterface: ApiInterface): ApiRepository {
        return HomeRepositoryImpl(apiInterface)

    }
}