package py.com.basicexampleandroid.domain.model

import py.com.basicexampleandroid.data.dto.PopularityMoviesSortByDto

enum class PopularityMoviesSortBy {
    ASCENDING,
    DESCENDING;

    fun toDto(): PopularityMoviesSortByDto {
        return when (this) {
            ASCENDING -> PopularityMoviesSortByDto.ASCENDING
            DESCENDING -> PopularityMoviesSortByDto.DESCENDING
        }
    }
}