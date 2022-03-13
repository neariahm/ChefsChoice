package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.leanback.widget.DiffCallback
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.database.FavoriteDao
import com.example.myapplication.database.FavoriteEntity
import com.example.myapplication.databinding.RecipeListBinding
import com.example.myapplication.network.Recipes

class RecipesListAdapter : ListAdapter<FavoriteEntity, RecipesListAdapter.RecipesViewHolder>(diffUtilCallback) {
    interface OnItemClickedListener {
        fun onItemClicked(index: Int)
    }

    companion object {
        private val diffUtilCallback = object : DiffUtil.ItemCallback<FavoriteEntity>() {
            override fun areItemsTheSame(
                oldItem: FavoriteEntity,
                newItem: FavoriteEntity
            ): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: FavoriteEntity,
                newItem: FavoriteEntity
            ): Boolean {
                return oldItem.image == newItem.image
            }
        }
    }

    class RecipesViewHolder(var view: RecipeListBinding) : RecyclerView.ViewHolder(view.root) {

        fun bind(favoriteEntity: FavoriteEntity) {
            view.photo = favoriteEntity
            view.executePendingBindings()
        }
        // val favorite=binding.checkBox

    }

    val differ = AsyncListDiffer(this, diffUtilCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipesViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = DataBindingUtil.inflate<RecipeListBinding>(
            inflater,
            R.layout.recipe_list,
            parent,
            false
        )
        return RecipesViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecipesViewHolder, position: Int) {
        val recipe = getItem(position)
        holder.bind(recipe)
        holder.view.checkBox.setOnClickListener {
            holder.view.checkBox.isChecked = recipe.favorite
            holder.view.checkBox.tag = 0
            onSaveClick?.let {
                recipe?.let { it1 ->
                    it(it1)
                }
            }
        }


        // When card is clicked, Extract the id to launch a new fragment
    }

    private var onSaveClick: ((FavoriteEntity) -> Unit)? = null

    fun onSaveClickListener(listener: (FavoriteEntity) -> Unit) {
        onSaveClick = listener

    }
}
