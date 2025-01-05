package ir.javid.satttar.snapfood.data.network.model

import com.google.gson.annotations.SerializedName
import ir.javid.satttar.snapfood.data.database.model.CharacterVideoEntity
import ir.javid.satttar.snapfood.data.database.model.PropertiesEntity
import ir.javid.satttar.snapfood.domain.model.CharacterVideo
import ir.javid.satttar.snapfood.domain.model.Properties

/**
 * @author  : Javid
 * @summary : CharacterVideoDto
 */

data class CharacterVideoDto(
    @SerializedName("properties") val properties: PropertiesDto,
    @SerializedName("description") val description: String,
    @SerializedName("_id") val id: String,
    @SerializedName("uid") val uid: String,
)

data class PropertiesDto(
    @SerializedName("height") val height: String,
    @SerializedName("mass") val mass: String,
    @SerializedName("hair_color") val hairColor: String,
    @SerializedName("skin_color") val skinColor: String,
    @SerializedName("eye_color") val eyeColor: String,
    @SerializedName("birth_year") val birthYear: String,
    @SerializedName("gender") val gender: String,
    @SerializedName("created") val created: String,
    @SerializedName("edited") val edited: String,
    @SerializedName("name") val name: String,
    @SerializedName("homeworld") val homeworld: String,
    @SerializedName("url") val url: String
)


fun CharacterVideoDto.toDomainModel() = CharacterVideo(
    properties = properties.toDomainModel(),
    description = description,
    id = id,
    uid = uid,
)

fun PropertiesDto.toDomainModel() = Properties(
    height = height,
    mass = mass,
    hairColor = hairColor,
    skinColor = skinColor,
    eyeColor = eyeColor,
    birthYear = birthYear,
    gender = gender,
    created = created,
    edited = edited,
    name = name,
    homeworld = homeworld,
    url = url,
)

fun CharacterVideo.toEntity() = CharacterVideoEntity(
    properties = properties.toEntity(),
    description = description,
    id = id,
    uid = uid,
    dbId = 0,
)

fun Properties.toEntity() = PropertiesEntity(
    height = height,
    mass = mass,
    hairColor = hairColor,
    skinColor = skinColor,
    eyeColor = eyeColor,
    birthYear = birthYear,
    gender = gender,
    created = created,
    edited = edited,
    name = name,
    homeworld = homeworld,
    url = url,
    dbId = 0
)

