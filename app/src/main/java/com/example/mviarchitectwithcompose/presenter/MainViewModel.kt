package com.example.hiltwithroomdatabase.presenter

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hiltwithroomdatabase.domain.MainUseCaseImp
import com.example.hiltwithroomdatabase.intent.MainIntent
import com.example.hiltwithroomdatabase.state.MainState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.Channel.Factory.UNLIMITED
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(var mainUseCaseImp: MainUseCaseImp) : ViewModel() {

    var listIntent = Channel<MainIntent>(UNLIMITED)
    var detailsIntent = Channel<MainIntent>()

    var liststate  = mutableStateOf<MainState>(MainState.Idle)
    private set

    var details = mutableStateOf<MainState>(MainState.Idle)
    private set

    init {
        callListItems()
    }

    fun callListItems(){
        viewModelScope.launch {
            listIntent.consumeAsFlow().collect{ collect ->
             when (collect){
                 is MainIntent.FetchLIstItems -> {
                     fetchListItems()
                 }
             }
            }
        }
    }

    private fun fetchListItems() {
        viewModelScope.launch {
            liststate.value = MainState.Loading
            liststate.value = try {
                MainState.Success(mainUseCaseImp.getAllPost())
            }catch (e : Exception){
                MainState.Error(e.message)
            }
        }
    }
}