package com.longitivityintime.test.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.longitivityintime.test.network.model.Coin

@Entity
data class CoinEntity constructor(
    @PrimaryKey
    val id: String,
    val symbol: String,
    val name: String
)

fun List<CoinEntity>.asDomainModel(): List<Coin> {
    return map {
        Coin(
            id = it.id,
            symbol = it.symbol,
            name = it.name
        )
    }
}
