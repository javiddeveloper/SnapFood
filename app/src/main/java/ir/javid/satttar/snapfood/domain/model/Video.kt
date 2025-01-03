package ir.javid.satttar.snapfood.domain.model

import ir.javid.satttar.snapfood.data.database.model.VideoEntity

/**
 * @author  : Javid
 * @summary : Video
 */

data class Video(
    val id: Int = 0,
    val name: String
)

fun Video.toEntity() = VideoEntity(id= id,name = name)