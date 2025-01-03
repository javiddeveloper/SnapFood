package ir.javid.satttar.snapfood.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import ir.javid.satttar.snapfood.data.database.model.VideoEntity

/**
 * @author  : Javid
 * @summary : AppDatabase
 */

@Database(
    entities = [VideoEntity::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun appDao(): AppDao
}