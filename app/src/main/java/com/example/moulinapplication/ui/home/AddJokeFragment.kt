package com.example.moulinapplication.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.example.moulinapplication.databinding.FragmentAddJokeBinding
import com.example.moulinapplication.model.Joke
import com.example.moulinapplication.network.RetrofitBuilder
import com.example.moulinapplication.repositories.JokeRepo
import com.example.moulinapplication.roomdb.JokeDao
import com.example.moulinapplication.roomdb.RoomDB

class AddJokeFragment : Fragment() {

    private lateinit var addJokeFragmentViewModel: AddJokeFragmentViewModel
    val args: AddJokeFragmentArgs by navArgs() // args from actions
    lateinit var binding: FragmentAddJokeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // binding init
        binding = FragmentAddJokeBinding.inflate(inflater, container, false)

        // init repo and viewmodel
        val dao: JokeDao = RoomDB.getInstance(requireContext()).JokeDAO
        val jokerepo = JokeRepo(dao, RetrofitBuilder.jokeservice)
        val factory = AddJokeFragmentViewModelFactory(jokerepo)
        addJokeFragmentViewModel = ViewModelProvider(this, factory).get(AddJokeFragmentViewModel::class.java)

        // set overview chosen joke
        binding.jokesetup.text = args.chosenJoke.setup
        binding.jokepunchline.text = args.chosenJoke.punchline

        // set actie wanneer add button is geklikt naar favorieten sturen
        binding.addbutton.setOnClickListener {
            val temp = args.chosenJoke
            temp.numberOfStars = binding.ratingbar.rating
            addJokeToFavourite(temp)
            val action = AddJokeFragmentDirections.actionAddJokeFragmentToNavigationDashboard()
            val navigator = view?.findNavController()
            navigator?.navigate(action)
            Toast.makeText(this.context, "Joke is added successfully", Toast.LENGTH_SHORT).show()
        }

        return binding.root
    }

    // add joke to favourites
    fun addJokeToFavourite(joke: Joke) {
        addJokeFragmentViewModel.insertJoke(joke)
    }
}
