package io.github.viniciusalvesmello.shared.repository.user

import io.github.viniciusalvesmello.shared.repository.user.model.UserData
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    fun getAll(): Flow<List<UserData>>
    fun loadAllByIds(userIds: IntArray): Flow<List<UserData>>
    suspend fun insertAll(users: List<UserData>)
    suspend fun delete(user: UserData)
}