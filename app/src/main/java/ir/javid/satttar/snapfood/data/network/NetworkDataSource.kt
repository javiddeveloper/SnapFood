package ir.javid.satttar.snapfood.data.network

import io.ktor.client.HttpClient
import ir.javid.satttar.snapfood.data.network.tools.apiSafeCall
import ir.javid.satttar.snapfood.domain.model.Video
import javax.inject.Inject

/**
 * @author  : Javid
 * @summary : NetworkDataSource
 */

class NetworkDataSource @Inject constructor(
    private val httpClient: HttpClient
) {
    suspend fun getAllVideo(page: Int, limit: Int = 10): List<Video>? {
        return apiSafeCall<List<Video>>(
            httpClient, url = "people/",
            queryParams = mapOf("page" to "$page", "limit" to "$limit")
        )
    }
    suspend fun getVideo(id: Int): Video? {
        return apiSafeCall<Video>(
            httpClient, url = "people/{id}",
            pathParams = mapOf("id" to "$id")
        )
    }
}