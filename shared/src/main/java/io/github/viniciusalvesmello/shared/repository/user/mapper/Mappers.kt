package io.github.viniciusalvesmello.shared.repository.user.mapper

import io.github.viniciusalvesmello.shared.database.model.UserEntity
import io.github.viniciusalvesmello.shared.repository.user.model.UserData

fun UserEntity.toUserData(): UserData =
    UserData(
        uid = uid,
        email = email,
        name = name
    )

fun List<UserEntity>.toListUserData(): List<UserData> =
    this.map {
        it.toUserData()
    }

fun UserData.toUserEntity(): UserEntity =
    UserEntity(
        uid = uid,
        email = email,
        name = name
    )

fun List<UserData>.toListUserEntity(): List<UserEntity> =
    this.map {
        it.toUserEntity()
    }