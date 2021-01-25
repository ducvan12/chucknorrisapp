package com.example.moulinapplication.ui.popup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.example.moulinapplication.databinding.FragmentPopUpBinding
import com.example.moulinapplication.model.Joke
import com.example.moulinapplication.ui.dashboard.DashboardViewModel
import com.example.moulinapplication.ui.dashboard.JokeRecyclerViewAdapter

/**
 *pop up dialog fragment control for edit/update
 * @property selectedJoke the selected joke
 * @property dashBoardViewmodel update livedata
 * @property adapter for notify adapter
 */
class PopUpFragment(private val selectedJoke: Joke, val dashBoardViewmodel: DashboardViewModel, val adapter: JokeRecyclerViewAdapter) : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // init binding
        val binding = FragmentPopUpBinding.inflate(inflater, container, false)

        // update clicked
        binding.editjoke.setOnClickListener {
            var dialog = EditFragment(selectedJoke, dashBoardViewmodel, adapter)
            this.dismiss()
            getFragmentManager()?.let { it1 -> dialog.show(it1, "editFragment") }
        }

        // delete clicked
        binding.deletejoke.setOnClickListener {
            Toast.makeText(this.requireContext(), "Joke deleted", Toast.LENGTH_SHORT).show()
            adapter.notifyDataSetChanged()
            dashBoardViewmodel.deleteJoke(selectedJoke)
            this.dismiss()
        }

        return binding.root
    }
}
