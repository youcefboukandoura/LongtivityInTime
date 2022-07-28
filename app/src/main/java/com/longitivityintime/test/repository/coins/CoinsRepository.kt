package com.longitivityintime.test.repository.coins

import com.longitivityintime.test.database.AppDatabase
import com.longitivityintime.test.database.CoinEntity
import com.longitivityintime.test.database.asDomainModel
import com.longitivityintime.test.network.CoinsApi
import com.longitivityintime.test.network.model.Coin
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import timber.log.Timber
import javax.inject.Inject

class CoinsRepository @Inject constructor(
    private val coinsApi: CoinsApi,
    private val appDatabase: AppDatabase
) {

    val coins: Flow<List<Coin>?> =
        appDatabase.coinsDao.getCoins().map { it?.asDomainModel() }

    suspend fun refreshCoins() = try {
        val coins = coinsApi.getCoins()
        appDatabase.coinsDao.insertCoins(coins.map { it.toCoinEntity() })
        CoinsState.Success(coins)
    } catch (e: Exception) {
        Timber.w(e)
        CoinsState.Error(e.message ?: "")
    }

    private fun Coin.toCoinEntity() = CoinEntity(id, symbol, name)
}
