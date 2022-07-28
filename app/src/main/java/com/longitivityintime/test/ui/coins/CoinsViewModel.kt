package com.longitivityintime.test.ui.coins

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.longitivityintime.test.repository.coins.CoinsRepository
import com.longitivityintime.test.repository.coins.CoinsState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoinsViewModel @Inject constructor(
    private val coinsRepository: CoinsRepository
) : ViewModel() {

    var uiModel by mutableStateOf(CoinsScreenUiModel())
        private set

    init {
        refresh()
    }

    fun getCoins() {
        viewModelScope.launch(Dispatchers.IO) {
            uiModel = when (val state = coinsRepository.refreshCoins()) {
                is CoinsState.Error -> uiModel.copy(
                    showProgressBar = false,
                    error = state.error
                )
                is CoinsState.Success -> uiModel.copy(
                    showProgressBar = false,
                    list = state.coins
                )
            }
        }
    }

    fun refresh() {
        uiModel = uiModel.copy(list = emptyList(), showProgressBar = true)
        getCoins()
    }
}
