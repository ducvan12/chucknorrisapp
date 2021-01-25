package com.example.moulinapplication.repositories

import com.example.moulinapplication.model.Joke
import com.example.moulinapplication.network.services.JokeService
import com.example.moulinapplication.roomdb.JokeDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * Repository for jokes
 * controls jokedao for room
 * controls jokeservice for online api
 * @property jokedao
 * @property jokeservice
 */

class JokeRepo(private val jokedao: JokeDao, private val jokeservice: JokeService) {

    lateinit var joke: Joke
    val jokes = jokedao.getAllJokes()

    suspend fun fetchjoke(): Joke {
        withContext(Dispatchers.IO) {
            joke = jokeservice.getjoke()
        }
        return joke
    }

    suspend fun insertJoke(joke: Joke) {
        jokedao.instertJoke(joke)
    }

    suspend fun updateJoke(joke: Joke) {
        jokedao.updateJoke(joke)
    }
    suspend fun deleteJoke(joke: Joke) {
        jokedao.deleteJoke(joke)
    }
}
