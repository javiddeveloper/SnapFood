package ir.javid.satttar.snapfood.domain.repository

import ir.javid.satttar.snapfood.domain.model.CharacterVideo
import ir.javid.satttar.snapfood.domain.model.CharacterWithDetails
import kotlinx.coroutines.flow.Flow

/**
 * @author  : Javid
 * @summary : VideoRepository
 */

interface VideoRepository {
     suspend fun searchCharacters(query: String): Flow<List<CharacterVideo>>
     suspend fun getCharacterDetails(characterId: String): Flow<CharacterWithDetails>
}