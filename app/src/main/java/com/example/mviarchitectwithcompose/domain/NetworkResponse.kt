package com.example.hiltwithroomdatabase.domain

sealed class NetworkResponse<T>(val data : T? = null, val msg : String? = null) {
    class Idle<T> : NetworkResponse<T>()
    class Loading<T> : NetworkResponse<T>()
    class Error<T>(data: T? = null,msg: String? = null) : NetworkResponse<T>(data,msg)
    class Success<T>(data: T?) : NetworkResponse<T>(data)
}
