package com.longitivityintime.test.network

import com.longitivityintime.test.network.model.Coin
import retrofit2.http.GET

interface CoinsApi {

    @GET("/api/v3/coins/list")
    suspend fun getCoins(): List<Coin>
}
