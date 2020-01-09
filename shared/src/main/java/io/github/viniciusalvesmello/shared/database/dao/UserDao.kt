package io.github.viniciusalvesmello.shared.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import io.github.viniciusalvesmello.shared.database.entity.User
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    
    @Query("SELECT * FROM user")
    fun getAll(): Flow<List<User>>
    
    @Query("SELECT * FROM user WHERE uid IN (:userIds)")
    fun loadAllByIds(userIds: IntArray): Flow<List<User>>
    
    @Insert
    suspend fun insertAll(vararg users: User)
    
    @Delete
    suspend fun delete(user: User)
}