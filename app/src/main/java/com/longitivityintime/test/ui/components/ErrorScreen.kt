package com.longitivityintime.test.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ErrorScreen(error: String) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
            .padding(horizontal = 32.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
//            Icon(
//                modifier = Modifier
//                    .size(100.dp)
//                    .padding(bottom = 16.dp),
//                painter = painterResource(R.drawable.ic_offline),
//                tint = MaterialTheme.colors.primary,
//                contentDescription = null
//            )
            Text(
                text = error,
                color = MaterialTheme.colors.onBackground
            )
        }
    }
}
