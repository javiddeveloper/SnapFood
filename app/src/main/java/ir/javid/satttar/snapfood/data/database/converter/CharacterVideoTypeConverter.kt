package ir.javid.satttar.snapfood.data.database.converter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import ir.javid.satttar.snapfood.data.database.model.PropertiesDetailEntity
import ir.javid.satttar.snapfood.data.database.model.PropertiesEntity

/**
 * @author  : Javid
 * @summary : CharacterVideoTypeConverter
 */

class CharacterVideoTypeConverter {

    private val gson = Gson()

    @TypeConverter
    fun fromPropertiesEntity(propertiesEntity: PropertiesEntity): String {
        return gson.toJson(propertiesEntity)
    }

    @TypeConverter
    fun toPropertiesEntity(propertiesJson: String): PropertiesEntity {
        val type = object : TypeToken<PropertiesEntity>() {}.type
        return gson.fromJson(propertiesJson, type)
    }
    @TypeConverter
    fun fromPropertiesDetailEntity(propertiesEntity: PropertiesDetailEntity): String {
        return gson.toJson(propertiesEntity)
    }

    @TypeConverter
    fun toPropertiesDetailEntity(propertiesJson: String): PropertiesDetailEntity {
        val type = object : TypeToken<PropertiesDetailEntity>() {}.type
        return gson.fromJson(propertiesJson, type)
    }
}