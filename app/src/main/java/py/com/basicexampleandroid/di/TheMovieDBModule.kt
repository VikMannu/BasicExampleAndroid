package py.com.basicexampleandroid.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import py.com.basicexampleandroid.data.datasource.AppServices
import py.com.basicexampleandroid.data.repository.TheMovieDBRepositoryImpl
import py.com.basicexampleandroid.domain.repository.TheMovieDBRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object TheMovieDBModule {
    @Provides
    @Singleton
    fun provideTheMovieDBService(
        api: AppServices
    ): TheMovieDBRepository {
        return TheMovieDBRepositoryImpl(api)
    }
}