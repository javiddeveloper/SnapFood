package ir.javid.satttar.snapfood.domain.model

import ir.javid.satttar.snapfood.data.database.model.SearchHistoryEntity

/**
 * @author  : Javid
 * @summary : SearchHistory
 */

data class SearchHistory(
    val dbId: Int,
    val query: String,
    val time: Long
)


fun SearchHistory.toEntityModel() = SearchHistoryEntity(
    dbId = dbId,
    query = query,
    time = time,
)