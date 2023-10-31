package com.example.recipeonboardingproject.common

sealed class DataResult<T> {
    class Success<T>(val data: T) : DataResult<T>()
    class Error<T>(val message: String) : DataResult<T>()
    class Loading<T> : DataResult<T>()
}