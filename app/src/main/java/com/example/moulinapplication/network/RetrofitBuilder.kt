package com.example.moulinapplication.network

import com.example.moulinapplication.network.services.JokeService

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitBuilder {
    companion object{
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.chucknorris.io/")
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val jokeservice = retrofit.create(JokeService::class.java);


    }


}
