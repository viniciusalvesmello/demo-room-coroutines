package io.github.viniciusalvesmello.shared.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.github.viniciusalvesmello.shared.repository.user.UserRepository
import io.github.viniciusalvesmello.shared.utils.execute
import io.github.viniciusalvesmello.shared.viewmodel.mappers.toListUser
import io.github.viniciusalvesmello.shared.viewmodel.mappers.toUserData
import io.github.viniciusalvesmello.shared.viewmodel.model.User
import kotlinx.coroutines.launch

class UserViewModel(private val repository: UserRepository) : ViewModel() {

    private var loading = MutableLiveData<Boolean>()
    private var users = MutableLiveData<List<User>>()
    private var error = MutableLiveData<Throwable>()

    val viewState = UserViewState(loading, users, error)

    fun getAll() {
        viewModelScope.launch {
            repository.getAll().execute({
                loading.postValue(true)
            }, {
                loading.postValue(false)
                users.postValue(it.toListUser())
            }, {
                loading.postValue(false)
                error.postValue(it)
            })
        }
    }

    fun insert(email: String, name: String) {
        viewModelScope.launch {
            try {
                repository.insertAll(
                    mutableListOf<User>().apply {
                        add(User(0, email, name))
                    }.map {
                        it.toUserData()
                    }
                )
                getAll()
            } catch (t: Throwable) {
                error.postValue(t)
            }
        }
    }
}