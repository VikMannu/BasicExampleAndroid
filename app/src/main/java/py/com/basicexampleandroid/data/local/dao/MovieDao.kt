package py.com.basicexampleandroid.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import py.com.basicexampleandroid.data.local.entity.MovieEntity

@Dao
interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovie(movie: MovieEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovies(movies: List<MovieEntity>)

    @Query("SELECT * FROM movie_table ORDER BY title ASC")
    suspend fun getAllMovies(): List<MovieEntity>

    @Delete
    suspend fun deleteMovie(movie: MovieEntity)
}