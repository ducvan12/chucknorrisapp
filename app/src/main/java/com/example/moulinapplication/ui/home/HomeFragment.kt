package com.example.moulinapplication.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.moulinapplication.MainActivity
import com.example.moulinapplication.databinding.FragmentHomeBinding
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        //viewmodel init
        homeViewModel =
                ViewModelProvider(this).get(HomeViewModel::class.java)

        //binding init
        val binding = FragmentHomeBinding.inflate(inflater,container,false)




        //eerste vraag zetten
        homeViewModel.joke.observe(viewLifecycleOwner, { it ->
            binding.joke = it
        })


        //button voor nieuw vraag te zetten
        binding.jokebutton.setOnClickListener {
            lifecycleScope.launch {
                homeViewModel.getJoke()
                homeViewModel.joke.observe(viewLifecycleOwner, { it ->
                    binding.joke = it
                })
            }
        }

        return binding.root
    }





}