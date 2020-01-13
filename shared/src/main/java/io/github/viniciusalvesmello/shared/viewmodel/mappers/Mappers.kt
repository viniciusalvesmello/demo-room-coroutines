package io.github.viniciusalvesmello.shared.viewmodel.mappers

import io.github.viniciusalvesmello.shared.repository.user.model.UserData
import io.github.viniciusalvesmello.shared.viewmodel.model.User


fun UserData.toUser(): User =
    User(
        uid = uid,
        email = email,
        name = name
    )

fun List<UserData>.toListUser(): List<User> =
    this.map {
        it.toUser()
    }

fun User.toUserData(): UserData =
    UserData(
        uid = uid,
        email = email,
        name = name
    )

fun List<User>.toListUserData(): List<UserData> =
    this.map {
        it.toUserData()
    }