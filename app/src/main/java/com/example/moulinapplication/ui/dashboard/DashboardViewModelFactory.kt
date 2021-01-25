package com.example.moulinapplication.ui.dashboard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.moulinapplication.repositories.JokeRepo
import java.lang.IllegalArgumentException

class DashboardViewModelFactory(private val jokerepo: JokeRepo) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DashboardViewModel::class.java)) {
            return DashboardViewModel(jokerepo) as T
        }
        throw IllegalArgumentException("unknown viewmodelclass")
    }
}
