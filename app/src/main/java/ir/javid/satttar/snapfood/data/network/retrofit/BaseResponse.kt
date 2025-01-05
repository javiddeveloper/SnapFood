package ir.javid.satttar.snapfood.data.network.retrofit

import com.google.gson.annotations.SerializedName

/**
 * @author  : Javid
 * @summary : BaseResponse
 */

data class BaseResponse<T>(
    @SerializedName("message") val message: String,
    @SerializedName("result") val result: T
)
