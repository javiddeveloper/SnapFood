package ir.javid.satttar.snapfood.data.database.model

import androidx.room.Embedded
import androidx.room.Relation
import ir.javid.satttar.snapfood.domain.model.CharacterWithDetails

/**
 * @author  : Javid
 * @summary : CharacterWithDetailsEntity
 */

data class CharacterWithDetailsEntity(
    @Embedded val character: CharacterVideoEntity,
    @Relation(
        parentColumn = "uid",
        entityColumn = "uid"
    )
    val videoDetails: CharacterVideoDetailEntity?
)


fun CharacterWithDetailsEntity.toDomainModel() = CharacterWithDetails(
    character = character.toDomainModel(),
    videoDetails = videoDetails?.toDomainModel()
)





