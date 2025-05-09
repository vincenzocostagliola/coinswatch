package dev.vincenzocostagliola.data

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.skydoves.sandwich.retrofit.adapters.ApiResponseCallAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.vincenzocostagliola.data.error.ErrorManagement
import dev.vincenzocostagliola.data.net.interceptor.ApiHeaderInterceptor
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
class DataModule {

    @Provides
    @Singleton
    internal fun provideJson(): Json = Json {
        encodeDefaults = true
        ignoreUnknownKeys = true
    }


    @Provides
    @Singleton
    internal fun provideErrorManagement(): ErrorManagement {
        return ErrorManagement()
    }

    @OptIn(ExperimentalSerializationApi::class)
    @Provides
    @Singleton
    fun provideRetrofit(
        client: OkHttpClient,
        json: Json
    ): Retrofit {
        val contentType = "application/json".toMediaType()
        val kotlinxConverterFactory = json.asConverterFactory(contentType)

        return Retrofit.Builder()
            .baseUrl("https://api.coingecko.com/api/v3/")
            .addCallAdapterFactory(ApiResponseCallAdapterFactory.create())
            .addConverterFactory(kotlinxConverterFactory)
            .client(client)
            .build()
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(
        loggingInterceptor: HttpLoggingInterceptor,
        apiHeaderInterceptor: ApiHeaderInterceptor
    ): OkHttpClient {
        // This setup is for dev builds
        //TODO production setup needs to be done
        return OkHttpClient.Builder()
            .writeTimeout(90, TimeUnit.SECONDS)
            .readTimeout(90, TimeUnit.SECONDS)
            .connectTimeout(90, TimeUnit.SECONDS)
            .addInterceptor(loggingInterceptor)
            .addInterceptor(apiHeaderInterceptor)
            .build()
    }

    @Provides
    @Singleton
    internal fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return interceptor
    }
}