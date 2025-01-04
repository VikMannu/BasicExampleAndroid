package py.com.basicexampleandroid.presentation.popularmovies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import py.com.basicexampleandroid.databinding.FragmentPopularMoviesBinding
import py.com.basicexampleandroid.domain.model.MovieModel
import py.com.basicexampleandroid.presentation.adapters.MoviesAdapter
import py.com.basicexampleandroid.presentation.base.BaseFragment

@AndroidEntryPoint
class PopularMoviesFragment : BaseFragment() {

    private val binding: FragmentPopularMoviesBinding by lazy {
        FragmentPopularMoviesBinding.inflate(layoutInflater)
    }
    private val viewModel: PopularMoviesViewModel by viewModels()
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        baseBinding = binding
        baseViewModel = viewModel

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)
        setupBindings()
        viewModel.fetchPopularMovies()
    }

    private fun setupBindings() {
        viewModel.popularMovies.observe(viewLifecycleOwner) {
            // Handle popular movies
            setupRecyclerView(it)
        }
    }

    private fun setupRecyclerView(movies: List<MovieModel>) {
        // Setup recycler view
        val dividerItemDecoration = DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL)
        binding.rvPopularMovies.apply {
            layoutManager = LinearLayoutManager(requireContext())
            addItemDecoration(dividerItemDecoration)
            adapter = MoviesAdapter(movies, ::onMovieClick)
        }
    }

    private fun onMovieClick(movie: MovieModel) {
        // Handle movie click
        navController.navigate(
            PopularMoviesFragmentDirections.actionPopularMoviesFragmentToDetailMovieFragment(movie)
        )
    }

}