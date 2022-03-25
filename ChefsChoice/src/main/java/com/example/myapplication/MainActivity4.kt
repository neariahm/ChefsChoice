package com.example.myapplication

import android.os.Build.ID
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri
import androidx.databinding.DataBindingUtil.setContentView
import coil.load
import com.bumptech.glide.Glide
import com.example.myapplication.database.RecipesApplication
import com.example.myapplication.viewmodel.FavoriteViewModelFactory
import com.example.myapplication.viewmodel.RecipesViewModelFactory


class MainActivity4 : AppCompatActivity() {
    private val viewModel: RecipesViewModel by viewModels() {
        RecipesViewModelFactory((this.application as RecipesApplication).database.favoriteDao())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)

        val recipeId = intent.getStringExtra("id")   // returns null bc need .toString in adapter

        if (recipeId != null) {
            viewModel.getRecipeCard(recipeId)
            //Coil
            viewModel.card.observe(this) {
                findViewById<ImageView>(R.id.imageView).load(
                    it?.url?.toUri()?.buildUpon()?.scheme("https")?.build()
                )

            }
        }
    }
}



