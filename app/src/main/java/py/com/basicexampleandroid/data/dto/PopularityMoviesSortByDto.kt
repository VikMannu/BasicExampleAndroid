package py.com.basicexampleandroid.data.dto

import com.google.gson.annotations.SerializedName
import java.io.Serializable

enum class PopularityMoviesSortByDto: Serializable {
    @SerializedName("popularity.asc") ASCENDING,
    @SerializedName("popularity.desc") DESCENDING
}