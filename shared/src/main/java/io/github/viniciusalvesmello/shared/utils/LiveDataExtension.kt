package io.github.viniciusalvesmello.shared.utils

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

val <T> LiveData<T>.asMutable: MutableLiveData<T>
    get() = this as? MutableLiveData<T>
        ?: throw IllegalStateException("$this isn't a valid MutableLiveData")

fun <T> LifecycleOwner.observe(liveData: LiveData<T>, action: (t: T) -> Unit) {
    liveData.observe(this, androidx.lifecycle.Observer { it?.let { action(it) } })
}