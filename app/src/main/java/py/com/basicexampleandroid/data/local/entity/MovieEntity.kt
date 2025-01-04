package py.com.basicexampleandroid.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import py.com.basicexampleandroid.domain.model.MovieModel

@Entity(tableName = "movie_table")
data class MovieEntity(
    @PrimaryKey val id: Int,
    val adult: Boolean,
    val backdropPath: String,
    val genreIds: List<Int>,
    val originalLanguage: String,
    val originalTitle: String,
    val overview: String,
    val popularity: Double,
    val posterPath: String,
    val releaseDate: String,
    val title: String,
    val video: Boolean,
    val voteAverage: Double,
    val voteCount: Int,
    val rating: Int
)

fun MovieEntity.toModel(): MovieModel {
    return MovieModel(
        id = id,
        adult = adult,
        backdropPath = backdropPath,
        genreIds = genreIds,
        originalLanguage = originalLanguage,
        originalTitle = originalTitle,
        overview = overview,
        popularity = popularity,
        posterPath = posterPath,
        releaseDate = releaseDate,
        title = title,
        video = video,
        voteAverage = voteAverage,
        voteCount = voteCount,
        rating = rating
    )
}