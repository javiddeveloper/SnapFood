package ir.javid.satttar.snapfood.data.network.model

import com.google.gson.annotations.SerializedName
import ir.javid.satttar.snapfood.data.database.model.CharacterVideoDetailEntity
import ir.javid.satttar.snapfood.data.database.model.PropertiesDetailEntity
import ir.javid.satttar.snapfood.domain.model.CharacterVideoDetail
import ir.javid.satttar.snapfood.domain.model.PropertiesDetail

/**
 * @author  : Javid
 * @summary : CharacterVideoDetailDto
 */

data class CharacterVideoDetailDto(
    @SerializedName("__v") val v: Int,
    @SerializedName("_id") val id: String,
    @SerializedName("description") val description: String,
    @SerializedName("properties") val properties: PropertiesDetailDto,
    @SerializedName("uid") val uid: String
)

data class PropertiesDetailDto(
    @SerializedName("climate") val climate: String?,
    @SerializedName("created") val created: String,
    @SerializedName("diameter") val diameter: String?,
    @SerializedName("edited") val edited: String,
    @SerializedName("gravity") val gravity: String?,
    @SerializedName("name") val name: String,
    @SerializedName("orbital_period") val orbitalPeriod: String?,
    @SerializedName("population") val population: String?,
    @SerializedName("rotation_period") val rotationPeriod: String?,
    @SerializedName("surface_water") val surfaceWater: String?,
    @SerializedName("terrain") val terrain: String?,
    @SerializedName("url") val url: String
)


fun CharacterVideoDetailDto.toDomainModel() = CharacterVideoDetail(
    v = v,
    id = id,
    description = description,
    properties = properties.toDomainModel(),
    uid = uid,
)

fun PropertiesDetailDto.toDomainModel() = PropertiesDetail(
    climate = climate,
    created = created,
    diameter = diameter,
    edited = edited,
    gravity = gravity,
    name = name,
    orbitalPeriod = orbitalPeriod,
    population = population,
    rotationPeriod = rotationPeriod,
    surfaceWater = surfaceWater,
    terrain = terrain,
    url = url,
)

fun CharacterVideoDetail.toEntity() = CharacterVideoDetailEntity(
    id = id,
    description = description,
    properties = properties.toEntity(),
    uid = uid,
    dbId = 0
)

fun PropertiesDetail.toEntity() = PropertiesDetailEntity(
    climate = climate,
    created = created,
    diameter = diameter,
    edited = edited,
    gravity = gravity,
    name = name,
    orbitalPeriod = orbitalPeriod,
    population = population,
    rotationPeriod = rotationPeriod,
    surfaceWater = surfaceWater,
    terrain = terrain,
    url = url,
    dbId = 0
)
