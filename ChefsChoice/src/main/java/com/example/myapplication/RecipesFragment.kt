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
import com.google.mlkit.vision.barcode.BarcodeScannerOptions
import com.google.mlkit.vision.barcode.common.Barcode
import com.google.mlkit.vision.common.InputImage

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
/*  Would code related to the camera go here instead? https://developers.google.com/ml-kit/vision/barcode-scanning/android
    val options = BarcodeScannerOptions.Builder()
        .setBarcodeFormats(
            Barcode.FORMAT_UPC_A,
            Barcode.FORMAT_UPC_E)
        .build()

         */



        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_recipes, container, false)
    }

//}