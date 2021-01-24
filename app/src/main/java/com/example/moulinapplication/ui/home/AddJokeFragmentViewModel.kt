package com.example.moulinapplication.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moulinapplication.model.Joke
import com.example.moulinapplication.repositories.JokeRepo
import kotlinx.coroutines.launch

class AddJokeFragmentViewModel(private val jokerepo: JokeRepo) : ViewModel() {


    val jokes = jokerepo.jokes

    fun insertJoke(joke : Joke){
        viewModelScope.launch {
            jokerepo.insertJoke(joke)
        }
    }


}