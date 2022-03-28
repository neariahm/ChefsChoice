package com.example.myapplication

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.leanback.widget.DiffCallback
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.database.FavoriteEntity
import com.example.myapplication.databinding.GridItemsBinding
import com.example.myapplication.databinding.RecipeListBinding
import com.example.myapplication.viewmodel.FavoriteViewModel
//(private val viewModel: FavoriteViewModel)
class FavoriteAdapter  : ListAdapter <FavoriteEntity, FavoriteAdapter.FavoriteViewHolder>(DiffCallback) {
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
     //   holder.title1.setText(recipe.title)
       val viewModel: FavoriteViewModel = ViewModelProvider(holder.itemView.context as MainActivity2)[FavoriteViewModel::class.java]
        //ViewModelProvider(this@FavoritesFragment)[FavoriteViewModel::class.java]
        val id = recipe.id
        val recipeFavorited = if (id != null) {
            viewModel.recipeExists(id)
        } else { false }

        // Check the team's box if the ID is in database
        if (recipeFavorited) {
            holder.view.checkBox.isChecked = true
        }
      //  holder.view.checkBox.isChecked = true
        holder.view.checkBox.setOnClickListener {
            holder.view.checkBox.isChecked = recipe.favorite
            Log.i("Neariah", "Card clicked: " + recipe.favorite)

            //manually check to see if the checkbox is filled then set it
            onDeleteClick?.let {
                recipe?.let { it1 ->
                    it(it1)
                }
            }
        }

        holder.itemView.setOnClickListener{ v ->
            val intent = Intent( v.context, MainActivity4::class.java)
            intent.putExtra("id", recipe.id.toString())
            v.context.startActivity(intent)
            Log.i("Neariah", "Card clicked: " + recipe.id)
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
            val title1 = itemView.findViewById<TextView>(R.id.itemName)
            val recipeName = favoriteEntity.title
            title1.setText(recipeName)

            Glide.with(itemView.context).load(favoriteEntity.image).centerCrop().into(recipeImage)

        }
    }
    private var onDeleteClick: ((FavoriteEntity) -> Unit)? = null

    fun onDeleteClickListener(listener: (FavoriteEntity) -> Unit) {
        onDeleteClick = listener

    }
}