package io.github.viniciusalvesmello.shared.repository.user

import io.github.viniciusalvesmello.shared.database.entity.User

interface UserRepository {
    fun getAll(): List<User>
    fun loadAllByIds(userIds: IntArray): List<User>
    suspend fun insertAll(vararg users: User)
    suspend fun delete(user: User)
}