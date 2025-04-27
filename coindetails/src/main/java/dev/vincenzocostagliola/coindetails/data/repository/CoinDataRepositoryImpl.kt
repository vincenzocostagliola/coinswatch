package dev.vincenzocostagliola.coindetails.data.repository

import com.skydoves.sandwich.suspendOnError
import com.skydoves.sandwich.suspendOnException
import com.skydoves.sandwich.suspendOnSuccess
import dev.vincenzocostagliola.coindetails.data.domain.result.GetCoinDataResult
import dev.vincenzocostagliola.coindetails.data.domain.result.GetCoinHistoricalDataResult
import dev.vincenzocostagliola.coindetails.data.service.CoinDataService
import dev.vincenzocostagliola.data.error.ErrorManagement
import dev.vincenzocostagliola.data.error.logErrorBasedOnCode
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import timber.log.Timber

internal class CoinDataRepositoryImpl(
    private val coinDataService: CoinDataService,
    private val errorManagement: ErrorManagement
) : CoinDataRepository {

    override suspend fun getCoinData(coinId: String): Flow<GetCoinDataResult> {
        return flow {
            val response = coinDataService.getCoinData(coinId)

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
            val response = coinDataService.getCoinHistoricalData(
                coinId = coinId,
                currency = currency,
                days = days
            )

            response.suspendOnSuccess {
                Timber.d("Response success: $data")
                emit(GetCoinHistoricalDataResult.Success(data.toDomain()))
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