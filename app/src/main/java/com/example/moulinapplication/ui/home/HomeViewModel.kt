package com.example.moulinapplication.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moulinapplication.model.Joke
import com.example.moulinapplication.network.RetrofitBuilder
import com.example.moulinapplication.repositories.JokeRepo
import com.example.moulinapplication.roomdb.JokeDao
import com.example.moulinapplication.roomdb.RoomDB
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.launch
import retrofit2.Retrofit



class HomeViewModel(private val jokeRepo: JokeRepo): ViewModel() {


    private var _joke = MutableLiveData<Joke>()
    val joke : LiveData<Joke>
        get() = _joke;
  


    init {
        viewModelScope.launch{
            getJoke()
        }
    }

    suspend fun getJoke() {
        viewModelScope.launch {
            _joke.value=jokeRepo.fetchjoke()
        }
    }




}