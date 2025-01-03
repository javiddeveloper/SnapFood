package ir.javid.satttar.snapfood.domain.useCase

import ir.javid.satttar.snapfood.domain.repository.VideoRepository
import javax.inject.Inject

/**
 * @author  : Javid
 * @summary : ManageVideosUseCase
 */

class ManageVideosUseCase @Inject constructor(
    private val repository: VideoRepository
) {
    suspend fun detailVideo(id: Int) = repository.detailVideo(id)
    suspend fun getAllVideos() = repository.getAllVideos()
}