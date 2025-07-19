package com.alpha.mywidgets

sealed class ApiResultState<out T> {
    data class Success<out T>(val data: T) : ApiResultState<T>()
    data class Error(val message: String, val throwable: Throwable? = null) :
        ApiResultState<Nothing>()

    data class Loading(val isLoading: Boolean?) : ApiResultState<Nothing>()
}