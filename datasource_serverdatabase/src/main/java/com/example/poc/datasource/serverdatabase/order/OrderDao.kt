package com.example.poc.datasource.serverdatabase.order

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.example.poc.datasource.serverdatabase.user.UserEntity
import kotlinx.coroutines.flow.Flow

@Dao
abstract class OrderDao {

    @Query("select * from OrderEntity where id = :id")
    abstract suspend fun get(id: Long): OrderEntity

    @Query("select * from OrderEntity where id = :id")
    abstract fun observe(id: Long): Flow<OrderEntity>

    @Insert(onConflict = REPLACE)
    abstract suspend fun insert(entity: OrderEntity): Long
}