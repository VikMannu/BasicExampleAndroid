package py.com.basicexampleandroid.presentation.popularmovies

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import py.com.basicexampleandroid.domain.Resource
import py.com.basicexampleandroid.domain.model.PopularityMoviesModel
import py.com.basicexampleandroid.domain.usecase.FetchPopularMoviesUseCase
import py.com.basicexampleandroid.presentation.base.BaseViewModel
import javax.inject.Inject

@HiltViewModel
class PopularMoviesViewModel @Inject constructor(
    private val fetchPopularMoviesUseCase: FetchPopularMoviesUseCase
) : BaseViewModel() {
    val popularMovies: MutableLiveData<PopularityMoviesModel> by lazy {
        MutableLiveData<PopularityMoviesModel>()
    }

    fun fetchPopularMovies(page: Int) {
        viewModelScope.launch {
            fetchPopularMoviesUseCase(page).collect {
                when (it) {
                    is Resource.Loading -> {
                        isLoading.value = true
                    }
                    is Resource.Error -> {
                        isLoading.value = false
                        error.value = it.error
                    }
                    is Resource.Success -> {
                        isLoading.value = false
                        popularMovies.value = it.data
                    }
                }
            }
        }
    }
}