package com.example.moulinapplication.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.moulinapplication.repositories.JokeRepo
import java.lang.IllegalArgumentException

class AddJokeFragmentViewModelFactory(private val jokerepo: JokeRepo) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AddJokeFragmentViewModel::class.java)) {
            return AddJokeFragmentViewModel(jokerepo) as T
        }
        throw IllegalArgumentException("unknown viewmodelclass")
    }
}
