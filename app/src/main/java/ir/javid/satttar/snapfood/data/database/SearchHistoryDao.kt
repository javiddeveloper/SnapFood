package ir.javid.satttar.snapfood.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import ir.javid.satttar.snapfood.data.database.model.SearchHistoryEntity

/**
 * @author  : Javid
 * @summary : SearchHistoryDao
 */

@Dao
interface SearchHistoryDao {
    @Insert
    suspend fun insertSearch(searchHistoryEntity: SearchHistoryEntity)

    @Query("SELECT * FROM SearchHistoryEntity")
    suspend fun getSearchHistory(): List<SearchHistoryEntity>

    @Delete
    suspend fun removeSearchHistory(searchHistoryEntity: SearchHistoryEntity)
}