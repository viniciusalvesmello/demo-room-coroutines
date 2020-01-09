package io.github.viniciusalvesmello.shared.repository.user.di

import io.github.viniciusalvesmello.shared.repository.user.UserRepository
import io.github.viniciusalvesmello.shared.repository.user.UserRepositoryImpl
import org.koin.dsl.module

class RepositoryUserModule {
    companion object {
        fun get() = module {
        
            single<UserRepository> {
                UserRepositoryImpl(get())
            }
        }
    }
}