package io.github.viniciusalvesmello.shared.utils

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect

suspend fun <T> Flow<T>.execute(
    onStart: () -> Unit,
    onSuccess: (T) -> Unit,
    onError: (Throwable) -> Unit
) {
    onStart()
    try {
        this.collect {
            onSuccess(it)
        }
    } catch (t: Throwable) {
        onError(t)
    }
}