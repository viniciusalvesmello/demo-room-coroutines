package io.github.viniciusalvesmello.shared.repository.user

import io.github.viniciusalvesmello.shared.database.AppDatabase
import io.github.viniciusalvesmello.shared.repository.user.mapper.toListUserData
import io.github.viniciusalvesmello.shared.repository.user.mapper.toListUserEntity
import io.github.viniciusalvesmello.shared.repository.user.mapper.toUserEntity
import io.github.viniciusalvesmello.shared.repository.user.model.UserData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class UserRepositoryImpl(appDatabase: AppDatabase) : UserRepository {

    private val userDao = appDatabase.userDao()

    override fun getAll(): Flow<List<UserData>> =
        userDao.getAll().map {
            it.toListUserData()
        }

    override fun loadAllByIds(userIds: IntArray): Flow<List<UserData>> =
        userDao.loadAllByIds(userIds).map {
            it.toListUserData()
        }

    override suspend fun insertAll(users: List<UserData>) {
        userDao.insertAll(users.toListUserEntity())
    }

    override suspend fun delete(user: UserData) {
        userDao.delete(user.toUserEntity())
    }

}