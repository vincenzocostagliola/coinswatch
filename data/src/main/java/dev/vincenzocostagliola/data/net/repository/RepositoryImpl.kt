package dev.vincenzocostagliola.data.net.repository

import com.skydoves.sandwich.suspendOnError
import com.skydoves.sandwich.suspendOnException
import com.skydoves.sandwich.suspendOnSuccess
import dev.vincenzocostagliola.data.domain.result.GetCoinsResult
import dev.vincenzocostagliola.data.net.service.CoinsService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

internal class RepositoryImpl(
    private val service: CoinsService
) : Repository {

    override suspend fun getCoinsWithMarketData(currency: String, howManyCoins: Int): Flow<GetCoinsResult> {
        return flow {
            val response = service.getCoinsWithMarketData(currency)

            response.suspendOnSuccess {
                //TODO possibly save last update date and data in persistence
                // in order to show to the user meanwhile new updates are coming
                val neededCoins = data.sortedBy { coin -> coin.marketCapRank }.take(howManyCoins)
                emit(GetCoinsResult.Success(neededCoins.map { it.toDomain() }))
            }.suspendOnError {
                emit()
            }.suspendOnException {
                emit()
            }
        }
    }
}