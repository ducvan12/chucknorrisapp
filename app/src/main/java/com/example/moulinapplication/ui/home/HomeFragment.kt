package com.example.moulinapplication.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isInvisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import com.example.moulinapplication.databinding.FragmentHomeBinding
import com.example.moulinapplication.model.Joke
import com.example.moulinapplication.network.RetrofitBuilder
import com.example.moulinapplication.repositories.JokeRepo
import com.example.moulinapplication.roomdb.JokeDao
import com.example.moulinapplication.roomdb.RoomDB
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private lateinit var currentJoke: Joke
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // viewmodel init
        val dao: JokeDao = RoomDB.getInstance(requireContext()).JokeDAO
        val jokerepo = JokeRepo(dao, RetrofitBuilder.jokeservice)
        val factory = HomeViewModelFactory(jokerepo)
        homeViewModel = ViewModelProvider(this, factory).get(HomeViewModel::class.java)

        // binding init
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this

        // joke observeren van viewmodel
        homeViewModel.joke.observe(
            viewLifecycleOwner,
            { it ->
                binding.loading.visibility = View.INVISIBLE
                binding.joke = it
                currentJoke = it
                binding.punchlinetext.visibility = View.INVISIBLE // hidden punchline
                binding.punchlinetext.text = it.punchline
            }
        )

        // button voor nieuw vraag te zetten
        binding.jokebutton.setOnClickListener {
            lifecycleScope.launch {
                homeViewModel.getJoke()
                binding.loading.visibility = View.VISIBLE // loading icon
            }
        }

        // punchline visible maken
        binding.punchbutton.setOnClickListener {
            binding.punchlinetext.visibility = View.VISIBLE
        }

        // button voor add to favourites
        binding.addbutton.setOnClickListener {
            if (binding.punchlinetext.isInvisible) {
                Toast.makeText(
                    this.requireContext(),
                    "You must punch it before you can add it.",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                val action =
                    HomeFragmentDirections.actionNavigationHomeToAddJokeFragment(currentJoke)
                val navigator = view?.findNavController()
                navigator?.navigate(action)
            }
        }

        return binding.root
    }
}
