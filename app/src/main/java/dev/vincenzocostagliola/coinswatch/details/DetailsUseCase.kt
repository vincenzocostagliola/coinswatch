package dev.vincenzocostagliola.coinswatch.details

import androidx.compose.ui.text.intl.Locale
import dev.vincenzocostagliola.data.domain.CoinData
import dev.vincenzocostagliola.data.domain.CoinData.Image
import dev.vincenzocostagliola.data.domain.CoinHistoricalData
import dev.vincenzocostagliola.data.domain.result.GetCoinDataResult
import dev.vincenzocostagliola.data.domain.result.GetCoinDataResult.Failure
import dev.vincenzocostagliola.data.domain.result.GetCoinHistoricalDataResult
import dev.vincenzocostagliola.data.error.CoinSwatchError
import dev.vincenzocostagliola.data.error.ErrorManagement
import dev.vincenzocostagliola.data.net.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.zip
import timber.log.Timber
import javax.inject.Inject

sealed class CoinDataWithHistoryResult {

    data class CoinDataWithHistory(
        val history: CoinHistoricalData,
        val marketCapRank: Int,
        val name: String,
        val id: String,
        val image: Image,
        val description: String
    ) : CoinDataWithHistoryResult()

    data class Error(val error: CoinSwatchError) : CoinDataWithHistoryResult()
}

internal class DetailsUseCase @Inject constructor(
    private val repository: Repository,
    private val errorManagement: ErrorManagement
) {

    suspend fun getCoinDataWithHistory(
        coinId: String,
        currency: String,
        days: Int
    ): Flow<CoinDataWithHistoryResult> {
        return getCoinData(coinId).zip(
            getCoinHistory(
                coinId = coinId,
                currency = currency,
                days = days
            )
        ) { coinData, coinHistory ->
            when (coinData is GetCoinDataResult.Success
                    && coinHistory is GetCoinHistoricalDataResult.Success) {
                true -> manageSuccess(coinHistory, coinData)
                false -> manageFailure(coinHistory, coinData)
            }
        }.catch { e ->
            val error = errorManagement.manageException(e)
            CoinDataWithHistoryResult.Error(error)
        }
    }

    private fun manageSuccess(
        coinHistory: GetCoinHistoricalDataResult.Success,
        coinData: GetCoinDataResult.Success
    ): CoinDataWithHistoryResult.CoinDataWithHistory =
        CoinDataWithHistoryResult.CoinDataWithHistory(
            history = coinHistory.coinData,
            marketCapRank = coinData.coinData.marketCapRank,
            name = coinData.coinData.name,
            id = coinData.coinData.id,
            image = coinData.coinData.image,
            description = coinData.coinData.description.getLocalized()
        )

    private fun manageFailure(
        coinHistory: GetCoinHistoricalDataResult,
        coinData: GetCoinDataResult
    ): CoinDataWithHistoryResult.Error = when {
        coinHistory is GetCoinHistoricalDataResult.Failure -> {
            Timber.e("getCoinDataWithHistory - coinHistory.error: ${coinHistory.error}")
            CoinDataWithHistoryResult.Error(coinHistory.error)
        }

        coinData is Failure -> {
            Timber.e("getCoinDataWithHistory - coinData.error: ${coinData.error}")
            CoinDataWithHistoryResult.Error(coinData.error)
        }

        else -> {
            Timber.e("getCoinDataWithHistory - generic error")
            CoinDataWithHistoryResult.Error(CoinSwatchError.GenericError)
        }
    }


    private suspend fun getCoinData(coinId: String): Flow<GetCoinDataResult> {
        return repository.getCoinData(coinId).flowOn(Dispatchers.IO)
    }

    private suspend fun getCoinHistory(
        coinId: String,
        currency: String,
        days: Int
    ): Flow<GetCoinHistoricalDataResult> {
        return repository.getCoinHistoricalData(
            coinId = coinId,
            currency = currency,
            days = days
        ).flowOn(Dispatchers.IO)
    }
}

private fun CoinData.Description.getLocalized(): String {
    val currentLocale = Locale.current
    Timber.d("Locale - current Locale: $currentLocale")
    //TODO Improve locale mapping
    return when (currentLocale.language) {
        "it" -> this.it
        else -> this.en
    }
}
