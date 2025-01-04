package py.com.basicexampleandroid.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Protocol
import okhttp3.logging.HttpLoggingInterceptor
import py.com.basicexampleandroid.data.datasource.AppServices
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    @Singleton
    fun provideGson(): Gson {
        return GsonBuilder().setLenient().create()
    }

    @Provides
    @Singleton
    fun provideInterceptor(): Interceptor {
        return Interceptor { chain ->
            val requestBuilder = chain.request().newBuilder()
            requestBuilder.addHeader("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIwZWRhNGMyMjU2NzVmNWY3NWVhODAxNDdiM2NkYmNjZiIsIm5iZiI6MTcxMDQ2OTYwMy41NTksInN1YiI6IjY1ZjNiMWUzMzg1MjAyMDE0OWUxNzg0NyIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.9v-1jJb8s36Ogn8m1Gu_F4CeZV_PGrpZt_7xDPrCe8M")
            requestBuilder.addHeader("accept", "application/json")
            chain.proceed(requestBuilder.build())
        }
    }

    @Provides
    @Singleton
    fun provideClient(interceptor: Interceptor): OkHttpClient {
        val httpBuilder =
            OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)

        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        httpBuilder.addInterceptor(logging)

        return httpBuilder.protocols(mutableListOf(Protocol.HTTP_1_1)).build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(baseUrl: String, client: OkHttpClient, gson: Gson): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(client)
            .build()
    }

    @Provides
    @Singleton
    fun provideAppService(): AppServices {
        return provideRetrofit("https://api.themoviedb.org/3/",
            provideClient(provideInterceptor()),
            provideGson()
        ).create(AppServices::class.java)
    }
}