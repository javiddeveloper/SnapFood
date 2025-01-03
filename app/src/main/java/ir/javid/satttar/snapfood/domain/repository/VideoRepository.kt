package ir.javid.satttar.snapfood.domain.repository

import ir.javid.satttar.snapfood.domain.model.Video

/**
 * @author  : Javid
 * @summary : VideoRepository
 */

interface VideoRepository {
     suspend fun detailVideo(id: Int): Video
     suspend fun getAllVideos():List<Video>
}