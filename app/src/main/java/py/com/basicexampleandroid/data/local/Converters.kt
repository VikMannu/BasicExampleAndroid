package py.com.basicexampleandroid.data.local

import androidx.room.TypeConverter

class Converters {
    @TypeConverter
    fun fromGenreIdsList(genreIds: List<Int>?): String? {
        return genreIds?.joinToString(",") // Convierte la lista a una cadena separada por comas
    }

    @TypeConverter
    fun toGenreIdsList(data: String?): List<Int>? {
        return data?.split(",")?.map { it.toInt() } // Convierte la cadena separada por comas de vuelta a una lista
    }
}