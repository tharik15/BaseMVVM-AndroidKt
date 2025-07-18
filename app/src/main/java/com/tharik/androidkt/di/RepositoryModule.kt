package com.tharik.androidkt.di

import com.tharik.androidkt.repository.Repository
import com.tharik.androidkt.repository.RepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun providesRetrofit(repositoryImpl: RepositoryImpl): Repository = repositoryImpl

}