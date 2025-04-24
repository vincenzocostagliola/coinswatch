package dev.vincenzocostagliola.data.net.repository

import com.skydoves.sandwich.suspendOnError
import com.skydoves.sandwich.suspendOnException
import com.skydoves.sandwich.suspendOnSuccess
import dev.vincenzocostagliola.data.domain.result.GetCoinDataResult
import dev.vincenzocostagliola.data.domain.result.GetCoinHistoricalDataResult
import dev.vincenzocostagliola.data.error.ErrorManagement
import dev.vincenzocostagliola.data.domain.result.GetCoinsResult
import dev.vincenzocostagliola.data.error.logErrorBasedOnCode
import dev.vincenzocostagliola.data.net.service.CoinsService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import timber.log.Timber

internal class RepositoryImpl(
    private val service: CoinsService,
    private val errorManagement: ErrorManagement
) : Repository {

    override suspend fun getCoinsWithMarketData(
        currency: String,
        howManyCoins: Int
    ): Flow<GetCoinsResult> {
        return flow {
            val response = service.getCoinsWithMarketData(currency)

            response.suspendOnSuccess {
                //TODO possibly save last update date and data in persistence
                // in order to show to the user meanwhile new updates are coming
                val neededCoins = data.sortedBy { coin -> coin.marketCapRank }.take(howManyCoins)
                emit(GetCoinsResult.Success(neededCoins.map { it.toDomain() }))
            }.suspendOnError {
                this.logErrorBasedOnCode(
                    netCallId = "getCoinsWithMarketData",
                    request = ""
                )
                val error = errorManagement.manageOnError(this)
                emit(GetCoinsResult.Failure(error))
            }.suspendOnException {
                Timber.e("error: ${this.throwable}")
                val error = errorManagement.manageOnException(this)
                emit(GetCoinsResult.Failure(error))
            }
        }
    }

    override suspend fun getCoinData(coinId: String): Flow<GetCoinDataResult> {
        return flow {
            val response = service.getCoinData(coinId)

            response.suspendOnSuccess {
                emit(GetCoinDataResult.Success(data.toDomain()))
            }.suspendOnError {
                this.logErrorBasedOnCode(
                    netCallId = "getCoinData",
                    request = ""
                )
                val error = errorManagement.manageOnError(this)
                emit(GetCoinDataResult.Failure(error))
            }.suspendOnException {
                Timber.e("error: ${this.throwable}")
                val error = errorManagement.manageOnException(this)
                emit(GetCoinDataResult.Failure(error))
            }
        }
    }

    override suspend fun getCoinHistoricalData(
        coinId: String,
        currency: String,
        days: Int
    ): Flow<GetCoinHistoricalDataResult> {
        return flow {
            val response = service.getCoinHistoricalData(
                coinId = coinId,
                currency = currency,
                days = days
            )

            response.suspendOnSuccess {
                emit(GetCoinHistoricalDataResult.Success(data.toDomain() ))
            }.suspendOnError {
                this.logErrorBasedOnCode(
                    netCallId = "getCoinHistoricalData",
                    request = ""
                )
                val error = errorManagement.manageOnError(this)
                emit(GetCoinHistoricalDataResult.Failure(error))
            }.suspendOnException {
                Timber.e("error: ${this.throwable}")
                val error = errorManagement.manageOnException(this)
                emit(GetCoinHistoricalDataResult.Failure(error))
            }
        }
    }
}