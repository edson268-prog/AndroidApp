package com.edsondev26.androidapp.superheroapp

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.edsondev26.androidapp.databinding.ItemSuperheroBinding
import com.squareup.picasso.Picasso

class SuperheroViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val binding = ItemSuperheroBinding.bind(view)

    fun bind(superHeroItemResponse: SuperHeroItemResponse, onItemSelected: (String) -> Unit) {
        binding.tvSuperheroName.text = superHeroItemResponse.name

        Picasso.get().load(superHeroItemResponse.superheroImage.url).into(binding.ivSuperhero)
        binding.root.setOnClickListener { onItemSelected(superHeroItemResponse.superheroId) }
    }
}