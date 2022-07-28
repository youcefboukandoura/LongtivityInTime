package com.longitivityintime.test.ui.coins

import com.longitivityintime.test.network.model.Coin

data class CoinsScreenUiModel(
    val list: List<Coin> = listOf(),
    val showProgressBar: Boolean = true,
    val error: String = ""
)
