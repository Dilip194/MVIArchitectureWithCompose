package com.example.mviarchitectwithcompose.presenter

import android.arch.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.lifecycleScope
import com.example.hiltwithroomdatabase.intent.MainIntent
import com.example.hiltwithroomdatabase.presenter.MainViewModel
import com.example.hiltwithroomdatabase.state.MainState
import com.example.mviarchitectwithcompose.ui.theme.MVIArchitectWithComposeTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    //private val mainViewModel :  MainViewModel by viewModels()
    private lateinit var mainViewModel : MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MVIArchitectWithComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("Android")
                    DefaultPreview()
                }
            }
        }
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
    }

    fun fetch(){
        lifecycleScope.launch {
            mainViewModel.listIntent.send(MainIntent.FetchLIstItems)
        }
    }
}


@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MVIArchitectWithComposeTheme {
        Greeting("Android")
    }
}