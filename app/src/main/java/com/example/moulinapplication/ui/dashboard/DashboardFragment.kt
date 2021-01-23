package com.example.moulinapplication.ui.dashboard

import android.opengl.GLES30
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moulinapplication.R
import com.example.moulinapplication.databinding.FragmentDashboardBinding
import com.example.moulinapplication.network.RetrofitBuilder
import com.example.moulinapplication.repositories.JokeRepo
import com.example.moulinapplication.roomdb.JokeDao
import com.example.moulinapplication.roomdb.RoomDB
import com.example.moulinapplication.ui.home.AddJokeFragmentViewModel
import com.example.moulinapplication.ui.home.AddJokeFragmentViewModelFactory
import retrofit2.Retrofit
import timber.log.Timber

class DashboardFragment : Fragment() {

    private lateinit var dashboardViewModel: DashboardViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {


        //init repo and viewmodel
        val dao : JokeDao = RoomDB.getInstance(requireContext()).JokeDAO
        val jokerepo = JokeRepo(dao,RetrofitBuilder.jokeservice)
        val factory =DashboardViewModelFactory(jokerepo)
        dashboardViewModel = ViewModelProvider(this,factory).get(DashboardViewModel::class.java)


        //init binding
        val binding = FragmentDashboardBinding.inflate(inflater,container,false)



        //recycler view vullen met de favourite jokes
        dashboardViewModel.jokes.observe(viewLifecycleOwner, {
            binding.recyclerview.layoutManager= LinearLayoutManager(this.requireContext())
            binding.lifecycleOwner=this
            binding.recyclerview.adapter=JokeRecyclerViewAdapter(it)

        })


        return binding.root
    }




}