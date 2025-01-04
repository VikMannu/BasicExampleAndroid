package py.com.basicexampleandroid.data.datasource

import py.com.basicexampleandroid.data.local.dao.MovieDao
import py.com.basicexampleandroid.data.local.entity.MovieEntity

class LocalDataSourceImpl(
    private val dao: MovieDao
): LocalDataSource {
    override suspend fun saveMovies(movies: List<MovieEntity>) {
        dao.insertMovies(movies)
    }

    override suspend fun getAllMovies(): List<MovieEntity> {
        return dao.getAllMovies()
    }

    override suspend fun deleteMovie(movie: MovieEntity) {
        dao.deleteMovie(movie)
    }
}