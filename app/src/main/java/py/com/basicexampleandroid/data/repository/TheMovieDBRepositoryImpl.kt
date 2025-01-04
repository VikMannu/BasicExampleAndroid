package py.com.basicexampleandroid.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import py.com.basicexampleandroid.data.datasource.AppServices
import py.com.basicexampleandroid.data.helper.handleRequest
import py.com.basicexampleandroid.domain.Resource
import py.com.basicexampleandroid.domain.model.PopularityMoviesModel
import py.com.basicexampleandroid.domain.repository.TheMovieDBRepository

class TheMovieDBRepositoryImpl(
    private val api: AppServices
) : TheMovieDBRepository {

    override fun fetchPopularMovies(page: Int): Flow<Resource<PopularityMoviesModel>> = flow {
        emit(Resource.Loading())

        emit(handleRequest { api.getPopularMovies(page = page).toModel()})
    }
}