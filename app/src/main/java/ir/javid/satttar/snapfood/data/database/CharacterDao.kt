package ir.javid.satttar.snapfood.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import ir.javid.satttar.snapfood.data.database.model.CharacterVideoDetailEntity
import ir.javid.satttar.snapfood.data.database.model.CharacterVideoEntity
import ir.javid.satttar.snapfood.data.database.model.CharacterWithDetailsEntity

/**
 * @author  : Javid
 * @summary : CharacterDao
 */

@Dao
interface CharacterDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertCharacterVideo(characterVideoEntity: CharacterVideoEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertCharacterVideoDetail(characterVideoEntity: CharacterVideoDetailEntity)

    @Query("SELECT * FROM CharacterVideoEntity")
    suspend fun getAllCharacters(): List<CharacterVideoEntity>?

    @Query("SELECT * FROM CharacterVideoDetailEntity where uid = :uid limit 1")
    suspend fun getCharacterVideoDetail(uid:String): CharacterVideoDetailEntity?

    @Query("SELECT * FROM CharacterVideoEntity where uid = :uid limit 1")
    suspend fun getCharacterVideo(uid:String): CharacterVideoEntity?

    @Transaction
    @Query("SELECT * FROM CharacterVideoEntity WHERE uid = :uid")
    suspend fun getCharacterWithDetails(uid: String): CharacterWithDetailsEntity?

    @Delete
    suspend fun removeCharacterVideo(characterVideoEntity: CharacterVideoEntity)

    @Delete
    suspend fun removeCharacterVideoDetail(characterVideoDetailEntity: CharacterVideoDetailEntity)
}