package ir.javid.satttar.snapfood.domain.model


/**
 * @author  : Javid
 * @summary : CharacterVideoDetail
 */

data class CharacterVideoDetail(
    val v: Int,
    val id: String,
    val description: String,
    val properties: PropertiesDetail,
    val uid: String
)

data class PropertiesDetail(
    val climate: String?,
    val created: String,
    val diameter: String?,
    val edited: String,
    val gravity: String?,
    val name: String,
    val orbitalPeriod: String?,
    val population: String?,
    val rotationPeriod: String?,
    val surfaceWater: String?,
    val terrain: String?,
    val url: String
)