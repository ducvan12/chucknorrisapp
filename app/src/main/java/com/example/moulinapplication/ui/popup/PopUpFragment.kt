package com.example.moulinapplication.ui.popup

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.moulinapplication.databinding.FragmentPopUpBinding


class PopUpFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        //init binding
        val binding = FragmentPopUpBinding.inflate(inflater,container,false)


        return binding.root

    }
}