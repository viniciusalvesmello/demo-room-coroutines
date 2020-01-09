package io.github.viniciusalvesmello.shared.repository.user

import io.github.viniciusalvesmello.shared.database.AppDatabase
import io.github.viniciusalvesmello.shared.database.entity.User

class UserRepositoryImpl(private val appDatabase: AppDatabase) : UserRepository {
    
    override fun getAll(): List<User> {
        return emptyList()
    }
    
    override fun loadAllByIds(userIds: IntArray): List<User> {
        return emptyList()
    }
    
    override suspend fun insertAll(vararg users: User) {
    
    }
    
    override suspend fun delete(user: User) {
    
    }
    
}