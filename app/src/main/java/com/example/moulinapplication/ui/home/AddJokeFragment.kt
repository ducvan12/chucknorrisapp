package com.example.moulinapplication.ui.home


import android.os.Bundle
import android.view.LayoutInflater

import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.moulinapplication.MainActivity

import com.example.moulinapplication.databinding.FragmentAddJokeBinding
import com.example.moulinapplication.model.Joke
import com.example.moulinapplication.network.RetrofitBuilder
import com.example.moulinapplication.repositories.JokeRepo
import com.example.moulinapplication.roomdb.JokeDao
import com.example.moulinapplication.roomdb.RoomDB


class AddJokeFragment : Fragment() {

    private lateinit var addJokeFragmentViewModel: AddJokeFragmentViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        //binding init
        val binding = FragmentAddJokeBinding.inflate(inflater, container, false)

        //init repo and viewmodel

        val dao : JokeDao = RoomDB.getInstance(requireContext()).JokeDAO
        val jokerepo = JokeRepo(dao,RetrofitBuilder.jokeservice)
        val factory = AddJokeFragmentViewModelFactory(jokerepo)
        val addJokeFragmentViewModel = ViewModelProvider(this,factory).get(AddJokeFragmentViewModel::class.java)


        return binding.root
    }




}