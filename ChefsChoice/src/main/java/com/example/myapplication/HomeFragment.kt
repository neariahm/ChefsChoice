package com.example.myapplication

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.net.toUri
import androidx.fragment.app.viewModels
import coil.load
import com.example.myapplication.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    private val viewModel: RecipesViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentHomeBinding.inflate(inflater)
        binding.lifecycleOwner = this

        binding.button2.setOnClickListener {
            binding.foodTrivia.text = viewModel.getFoodTrivia().toString()

        }

            return binding.root
        }
    }



// Inflate the layout for this fragment
// return inflater.inflate(R.layout.fragment_home, container, false)
/* Get data from searchview & query the api to get the results

 viewModel.random.observe(viewLifecycleOwner) {
                binding.recipeOfTheDay.load(
                    it?.image?.toUri()?.buildUpon()?.scheme("https")?.build()
                )
                viewModel.getRandomRecipe()

 */
