package py.com.basicexampleandroid.data.datasource

import py.com.basicexampleandroid.data.dto.PopularityMoviesDto
import retrofit2.http.GET
import retrofit2.http.Query

interface AppServices {

    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("page") page: Int = 1,
        @Query("language") language: String = "en-US"
    ) : PopularityMoviesDto
}