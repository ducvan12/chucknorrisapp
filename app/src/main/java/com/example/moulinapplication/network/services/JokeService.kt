package com.example.moulinapplication.network.services

import com.example.moulinapplication.model.Joke
import retrofit2.http.GET

interface JokeService {


    @GET("/random_joke")
    suspend fun getjoke() : Joke



}