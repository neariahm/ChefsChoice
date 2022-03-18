package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.leanback.widget.DiffCallback
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.database.FavoriteEntity
import com.example.myapplication.databinding.GridItemsBinding
import com.example.myapplication.databinding.RecipeListBinding


class FavoriteAdapter : ListAdapter <FavoriteEntity, FavoriteAdapter.FavoriteViewHolder>(DiffCallback) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FavoriteViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = DataBindingUtil.inflate<GridItemsBinding>(
            inflater,
            R.layout.grid_items,
            parent,
            false
        )
        return FavoriteViewHolder(view)
    }

    override fun onBindViewHolder(holder: FavoriteAdapter.FavoriteViewHolder, position: Int) {
        val recipe = getItem(position)
        holder.bind(recipe)
        holder.view.checkBox.setOnClickListener {
            holder.view.checkBox.isChecked = recipe.favorite
            holder.view.checkBox.tag = 0
            onDeleteClick?.let {
                recipe?.let { it1 ->
                    it(it1)
                }
            }
        }
    }
    companion object {
        private val DiffCallback = object : DiffUtil.ItemCallback<FavoriteEntity>() {
            override fun areItemsTheSame(oldItem: FavoriteEntity, newItem: FavoriteEntity): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: FavoriteEntity, newItem: FavoriteEntity): Boolean {
                return oldItem == newItem
            }

        }
    }
    class FavoriteViewHolder(var view: GridItemsBinding) : RecyclerView.ViewHolder(view.root) {

        fun bind(favoriteEntity: FavoriteEntity) {
            val recipeImage = itemView.findViewById<ImageView>(R.id.gridImage)
            val title = view.itemName
            val recipeName = favoriteEntity.title
            title.setText(recipeName)
            Glide.with(itemView.context).load(favoriteEntity.image).centerCrop().into(recipeImage)

        }
    }
    private var onDeleteClick: ((FavoriteEntity) -> Unit)? = null

    fun onDeleteClickListener(listener: (FavoriteEntity) -> Unit) {
        onDeleteClick = listener

    }
}