package py.com.basicexampleandroid.domain.usecase

import kotlinx.coroutines.flow.Flow
import py.com.basicexampleandroid.domain.Resource
import py.com.basicexampleandroid.domain.model.MovieModel
import py.com.basicexampleandroid.domain.repository.TheMovieDBRepository
import javax.inject.Inject

class FetchPopularMoviesUseCase @Inject constructor(
    private val repository: TheMovieDBRepository
) {
    operator fun invoke(): Flow<Resource<List<MovieModel>>> = repository.fetchMovies()
}