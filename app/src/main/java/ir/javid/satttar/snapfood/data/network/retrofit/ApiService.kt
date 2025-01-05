package ir.javid.satttar.snapfood.data.network.retrofit

import ir.javid.satttar.snapfood.data.network.model.CharacterVideoDetailDto
import ir.javid.satttar.snapfood.data.network.model.CharacterVideoDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * @author  : Javid
 * @summary : ApiService
 */

interface ApiService {

        @GET("people")
        suspend fun searchCharacters(@Query("name") query: String): Response<BaseResponse<List<CharacterVideoDto>>>

        @GET("people/{id}")
        suspend fun getCharacterDetails(@Path("id") characterId: String): Response<BaseResponse<CharacterVideoDetailDto>>
}