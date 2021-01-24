package com.example.moulinapplication.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moulinapplication.model.Joke
import com.example.moulinapplication.repositories.JokeRepo
import kotlinx.coroutines.launch

class DashboardViewModel(private val repo: JokeRepo) : ViewModel() {

    val jokes = repo.jokes

    fun editJoke(joke: Joke){
        viewModelScope.launch {
            repo.updateJoke(joke)
        }
    }

    fun deleteJoke(joke: Joke){
        viewModelScope.launch {
            repo.deleteJoke(joke)
        }
    }

}