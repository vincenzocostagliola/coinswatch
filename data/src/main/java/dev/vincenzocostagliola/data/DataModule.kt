package dev.vincenzocostagliola.data

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.vincenzocostagliola.data.net.repository.Repository
import dev.vincenzocostagliola.data.net.repository.RepositoryImpl
import dev.vincenzocostagliola.data.net.service.CoinsService
import kotlinx.serialization.json.Json
import javax.inject.Singleton
import kotlin.contracts.contract

@InstallIn(SingletonComponent::class)
@Module
class DataModule {

    @Provides
    @Singleton
    fun provideJson(): Json = Json

    @Provides
    @Singleton
    internal fun provideRepository(
        coinsService: CoinsService
    ): Repository = RepositoryImpl(
        coinsService = coinsService
    )
}