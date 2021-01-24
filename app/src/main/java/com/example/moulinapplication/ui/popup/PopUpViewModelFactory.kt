package com.example.moulinapplication.ui.popup

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.moulinapplication.repositories.JokeRepo
import com.example.moulinapplication.ui.home.AddJokeFragmentViewModel
import java.lang.IllegalArgumentException

class PopUpViewModelFactory(private val jokerepo: JokeRepo) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(PopUpFragmentViewModel::class.java)){
            return PopUpFragmentViewModel(jokerepo) as T
        }
        throw IllegalArgumentException("unknown viewmodelclass")
    }
}