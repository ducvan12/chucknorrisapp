package com.example.moulinapplication.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.moulinapplication.repositories.JokeRepo

class DashboardViewModel(private val repo: JokeRepo) : ViewModel() {

    val jokes = repo.jokes


}