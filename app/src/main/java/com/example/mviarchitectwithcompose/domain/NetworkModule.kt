package com.example.hiltwithroomdatabase.domain

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import com.example.hiltwithroomdatabase.utils.Constants.Companion.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@InstallIn(ApplicationContext::class)
@Module
class NetworkModule {

    @Singleton
    @Provides
    fun provideClient() : OkHttpClient{
        return OkHttpClient().newBuilder().build()
    }

    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient) : Retrofit{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideAPIService(retrofit: Retrofit) = retrofit.create(APIService::class.java)

}