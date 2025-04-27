package dev.vincenzocostagliola.home

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.vincenzocostagliola.data.error.ErrorManagement
import dev.vincenzocostagliola.home.data.repository.Repository
import dev.vincenzocostagliola.home.data.repository.RepositoryImpl
import dev.vincenzocostagliola.home.data.service.CoinsService
import retrofit2.Retrofit
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
internal class HomeModule {

    @Provides
    @Singleton
    internal fun provideCoinsService(retrofit: Retrofit): CoinsService {
        return retrofit
            .create(CoinsService::class.java)
    }

    @Provides
    @Singleton
    internal fun provideRepository(
        coinsService: CoinsService,
        errorManagement: ErrorManagement
    ): Repository = RepositoryImpl(
        coinsService = coinsService,
        errorManagement = errorManagement
    )

}