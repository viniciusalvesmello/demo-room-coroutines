package io.github.viniciusalvesmello.demoroomcoroutines

import android.app.Application
import io.github.viniciusalvesmello.shared.database.di.DatabaseModule
import io.github.viniciusalvesmello.shared.repository.user.di.UserRepositoryModule
import io.github.viniciusalvesmello.shared.viewmodel.di.UserViewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class AppApplication : Application() {
    
    override fun onCreate() {
        super.onCreate()
        
        startKoin()
    }
    
    private fun startKoin() {
        startKoin {
            androidLogger()
            androidContext(this@AppApplication)
            modules(
                listOf(
                    DatabaseModule.get(),
                    UserRepositoryModule.get(),
                    UserViewModelModule.get()
                )
            )
        }
    }
}