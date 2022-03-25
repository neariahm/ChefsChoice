package com.example.myapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.network.*
import kotlinx.coroutines.launch

// PopularViewModel is attached to the HomeFragment
class PopularViewModel: ViewModel() {

    // The internal MutableLiveData that stores the status of the most recent request
    private val _photos = MutableLiveData<ComplexSearch>()
    private val _trivia = MutableLiveData<Trivia>()


    // The external immutable LiveData for the request status
    val photos: LiveData<ComplexSearch> = _photos
    val trivia: LiveData<Trivia> = _trivia


    //preload. first call
    init {
        getPopularRecipes()
        getFoodTrivia()
    }

     private fun getPopularRecipes() {
        viewModelScope.launch {
          _photos.value = ChefApi.retrofitService.getPopular()

            }

        }
    private fun getFoodTrivia() {
        viewModelScope.launch {
            _trivia.value = ChefApi.retrofitService.getTrivia()

        }
    }
}