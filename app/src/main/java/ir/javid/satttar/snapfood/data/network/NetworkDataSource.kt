package ir.javid.satttar.snapfood.data.network

import ir.javid.satttar.snapfood.data.network.model.CharacterVideoDetailDto
import ir.javid.satttar.snapfood.data.network.model.CharacterVideoDto
import ir.javid.satttar.snapfood.data.network.retrofit.ApiService
import ir.javid.satttar.snapfood.data.network.tools.safeApiCall
import javax.inject.Inject

/**
 * @author  : Javid
 * @summary : NetworkDataSource
 */

class NetworkDataSource @Inject constructor(
    private val api: ApiService
) {
    suspend fun searchCharacters(query: String): List<CharacterVideoDto> {
        return safeApiCall {
            api.searchCharacters(query)
        }

    }

    suspend fun getCharacterDetails(characterId: String): CharacterVideoDetailDto {
        return safeApiCall {
            api.getCharacterDetails(characterId)
        }
    }

}
