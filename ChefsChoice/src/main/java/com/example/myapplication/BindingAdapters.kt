package com.example.myapplication

import android.widget.ImageView
import android.widget.SearchView
import android.widget.TextView
import android.widget.Toast
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import coil.load

import com.example.myapplication.network.ComplexSearch
import com.example.myapplication.network.ComplexSearchData
import com.example.myapplication.database.FavoriteEntity
import com.example.myapplication.network.Recipes
import com.example.myapplication.network.Trivia
//RecipesFragment
@BindingAdapter("imageUrl")
    fun bindImage(imgView: ImageView, imgUrl: String?) {
        imgUrl?.let {
            val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()
            imgView.load(imgUri)
            imgView.load(imgUri) {
                placeholder(R.drawable.loading_animation)
                error(R.drawable.ic_broken_image)
            }
        }
    }
@BindingAdapter("listData")
    fun bindRecyclerView(
    recyclerView: RecyclerView,
    data: List<FavoriteEntity>?,
) {
        val adapter = recyclerView.adapter as RecipesListAdapter
        adapter.submitList(data)
    }

/*@BindingAdapter("Data")
fun bindRecyclerView2(
    recyclerView: RecyclerView,
    data: List<FavoriteEntity>?,
) {
    val adapter = recyclerView.adapter as FavoriteAdapter
    adapter.submitList(data)
}*/
@BindingAdapter("text")
fun setText(view: TextView, text: String?) {
    view.text = text
}

//Home Fragment
@BindingAdapter("image")
fun bindImage2(imgView: ImageView, imgUrl: String?) {
    imgUrl?.let {
        val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()
        imgView.load(imgUri)
        imgView.load(imgUri) {
            placeholder(R.drawable.loading_animation)
            error(R.drawable.ic_broken_image)
        }
    }
}
@BindingAdapter("info")
fun bindRecyclerView2(recyclerView: RecyclerView,
                      data: List<ComplexSearchData>?,
) {
    val adapter = recyclerView.adapter as PopularListAdapter
    adapter.submitList(data)
}

@BindingAdapter("foodTrivia")
fun setTriviaText(view: TextView, text: String?) {
    view.text = text
}


@BindingAdapter("gridText")
fun setGridText(view: TextView, text: String?) {
    view.text = text
}




