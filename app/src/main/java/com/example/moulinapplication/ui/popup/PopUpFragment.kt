package com.example.moulinapplication.ui.popup

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentPagerAdapter
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moulinapplication.R

import com.example.moulinapplication.databinding.FragmentPopUpBinding
import com.example.moulinapplication.model.Joke
import com.example.moulinapplication.network.RetrofitBuilder
import com.example.moulinapplication.repositories.JokeRepo
import com.example.moulinapplication.roomdb.RoomDB
import com.example.moulinapplication.ui.dashboard.DashboardViewModel
import com.example.moulinapplication.ui.dashboard.JokeRecyclerViewAdapter
import timber.log.Timber


class PopUpFragment(private val selectedJoke : Joke,val dashBoardViewmodel: DashboardViewModel,val adapter: JokeRecyclerViewAdapter) : DialogFragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        //init binding
        val binding = FragmentPopUpBinding.inflate(inflater,container,false)

        //update clicked
        binding.editjoke.setOnClickListener{
            var dialog = EditFragment(selectedJoke,dashBoardViewmodel,adapter)
            this.dismiss()
            getFragmentManager()?.let { it1 -> dialog.show(it1,"editFragment") }
        }


        //delete clicked
        binding.deletejoke.setOnClickListener {
            Toast.makeText(this.requireContext(),"Joke deleted", Toast.LENGTH_SHORT).show()
            adapter.notifyDataSetChanged()
            dashBoardViewmodel.deleteJoke(selectedJoke)
            this.dismiss()
        }


        return binding.root
    }
}