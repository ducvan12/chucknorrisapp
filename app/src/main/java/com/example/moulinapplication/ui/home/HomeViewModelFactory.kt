package com.example.moulinapplication.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.moulinapplication.repositories.JokeRepo
import java.lang.IllegalArgumentException

class HomeViewModelFactory(private val jokeRepo: JokeRepo) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            return HomeViewModel(jokeRepo) as T
        }
        throw IllegalArgumentException("unknown viewmodelclass")
    }
}
