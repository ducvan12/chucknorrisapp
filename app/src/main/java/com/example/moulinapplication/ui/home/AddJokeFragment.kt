package com.example.moulinapplication.ui.home


import android.os.Bundle
import android.view.LayoutInflater

import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.example.moulinapplication.MainActivity

import com.example.moulinapplication.databinding.FragmentAddJokeBinding
import com.example.moulinapplication.model.Joke
import com.example.moulinapplication.network.RetrofitBuilder
import com.example.moulinapplication.repositories.JokeRepo
import com.example.moulinapplication.roomdb.JokeDao
import com.example.moulinapplication.roomdb.RoomDB
import timber.log.Timber


class AddJokeFragment : Fragment() {

    private lateinit var addJokeFragmentViewModel: AddJokeFragmentViewModel
    val args : AddJokeFragmentArgs by navArgs() //args from actions


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

        //set overview chosen joke
        binding.jokesetup.text=args.chosenJoke.setup
        binding.jokepunchline.text=args.chosenJoke.punchline





        return binding.root
    }



    //add joke to favourites
    fun addJokeToFavourite(joke: Joke){
        addJokeFragmentViewModel.insertJoke(joke)
    }

}