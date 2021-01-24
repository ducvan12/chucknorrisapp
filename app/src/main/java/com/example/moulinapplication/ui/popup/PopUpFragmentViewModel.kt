package com.example.moulinapplication.ui.popup

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moulinapplication.model.Joke
import com.example.moulinapplication.repositories.JokeRepo
import kotlinx.coroutines.launch

class PopUpFragmentViewModel(private val repo : JokeRepo): ViewModel() {


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