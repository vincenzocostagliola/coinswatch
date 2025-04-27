package dev.vincenzocostagliola.home.data.repository

import com.skydoves.sandwich.suspendOnError
import com.skydoves.sandwich.suspendOnException
import com.skydoves.sandwich.suspendOnSuccess
import dev.vincenzocostagliola.data.error.ErrorManagement
import dev.vincenzocostagliola.data.error.logErrorBasedOnCode
import dev.vincenzocostagliola.home.data.domain.result.GetCoinsResult
import dev.vincenzocostagliola.home.data.service.CoinsService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import timber.log.Timber

internal class RepositoryImpl(
    private val coinsService: CoinsService,
    private val errorManagement: ErrorManagement
) : Repository {

    override suspend fun getCoinsWithMarketData(
        currency: String,
        howManyCoins: Int
    ): Flow<GetCoinsResult> {
        return flow {
            val response = coinsService.getCoinsWithMarketData(currency)

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
}