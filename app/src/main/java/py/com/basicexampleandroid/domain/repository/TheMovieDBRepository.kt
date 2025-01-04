package py.com.basicexampleandroid.domain.repository

import kotlinx.coroutines.flow.Flow
import py.com.basicexampleandroid.domain.Resource
import py.com.basicexampleandroid.domain.model.PopularityMoviesModel

interface TheMovieDBRepository {
    fun fetchPopularMovies(page: Int): Flow<Resource<PopularityMoviesModel>>
}