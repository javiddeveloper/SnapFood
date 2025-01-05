package ir.javid.satttar.snapfood.data.repository

import ir.javid.satttar.snapfood.data.database.CharacterDao
import ir.javid.satttar.snapfood.data.database.SearchHistoryDao
import ir.javid.satttar.snapfood.data.database.model.toDomainModel
import ir.javid.satttar.snapfood.data.network.NetworkDataSource
import ir.javid.satttar.snapfood.data.network.model.CharacterVideoDetailDto
import ir.javid.satttar.snapfood.data.network.model.CharacterVideoDto
import ir.javid.satttar.snapfood.data.network.model.toDomainModel
import ir.javid.satttar.snapfood.data.network.model.toEntity
import ir.javid.satttar.snapfood.data.repository.patterns.NetworkBoundResource
import ir.javid.satttar.snapfood.domain.model.CharacterVideo
import ir.javid.satttar.snapfood.domain.model.CharacterWithDetails
import ir.javid.satttar.snapfood.domain.repository.VideoRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * @author  : Javid
 * @summary : VideoRepositoryImpl
 */

class VideoRepositoryImpl @Inject constructor(
    private val remote: NetworkDataSource,
    private val characterDao: CharacterDao,
    private val searchHistoryDao: SearchHistoryDao,
) : VideoRepository {

    override suspend fun searchCharacters(query: String): Flow<List<CharacterVideo>> {
        return object : NetworkBoundResource<List<CharacterVideo>, List<CharacterVideoDto>>() {

            override suspend fun fetchFromLocal(): List<CharacterVideo>? {
                return characterDao.getAllCharacters()?.map { it.toDomainModel() }
            }

            override suspend fun fetchFromNetwork(): List<CharacterVideoDto> {
                return remote.searchCharacters(query)
            }

            override suspend fun saveNetworkResult(item: List<CharacterVideoDto>) {
                val entities = item.map { it.toDomainModel().toEntity() }
                entities.map {
                    characterDao.upsertCharacterVideo(it)
                }
            }
        }.asFlow()
    }
    override suspend fun getCharacterDetails(characterId: String): Flow<CharacterWithDetails> {
        return object : NetworkBoundResource<CharacterWithDetails, CharacterVideoDetailDto>() {

            override suspend fun fetchFromLocal(): CharacterWithDetails? {
                val entity = characterDao.getCharacterWithDetails(characterId)
                return entity?.toDomainModel()
            }

            override suspend fun fetchFromNetwork(): CharacterVideoDetailDto {
                return remote.getCharacterDetails(characterId)
            }

            override suspend fun saveNetworkResult(item: CharacterVideoDetailDto) {
                val entity = item.toDomainModel().toEntity()
                characterDao.upsertCharacterVideoDetail(entity)
            }
        }.asFlow()
    }
}