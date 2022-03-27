package com.example.myapplication


import android.R
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isEmpty
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.example.myapplication.database.RecipesApplication
import com.example.myapplication.databinding.FragmentRecipesBinding
import com.example.myapplication.viewmodel.RecipesViewModelFactory
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.launch


class RecipesFragment : Fragment() {
    val adapter = RecipesListAdapter()


    private val viewModel: RecipesViewModel by activityViewModels {
        RecipesViewModelFactory((activity?.application as RecipesApplication).database.favoriteDao())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val binding = FragmentRecipesBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel


        //Get user input from searchview & query the api to get the results
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextSubmit( query: String): Boolean {
                Log.i("Neariah", query)
                viewModel.getChefPhotos(query)
                // Show toast when API returns empty list (cannot find ingredient) however shows on first search
                //if(binding.recyclerView.isEmpty()){
                //    Toast.makeText(activity, "No recipes found, please try another ingredient.", Toast.LENGTH_LONG)
                //        .show()
               // }
                return true

            }
            override fun onQueryTextChange(s: String?): Boolean {
                return false

            }

        })


        binding.recyclerView.adapter = adapter
        adapter.onSaveClickListener {
            lifecycleScope.launch {
                viewModel.insert(it)
                Snackbar.make(requireView(), "SAVED", Snackbar.LENGTH_SHORT).show()
            }
        }

         binding.button.setOnClickListener {
            val intent = Intent(activity, MainActivity3::class.java)
             activity?.startActivity(intent)
        }




        return binding.root
    }


}









