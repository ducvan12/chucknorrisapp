package com.example.moulinapplication.repositories

import com.example.moulinapplication.network.RetrofitBuilder
import com.example.moulinapplication.network.services.JokeService
import com.example.moulinapplication.model.Joke
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class JokeRepo {

    var JokeService : JokeService = RetrofitBuilder.jokeservice


    lateinit var Joke : Joke


    suspend fun fetchjoke() : Joke {
        withContext(Dispatchers.IO){
            Joke = JokeService.getjoke();
        }
        return Joke
    }
}