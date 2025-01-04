package py.com.basicexampleandroid.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import py.com.basicexampleandroid.data.datasource.LocalDataSource
import py.com.basicexampleandroid.data.datasource.LocalDataSourceImpl
import py.com.basicexampleandroid.data.local.dao.MovieDao

@Module
@InstallIn(SingletonComponent::class)
object LocalDataSourceModule {
    @Provides
    fun provideLocalDataSource(dao: MovieDao): LocalDataSource {
        return LocalDataSourceImpl(dao)
    }
}