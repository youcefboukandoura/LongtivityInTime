package com.longitivityintime.test.database

import androidx.room.Dao
import androidx.room.Database
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.RoomDatabase
import kotlinx.coroutines.flow.Flow

@Dao
interface CoinsDao {

    @Query("select * from CoinEntity")
    fun getCoins(): Flow<List<CoinEntity>?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCoins(coins: List<CoinEntity>)
}

@Database(entities = [CoinEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract val coinsDao: CoinsDao
}
