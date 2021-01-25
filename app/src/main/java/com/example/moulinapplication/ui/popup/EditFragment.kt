package com.example.moulinapplication.ui.popup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.example.moulinapplication.databinding.FragmentEditBinding
import com.example.moulinapplication.model.Joke
import com.example.moulinapplication.ui.dashboard.DashboardViewModel
import com.example.moulinapplication.ui.dashboard.JokeRecyclerViewAdapter

/**
 *pop up dialog fragment control for updating rating
 * @property selectedJoke the selected joke
 * @property dashBoardViewmodel update livedata
 * @property adapter for notify adapter
 */
class EditFragment(val selectedJoke: Joke, val dashboardViewModel: DashboardViewModel, val adapter: JokeRecyclerViewAdapter) : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // init binding
        val binding = FragmentEditBinding.inflate(inflater, container, false)

        // update button is clicked
        binding.updatebutton.setOnClickListener {
            selectedJoke.numberOfStars = binding.ratingBar.rating
            dashboardViewModel.editJoke(selectedJoke)
            adapter.notifyDataSetChanged()
            Toast.makeText(this.requireContext(), "Joke updated", Toast.LENGTH_SHORT).show()
            this.dismiss()
        }

        return binding.root
    }
}
