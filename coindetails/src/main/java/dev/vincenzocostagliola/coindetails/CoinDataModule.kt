package dev.vincenzocostagliola.coindetails

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.vincenzocostagliola.coindetails.data.repository.CoinDataRepository
import dev.vincenzocostagliola.coindetails.data.repository.CoinDataRepositoryImpl
import dev.vincenzocostagliola.coindetails.data.service.CoinDataService
import dev.vincenzocostagliola.data.error.ErrorManagement

import retrofit2.Retrofit
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class CoinDataModule {
    @Provides
    @Singleton
    fun provideCoinDataService(retrofit: Retrofit): CoinDataService {
        return retrofit
            .create(CoinDataService::class.java)
    }

    @Provides
    @Singleton
    internal fun provideRepository(
        coinDataService: CoinDataService,
        errorManagement: ErrorManagement
    ): CoinDataRepository = CoinDataRepositoryImpl(
        errorManagement = errorManagement,
        coinDataService = coinDataService
    )
}