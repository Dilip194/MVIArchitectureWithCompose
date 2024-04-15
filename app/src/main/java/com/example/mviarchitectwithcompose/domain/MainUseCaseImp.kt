package com.example.hiltwithroomdatabase.domain

import com.example.hiltwithroomdatabase.data.MainDataModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MainUseCaseImp @Inject constructor(val apiService: APIService) {

    suspend fun getAllPost() = flow {
        emit(apiService.getAllPost())
    }
}