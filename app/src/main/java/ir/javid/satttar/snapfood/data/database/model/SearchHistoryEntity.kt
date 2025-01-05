package ir.javid.satttar.snapfood.data.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import ir.javid.satttar.snapfood.domain.model.SearchHistory

/**
 * @author  : Javid
 * @summary : SearchHistoryEntity
 */

@Entity
data class SearchHistoryEntity(
    @PrimaryKey(autoGenerate = true)
    val dbId: Int,
    val query: String,
    val time: Long
)


fun SearchHistoryEntity.toDomainModel() = SearchHistory(
    dbId = dbId,
    query = query,
    time = time,
)