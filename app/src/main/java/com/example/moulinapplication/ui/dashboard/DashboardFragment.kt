package com.example.moulinapplication.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moulinapplication.databinding.FragmentDashboardBinding
import com.example.moulinapplication.model.Joke
import com.example.moulinapplication.network.RetrofitBuilder
import com.example.moulinapplication.repositories.JokeRepo
import com.example.moulinapplication.roomdb.JokeDao
import com.example.moulinapplication.roomdb.RoomDB
import com.example.moulinapplication.ui.popup.PopUpFragment

class DashboardFragment : Fragment() {

    private lateinit var dashboardViewModel: DashboardViewModel
    lateinit var binding: FragmentDashboardBinding
    lateinit var adapter: JokeRecyclerViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // init repo and viewmodel
        val dao: JokeDao = RoomDB.getInstance(requireContext()).JokeDAO
        val jokerepo = JokeRepo(dao, RetrofitBuilder.jokeservice)
        val factory = DashboardViewModelFactory(jokerepo)
        dashboardViewModel = ViewModelProvider(this, factory).get(DashboardViewModel::class.java)

        // init binding
        binding = FragmentDashboardBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this

        // init recyclerview
        initrecyclerview()

        return binding.root
    }

    fun initrecyclerview() {
        dashboardViewModel.jokes.observe(
            viewLifecycleOwner,
            {
                adapter = JokeRecyclerViewAdapter(it, { selected: Joke -> jokeIsClicked(selected) })
                binding.recyclerview.layoutManager = LinearLayoutManager(this.requireContext())
                binding.recyclerview.adapter = adapter
            }
        )
    }

    fun jokeIsClicked(joke: Joke) {
        // show pop up dialog
        val dialog = PopUpFragment(joke, dashboardViewModel, adapter)
        getFragmentManager()?.let { dialog.show(it, "popUpDialog") }
    }
}
