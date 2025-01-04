package py.com.basicexampleandroid.data.dto

import com.google.gson.annotations.SerializedName
import py.com.basicexampleandroid.domain.model.PopularityMoviesModel
import java.io.Serializable

data class PopularityMoviesDto(
    @SerializedName("page") val page: Int? = null,
    @SerializedName("results") val results: List<MovieDto>? = null,
    @SerializedName("total_pages") val totalPages: Int? = null,
    @SerializedName("total_results") val totalResults: Int? = null
) : Serializable {
    fun toModel(): PopularityMoviesModel {
        return PopularityMoviesModel(
            page = this.page ?: 0,
            results = this.results?.map { it.toModel() } ?: emptyList(),
            totalPages = this.totalPages ?: 0,
            totalResults = this.totalResults ?: 0
        )
    }
}
