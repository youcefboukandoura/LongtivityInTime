package com.longitivityintime.test.network.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class Coin(
    @Json(name = "id")
    val id: String,
    @Json(name = "symbol")
    val symbol: String,
    @Json(name = "name")
    val name: String
)
