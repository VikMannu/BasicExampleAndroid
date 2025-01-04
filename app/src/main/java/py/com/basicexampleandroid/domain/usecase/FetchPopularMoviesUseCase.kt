package py.com.basicexampleandroid.domain.usecase

import kotlinx.coroutines.flow.Flow
import py.com.basicexampleandroid.domain.Resource
import py.com.basicexampleandroid.domain.model.PopularityMoviesModel
import py.com.basicexampleandroid.domain.repository.TheMovieDBRepository
import javax.inject.Inject

class FetchPopularMoviesUseCase @Inject constructor(
    private val repository: TheMovieDBRepository
) {
    operator fun invoke(page: Int): Flow<Resource<PopularityMoviesModel>> = repository.fetchPopularMovies(page)
}