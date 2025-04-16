package dev.vincenzocostagliola.data.net.repository

import dev.vincenzocostagliola.data.domain.result.GetCoinsResult
import dev.vincenzocostagliola.data.net.service.CoinsService
import kotlinx.coroutines.flow.Flow

internal class RepositoryImpl(
    private val coinsService: CoinsService
) : Repository {

    override suspend fun getCoinsWithMarketData(currency: String): Flow<GetCoinsResult>{

    }
}