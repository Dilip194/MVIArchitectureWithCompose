package com.example.hiltwithroomdatabase.composable

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.hiltwithroomdatabase.data.MainDataModel
import com.example.hiltwithroomdatabase.presenter.MainViewModel

@Composable
fun mainViewCompose() {

}

@Composable
fun loadListItems(item : List<MainDataModel>){
    val product = remember {}
    LazyColumn(contentPadding = PaddingValues(8.dp, vertical = 8.dp)){
        //items(item)
    }
}
