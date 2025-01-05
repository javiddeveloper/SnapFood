package ir.javid.satttar.snapfood.domain.model

/**
 * @author  : Javid
 * @summary : CharacterVideo
 */

data class CharacterVideo(
    val properties: Properties,
    val description: String,
    val uid: String,
    val id: String
)

data class Properties(
    val height: String,
    val mass: String,
    val hairColor: String,
    val skinColor: String,
    val eyeColor: String,
    val birthYear: String,
    val gender: String,
    val created: String,
    val edited: String,
    val name: String,
    val homeworld: String,
    val url: String
)

