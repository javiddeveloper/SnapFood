package ir.javid.satttar.snapfood.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import ir.javid.satttar.snapfood.data.database.converter.CharacterVideoTypeConverter
import ir.javid.satttar.snapfood.data.database.model.CharacterVideoDetailEntity
import ir.javid.satttar.snapfood.data.database.model.CharacterVideoEntity
import ir.javid.satttar.snapfood.data.database.model.PropertiesDetailEntity
import ir.javid.satttar.snapfood.data.database.model.PropertiesEntity
import ir.javid.satttar.snapfood.data.database.model.SearchHistoryEntity

/**
 * @author  : Javid
 * @summary : AppDatabase
 */

@Database(
    entities = [
        SearchHistoryEntity::class,
        CharacterVideoEntity::class,
        PropertiesEntity::class,
        PropertiesDetailEntity::class,
        CharacterVideoDetailEntity::class
    ],
    version = 1
)
@TypeConverters(CharacterVideoTypeConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun characterDao(): CharacterDao
    abstract fun searchHistoryDao(): SearchHistoryDao
}