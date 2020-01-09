package io.github.viniciusalvesmello.shared.database.di

import androidx.room.Room
import io.github.viniciusalvesmello.shared.database.AppDatabase
import org.koin.dsl.module

class DatabaseModule {
    companion object {
        fun get() = module {
    
            single {
                Room.databaseBuilder(
                    get(),
                    AppDatabase::class.java,
                    DATABASE_NAME
                ).build()
            }
        }
        
        private const val DATABASE_NAME = "demo-room-coroutines"
    }
}