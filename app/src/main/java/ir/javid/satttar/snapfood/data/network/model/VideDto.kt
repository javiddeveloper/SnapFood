package ir.javid.satttar.snapfood.data.network.model

import ir.javid.satttar.snapfood.data.database.model.VideoEntity
import ir.javid.satttar.snapfood.domain.model.Video
import kotlinx.serialization.SerialName

/**
 * @author  : Javid
 * @summary : VideDto
 */


class VideDto(
   @SerialName("name") val name: String
)

fun VideDto.toDomain() = Video(id=0,name = name)
fun VideDto.toEntity() = VideoEntity(id=0,name = name)