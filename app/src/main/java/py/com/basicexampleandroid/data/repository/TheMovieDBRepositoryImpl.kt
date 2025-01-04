package py.com.basicexampleandroid.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import py.com.basicexampleandroid.data.datasource.AppServices
import py.com.basicexampleandroid.data.datasource.LocalDataSource
import py.com.basicexampleandroid.data.helper.APIError
import py.com.basicexampleandroid.data.helper.handleRequest
import py.com.basicexampleandroid.data.local.entity.toModel
import py.com.basicexampleandroid.domain.Resource
import py.com.basicexampleandroid.domain.model.MovieModel
import py.com.basicexampleandroid.domain.model.toEntity
import py.com.basicexampleandroid.domain.repository.TheMovieDBRepository

class TheMovieDBRepositoryImpl(
    private val api: AppServices,
    private val localDataSource: LocalDataSource
) : TheMovieDBRepository {

    override fun fetchMovies(): Flow<Resource<List<MovieModel>>> = flow {
        emit(Resource.Loading())

        // 1. Emitir datos locales primero (si existen)
        val localMovies = localDataSource.getAllMovies().map { it.toModel() }
        if (localMovies.isNotEmpty()) {
            emit(Resource.Success(localMovies))
        }

        // 2. Llamar al API para obtener datos actualizados
        val apiResult = handleRequest { api.getPopularMovies().toModel().results }
        when (apiResult) {
            is Resource.Success -> {
                // 3. Guardar los datos obtenidos de la API en el almacenamiento local
                localDataSource.saveMovies(apiResult.data?.map { it.toEntity() } ?: emptyList())

                // 4. Emitir los nuevos datos obtenidos
                emit(Resource.Success(apiResult.data ?: emptyList()))
            }
            is Resource.Error -> {
                emit(Resource.Error(error = APIError(statusMessage = "Error fetching data from API")))
            }
            else -> Unit
        }
    }
}