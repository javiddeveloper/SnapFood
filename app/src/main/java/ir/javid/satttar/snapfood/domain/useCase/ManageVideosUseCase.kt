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
    suspend fun searchCharacters(query: String) = repository.searchCharacters(query)
    suspend fun getCharacterDetails(characterId: String) =
        repository.getCharacterDetails(characterId)
}