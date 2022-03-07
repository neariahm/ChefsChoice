package com.example.myapplication

import android.widget.ImageView
import android.widget.SearchView
import android.widget.TextView
import android.widget.Toast
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.myapplication.network.Recipes
import com.example.myapplication.network.Trivia

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
    data: List<Recipes>?,
) {
        val adapter = recyclerView.adapter as RecipesListAdapter
        adapter.submitList(data)
    }

@BindingAdapter("text")
fun setText(view: TextView, text: String?) {
    view.text = text
}

//@BindingAdapter("foodTrivia")
//fun setTriviaText(view: TextView, data: Trivia ) {
 //  view.text = data.text
  // }


//}
//@BindingAdapter("userInput")
//fun setQuery(searchView: SearchView, query: String){
 //   searchView.toString() = query
  //  notifyPropertyChanged(viewModel.query)
//}

//fun setupSearchView(view: SearchView, userInput: String?): Boolean {
 // view.setOnQueryTextListener(object: SearchView.OnQueryTextListener {
      //Triggered when the search is passed
     //  override fun onQueryTextSubmit(query: String?): Boolean {
      //    RecipesViewModel.getChefRecipes()
          // view.clearFocus()
         //  view.setQuery("", false)
      //    return true
     //  }
//Called when the user types each character in the text field
     //  override fun onQueryTextChange(newText: String?): Boolean {
     //    return false
     //  }
  // })
  // return true
  // } */

