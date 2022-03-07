package com.example.myapplication

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.viewModels
import com.example.myapplication.databinding.FragmentRecipesBinding
import com.example.myapplication.databinding.RecipeListBinding

class RecipesFragment : Fragment() {

    private val viewModel: RecipesViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentRecipesBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        binding.recyclerView.adapter = RecipesListAdapter()

        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
            Log.i("Neariah", query)
                viewModel.getChefPhotos(query)
                return true
            }

            override fun onQueryTextChange(s: String?): Boolean {
                return false
            }
        })
        return binding.root
    }



        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_recipes, container, false)
    }

//}