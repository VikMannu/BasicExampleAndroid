package py.com.basicexampleandroid.domain.model

data class PopularityMoviesModel(
    val page: Int,
    val results: List<MovieModel>,
    val totalPages: Int,
    val totalResults: Int
)