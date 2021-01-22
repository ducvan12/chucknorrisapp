package com.example.moulinapplication.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moulinapplication.repositories.JokeRepo
import com.example.moulinapplication.model.Joke
import kotlinx.coroutines.launch


class HomeViewModel : ViewModel() {


    var jokeRepo: JokeRepo

    private var _Joke = MutableLiveData<Joke>()
    val Joke : LiveData<Joke>
        get() = _Joke;
  


    init {
        jokeRepo = JokeRepo()
        viewModelScope.launch{
            getjoke()
        }
    }

    suspend fun getjoke() {
        viewModelScope.launch {
            _Joke.value=jokeRepo.fetchjoke()
        }

    }

}