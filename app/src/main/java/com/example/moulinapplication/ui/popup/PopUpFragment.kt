package com.example.moulinapplication.ui.popup

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.example.moulinapplication.R

import com.example.moulinapplication.databinding.FragmentPopUpBinding
import com.example.moulinapplication.model.Joke
import com.example.moulinapplication.network.RetrofitBuilder
import com.example.moulinapplication.repositories.JokeRepo
import com.example.moulinapplication.roomdb.RoomDB
import timber.log.Timber


class PopUpFragment(private val selectedJoke : Joke) : DialogFragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        //init viewmodel
        val dao = RoomDB.getInstance(this.requireContext()).JokeDAO
        val jokerepo = JokeRepo(dao,RetrofitBuilder.jokeservice)
        val factory = PopUpViewModelFactory(jokerepo)
        val popupViewModel : PopUpFragmentViewModel = ViewModelProvider(this,factory).get(PopUpFragmentViewModel::class.java)

        //init binding
        val binding = FragmentPopUpBinding.inflate(inflater,container,false)

        //edit clicked
        binding.editjoke.setOnClickListener{
            //TODO
            //popupViewModel.deleteJoke(it)
            //popupViewModel.editJoke(selectedJoke)
            //this.dismiss()
        }


        //delete clicked
        binding.deletejoke.setOnClickListener {
            //TODO
            popupViewModel.deleteJoke(selectedJoke)
            this.dismiss()
        }

        return binding.root
    }
}