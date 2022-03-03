package com.example.myapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.RecipeListBinding
import com.example.myapplication.network.Recipes

class RecipesListAdapter : ListAdapter<Recipes,
        RecipesListAdapter.RecipesViewHolder>(DiffCallback) {

    class RecipesViewHolder(
        private var binding: RecipeListBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(recipes: Recipes) {
            binding.photo = recipes
            binding.executePendingBindings()
        }
    }
    companion object DiffCallback : DiffUtil.ItemCallback<Recipes>() {
        override fun areItemsTheSame(oldItem: Recipes, newItem: Recipes): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Recipes, newItem: Recipes): Boolean {
            return oldItem.image == newItem.image
        }
    }
        override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int,
        ): RecipesViewHolder {
            return RecipesViewHolder(
                RecipeListBinding.inflate(LayoutInflater.from(parent.context)))
        }

        override fun onBindViewHolder(holder: RecipesViewHolder, position: Int) {
            val recipes = getItem(position)
            holder.bind(recipes)
            // When card is clicked, Extract the id to launch a new fragment
        }
    }
