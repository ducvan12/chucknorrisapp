package com.example.moulinapplication.network.services

import com.example.moulinapplication.model.Joke
import retrofit2.http.GET

interface JokeService {

    /**
     * makes call to rest api
     *
     * @return a joke object
     */
    @GET("/random_joke")
    suspend fun getjoke(): Joke
}
