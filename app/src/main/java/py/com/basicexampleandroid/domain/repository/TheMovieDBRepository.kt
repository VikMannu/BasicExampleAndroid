package py.com.basicexampleandroid.domain.repository

import kotlinx.coroutines.flow.Flow
import py.com.basicexampleandroid.domain.Resource
import py.com.basicexampleandroid.domain.model.MovieModel

interface TheMovieDBRepository {
    fun fetchMovies(): Flow<Resource<List<MovieModel>>>
}