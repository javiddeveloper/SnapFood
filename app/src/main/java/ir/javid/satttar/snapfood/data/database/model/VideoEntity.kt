package ir.javid.satttar.snapfood.data.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import ir.javid.satttar.snapfood.domain.model.Video

/**
 * @author  : Javid
 * @summary : VideoEntity
 */

@Entity
data class VideoEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String
)

fun VideoEntity.toDomain() = Video(id=id,name = name)