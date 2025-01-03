package ir.javid.satttar.snapfood.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import ir.javid.satttar.snapfood.data.database.model.VideoEntity

/**
 * @author  : Javid
 * @summary : AppDao
 */

@Dao
interface AppDao {
    @Insert
    suspend fun insertVideo(video: VideoEntity)

    @Query("SELECT * FROM VideoEntity")
    suspend fun getAllVideos(): List<VideoEntity>

    @Query("SELECT * FROM VideoEntity where id = :id limit 1")
    suspend fun getVideo(id:Int): VideoEntity

    @Delete
    suspend fun removeVideo(video: VideoEntity)
}