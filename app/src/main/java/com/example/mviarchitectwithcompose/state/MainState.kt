package com.example.hiltwithroomdatabase.state

import com.example.hiltwithroomdatabase.data.MainDataModel
import kotlinx.coroutines.flow.Flow

sealed class MainState {
    object Idle : MainState()
    object Loading : MainState()
    data class Error(val error: String? = null) : MainState()
    data class Success(val data: Flow<List<MainDataModel>>) : MainState()
}