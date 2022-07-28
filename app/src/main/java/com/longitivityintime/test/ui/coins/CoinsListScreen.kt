package com.longitivityintime.test.ui.coins

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import com.longitivityintime.test.network.model.Coin
import com.longitivityintime.test.ui.components.ErrorScreen

@Composable
fun CoinsListScreen(
    onClickRow: (String) -> Unit = {}
) {
    val viewModel = hiltViewModel<CoinsViewModel>()
    val uiModelState = viewModel.uiModel

    when {
        uiModelState.error.isNotEmpty() -> ErrorScreen(uiModelState.error)
        else -> CoinsList(uiModelState, viewModel, onClickRow)
    }
}

@Composable
private fun CoinsList(
    uiModelState: CoinsScreenUiModel,
    viewModel: CoinsViewModel,
    onClickRow: (String) -> Unit
) {
    SwipeRefresh(
        state = rememberSwipeRefreshState(uiModelState.showProgressBar),
        onRefresh = { viewModel.refresh() }
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
                .background(MaterialTheme.colors.background)
        ) {
            items(uiModelState.list) { item ->
                CoinItem(item = item, onClickRow = onClickRow)
            }
        }
    }
}

@Composable
fun CoinItem(item: Coin, onClickRow: (String) -> Unit) {
    Card(backgroundColor = Color.Gray, modifier = Modifier.padding(vertical = 8.dp)) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { onClickRow(item.name) }
                .padding(16.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                modifier = Modifier.padding(start = 8.dp),
                text = item.name,
                color = MaterialTheme.colors.onBackground
            )
            Text(
                modifier = Modifier.padding(start = 16.dp),
                text = item.symbol,
                color = MaterialTheme.colors.onBackground
            )
        }
    }
}
