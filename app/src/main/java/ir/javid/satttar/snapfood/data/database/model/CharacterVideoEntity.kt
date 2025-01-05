package ir.javid.satttar.snapfood.data.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import ir.javid.satttar.snapfood.domain.model.CharacterVideo
import ir.javid.satttar.snapfood.domain.model.Properties

/**
 * @author  : Javid
 * @summary : CharacterVideoEntity
 */

@Entity
data class CharacterVideoEntity(
    @PrimaryKey(autoGenerate = true)
    val dbId: Int,
    @ColumnInfo(name = "uid")
    val uid: String,
    val id: String,
    @ColumnInfo(name = "properties")
    val properties: PropertiesEntity,
    val description: String,
)

@Entity
data class PropertiesEntity(
    @PrimaryKey(autoGenerate = true)
    val dbId: Int,
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

fun CharacterVideoEntity.toDomainModel() = CharacterVideo(
    properties = properties.toDomainModel(),
    description = description,
    uid = uid,
    id = id,
)

fun PropertiesEntity.toDomainModel() = Properties(
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