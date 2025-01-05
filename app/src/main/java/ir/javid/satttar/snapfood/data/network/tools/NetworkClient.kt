package ir.javid.satttar.snapfood.data.network.tools

import ir.javid.satttar.snapfood.data.network.retrofit.BaseResponse
import retrofit2.Response

/**
 * @author  : Javid
 * @summary : NetworkClient
 */


suspend fun <T : Any> safeApiCall(
    execute: suspend () -> Response<BaseResponse<T>>
): T {
    val response = execute()
    if (response.isSuccessful) {
        val body = response.body()
        if (body != null) {
            val message = body.message
            val result = body.result
            return result
        } else {
            throw Exception("Response body is null")
        }
    } else {
        throw Exception("API call failed with error: ${response.code()} - ${response.message()}")
    }

}

