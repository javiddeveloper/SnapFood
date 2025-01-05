package ir.javid.satttar.snapfood.data.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import ir.javid.satttar.snapfood.domain.model.CharacterVideoDetail
import ir.javid.satttar.snapfood.domain.model.PropertiesDetail

/**
 * @author  : Javid
 * @summary : CharacterVideoDetailEntity
 */

@Entity
data class CharacterVideoDetailEntity(
    @PrimaryKey(autoGenerate = true)
    val dbId: Int,
    @ColumnInfo(name = "uid")
    val uid: String,
    val id: String,
    val description: String,
    val properties: PropertiesDetailEntity,
)

@Entity
data class PropertiesDetailEntity(
    @PrimaryKey(autoGenerate = true)
    val dbId: Int,
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


fun CharacterVideoDetailEntity.toDomainModel() = CharacterVideoDetail(
    v = 0,
    id = id,
    description = description,
    properties = properties.toDomainModel(),
    uid = uid,
)

fun PropertiesDetailEntity.toDomainModel() = PropertiesDetail(
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
