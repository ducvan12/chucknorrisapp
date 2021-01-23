package com.example.moulinapplication.roomdb

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.moulinapplication.model.Joke

@Dao
interface JokeDao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun instertJoke(joke: Joke)


    @Update
    suspend fun updateJoke(joke: Joke)


    @Delete
    suspend fun deleteJoke(joke: Joke)


    @Query(value = "DELETE FROM joke_data_table")
    suspend fun deleteAllJokes()



    @Query(value = "SELECT * FROM joke_data_table ORDER  BY joke_number_Of_Stars")
    fun getAllJokes():LiveData<List<Joke>>




}