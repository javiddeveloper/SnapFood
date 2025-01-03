package ir.javid.satttar.snapfood.data.network.tools

/**
 * @author  : Javid
 * @summary : ApiTools
 */

import android.util.Log
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.plugins.ServerResponseException
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*

const val API_ERROR = "API_ERROR"
suspend inline fun <reified T> apiSafeCall(
    client: HttpClient,
    url: String,
    pathParams: Map<String, String> = emptyMap(),
    queryParams: Map<String, String> = emptyMap()
): T? {

    val resolvedUrl = pathParams.entries.fold(url) { acc, entry ->
        acc.replace("{${entry.key}}", entry.value)
    }
    return try {
        val response: HttpResponse = client.get(resolvedUrl) {
            queryParams.forEach { (key, value) -> parameter(key, value) }
        }

        if (response.status.isSuccess()) {
            response.body() 
        } else {
            Log.e(API_ERROR,"HTTP Error: ${response.status}")
            null
        }
    } catch (e: ClientRequestException) {
        Log.e(API_ERROR,"Client error: ${e.response.status}")
        null
    } catch (e: ServerResponseException) {
        Log.e(API_ERROR,"Server error: ${e.response.status}")
        null
    } catch (e: Exception) {
        Log.e(API_ERROR,"Unexpected error: ${e.message}")
        null
    }
}
