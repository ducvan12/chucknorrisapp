package com.example.moulinapplication.network

import com.example.moulinapplication.network.services.JokeService
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitBuilder {
    /**
     * companion object for retrofit connection with api
     * with jokeservice property for the api calls
     */
    companion object {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://official-joke-api.appspot.com")
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val jokeservice = retrofit.create(JokeService::class.java)
    }
}
