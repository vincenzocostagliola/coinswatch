package dev.vincenzocostagliola.data

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.vincenzocostagliola.data.net.repository.Repository
import dev.vincenzocostagliola.data.net.repository.RepositoryImpl
import dev.vincenzocostagliola.data.net.service.CoinsService
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Singleton


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

    @Provides
    @Singleton
    fun provideCoinsService(retrofit: Retrofit): CoinsService {
        return retrofit
            .create(CoinsService::class.java)
    }


    @OptIn(ExperimentalSerializationApi::class)
    @Provides
    @Singleton
    fun provideRetrofit(
        client: OkHttpClient,
        json: Json
    ): Retrofit {
        val contentType = "application/json".toMediaType()
        //JsonConfiguration(prettyPrint = true, ignoreUnknownKeys = true)
        val kotlinxConverterFactory = json.asConverterFactory(contentType)

        return Retrofit.Builder()
            .baseUrl("BASEURL")
            .addCallAdapterFactory(ApiResponseCallAdapterFactory.create())
            .addConverterFactory(kotlinxConverterFactory)
            .client(client)
            .build()
    }
}