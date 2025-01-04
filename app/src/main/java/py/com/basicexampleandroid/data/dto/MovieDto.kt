package py.com.basicexampleandroid.data.dto

import com.google.gson.annotations.SerializedName
import py.com.basicexampleandroid.domain.model.MovieModel
import java.io.Serializable

data class MovieDto(
    @SerializedName("adult") val adult: Boolean? = null,
    @SerializedName("backdrop_path") val backdropPath: String? = null,
    @SerializedName("genre_ids") val genreIds: List<Int>? = null,
    @SerializedName("id") val id: Int? = null,
    @SerializedName("original_language") val originalLanguage: String? = null,
    @SerializedName("original_title") val originalTitle: String? = null,
    @SerializedName("overview") val overview: String? = null,
    @SerializedName("popularity") val popularity: Double? = null,
    @SerializedName("poster_path") val posterPath: String? = null,
    @SerializedName("release_date") val releaseDate: String? = null,
    @SerializedName("title") val title: String? = null,
    @SerializedName("video") val video: Boolean? = null,
    @SerializedName("vote_average") val voteAverage: Double? = null,
    @SerializedName("vote_count") val voteCount: Int? = null,
    @SerializedName("rating") val rating: Int? = null
): Serializable {
    fun toModel(): MovieModel {
        return MovieModel(
            adult = this.adult ?: false,
            backdropPath = this.backdropPath ?: "N/A",
            genreIds = this.genreIds ?: emptyList(),
            id = this.id ?: 0,
            originalLanguage = this.originalLanguage ?: "N/A",
            originalTitle = this.originalTitle ?: "N/A",
            overview = this.overview ?: "N/A",
            popularity = this.popularity ?: 0.0,
            posterPath = this.posterPath ?: "N/A",
            releaseDate = this.releaseDate ?: "N/A",
            title = this.title ?: "N/A",
            video = this.video ?: false,
            voteAverage = this.voteAverage ?: 0.0,
            voteCount = this.voteCount ?: 0,
            rating = this.rating ?: 0
        )
    }
}
