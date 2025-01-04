package py.com.basicexampleandroid.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import py.com.basicexampleandroid.data.local.dao.MovieDao
import py.com.basicexampleandroid.data.local.entity.MovieEntity

@Database(
    entities = [
        MovieEntity::class
    ],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
}