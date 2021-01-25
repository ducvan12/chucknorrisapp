package com.example.moulinapplication.ui.dashboard

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.moulinapplication.R
import com.example.moulinapplication.databinding.JokeListItemBinding
import com.example.moulinapplication.model.Joke

class JokeRecyclerViewAdapter(var jokes: List<Joke>, val clickListener: (Joke) -> Unit) : RecyclerView.Adapter<MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: JokeListItemBinding = DataBindingUtil.inflate(inflater, R.layout.joke_list_item, parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(jokes[position], clickListener)
    }

    override fun getItemCount(): Int {
        return jokes.size
    }
}

class MyViewHolder(val binding: JokeListItemBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(joke: Joke, clickListener: (Joke) -> Unit) {
        binding.jokeSetup.text = joke.setup
        binding.jokePunchlune.text = joke.punchline
        binding.jokeRating.rating = joke.numberOfStars
        binding.textView6.text = joke.numberOfStars.toString() + "/5"
        binding.jokeCard.setOnClickListener {
            clickListener(joke)
        }
    }
}
