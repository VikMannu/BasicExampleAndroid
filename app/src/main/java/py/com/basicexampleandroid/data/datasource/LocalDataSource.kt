package py.com.basicexampleandroid.data.datasource

import py.com.basicexampleandroid.data.local.entity.MovieEntity

interface LocalDataSource {
    suspend fun saveMovies(movies: List<MovieEntity>)
    suspend fun getAllMovies(): List<MovieEntity>
    suspend fun deleteMovie(movie: MovieEntity)
}