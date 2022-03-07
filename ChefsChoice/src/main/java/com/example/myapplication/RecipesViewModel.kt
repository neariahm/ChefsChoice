package com.example.myapplication

import android.widget.EditText
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.network.ChefApi
import com.example.myapplication.network.RandomRecipe
import com.example.myapplication.network.Recipes
import com.example.myapplication.network.Trivia
import kotlinx.coroutines.launch

// RecipesViewModel is attached to the RecipesFragment
class RecipesViewModel : ViewModel() {

    // The internal MutableLiveData that stores the status of the most recent request
    private val _status = MutableLiveData<String>()
    private val _photos = MutableLiveData<List<Recipes>>()
private val _trivia = MutableLiveData<Trivia>()
//private val _random = MutableLiveData<RandomRecipe>()


    // The external immutable LiveData for the request status
    val status: LiveData<String> = _status
    val photos: LiveData<List<Recipes>> = _photos
      val trivia: LiveData<Trivia> = _trivia
//val random: LiveData<RandomRecipe> = _random

//preload. first call
    init {
          getFoodTrivia()

//getRandomRecipe()
    }

      private fun getFoodTrivia() {
         viewModelScope.launch {
            _trivia.value = ChefApi.retrofitService.getTrivia()
         }
     }
     fun getChefPhotos(ingredient: String) {

        viewModelScope.launch {
            try {
                _photos.value = ChefApi.retrofitService.getPhotos(ingredient)
                _status.value = "Success: Recipes retrieved"
            } catch (e: Exception) {
                _status.value = "Failure: ${e.message}"
            }
        }
    }
}
   // private fun getRandomRecipe() {
  //      viewModelScope.launch{
   //         _random.value = ChefApi.retrofitService.getRandom()
  //      }
 //   }

  //  }
