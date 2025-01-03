package ir.javid.satttar.snapfood.data.repository

import ir.javid.satttar.snapfood.data.database.AppDao
import ir.javid.satttar.snapfood.data.database.model.toDomain
import ir.javid.satttar.snapfood.data.network.NetworkDataSource
import ir.javid.satttar.snapfood.domain.model.Video
import ir.javid.satttar.snapfood.domain.repository.VideoRepository
import javax.inject.Inject

/**
 * @author  : Javid
 * @summary : VideoRepositoryImpl
 */

class VideoRepositoryImpl @Inject constructor(
    private val remote: NetworkDataSource,
    private val dao: AppDao,
) : VideoRepository {

    override suspend fun detailVideo(id: Int):Video {
        return remote.getVideo(id) ?: Video(0,"no")
    }

    override suspend fun getAllVideos():List<Video> {
        return remote.getAllVideo(1) ?: listOf()
    }
}