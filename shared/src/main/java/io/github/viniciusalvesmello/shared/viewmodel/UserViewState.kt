package io.github.viniciusalvesmello.shared.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.github.viniciusalvesmello.shared.viewmodel.model.User

data class UserViewState(
    var loading: LiveData<Boolean> = MutableLiveData(),
    var users: LiveData<List<User>> = MutableLiveData(),
    var error: LiveData<Throwable> = MutableLiveData()
)