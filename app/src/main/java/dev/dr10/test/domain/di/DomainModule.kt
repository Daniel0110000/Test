package dev.dr10.test.domain.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.dr10.test.data.repository.MainRepositoryImpl
import dev.dr10.test.domain.repository.MainRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DomainModule {

    @Binds
    @Singleton
    abstract fun providerMainRepository(mainRepositoryImpl: MainRepositoryImpl): MainRepository

}