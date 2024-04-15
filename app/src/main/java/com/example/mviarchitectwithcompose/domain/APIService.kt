package com.example.hiltwithroomdatabase.domain

import com.example.hiltwithroomdatabase.data.MainDataModel
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET

interface APIService {

    @GET("/posts")
    suspend fun getAllPost() : List<MainDataModel>
}