package com.longitivityintime.test.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.longitivityintime.test.ui.coins.CoinsListScreen
import com.longitivityintime.test.ui.theme.LongitivityInTimeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        println("screen")
        setContent {
            LongitivityInTimeTheme {
                CoinsListScreen()
            }
        }
    }
}
