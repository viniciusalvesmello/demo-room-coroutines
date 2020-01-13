package io.github.viniciusalvesmello.shared.database

import androidx.room.Database
import androidx.room.RoomDatabase
import io.github.viniciusalvesmello.shared.database.dao.UserDao
import io.github.viniciusalvesmello.shared.database.model.UserEntity

@Database(entities = [UserEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}