package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.coroutineScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.database.RecipesApplication
import com.example.myapplication.databinding.FragmentFavoritesBinding
import com.example.myapplication.viewmodel.FavoriteViewModel
import com.example.myapplication.viewmodel.FavoriteViewModelFactory
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class FavoritesFragment : Fragment() {
    private var _binding: FragmentFavoritesBinding? = null
    val binding get() = _binding!!
    val viewModel: FavoriteViewModel by activityViewModels() {
        FavoriteViewModelFactory((activity?.application as RecipesApplication).database.favoriteDao())
    }

    private lateinit var recyclerView: RecyclerView
    val favoriteAdapter = FavoriteAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentFavoritesBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = binding.recyclerView
        recyclerView.layoutManager = GridLayoutManager(context, 3)
        recyclerView.adapter = favoriteAdapter
        showFavorites()
    }

    private fun showFavorites() {

        lifecycle.coroutineScope.launch {
            viewModel.showFavorites().collect {
                favoriteAdapter.submitList(it)
            }
        }
    }
}
