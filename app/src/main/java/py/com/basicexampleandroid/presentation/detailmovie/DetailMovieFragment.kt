package py.com.basicexampleandroid.presentation.detailmovie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import py.com.basicexampleandroid.databinding.FragmentDetailMovieBinding
import py.com.basicexampleandroid.presentation.base.BaseFragment

@AndroidEntryPoint
class DetailMovieFragment : BaseFragment() {

    private val binding: FragmentDetailMovieBinding by lazy {
        FragmentDetailMovieBinding.inflate(layoutInflater)
    }
    private val viewModel: DetailMovieViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        baseBinding = binding
        baseViewModel = viewModel

        return binding.root
    }
}