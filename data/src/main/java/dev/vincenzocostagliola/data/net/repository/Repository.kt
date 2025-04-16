package dev.vincenzocostagliola.data.net.repository

import dev.vincenzocostagliola.data.domain.result.GetCoinsResult
import kotlinx.coroutines.flow.Flow

interface Repository {
    suspend fun getCoinsWithMarketData(currency: String): Flow<GetCoinsResult>
}