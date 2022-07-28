package com.longitivityintime.test.repository.coins

import com.longitivityintime.test.network.model.Coin

sealed class CoinsState {
    data class Success(val coins: List<Coin>) : CoinsState()

    data class Error(val error: String) : CoinsState()
}
