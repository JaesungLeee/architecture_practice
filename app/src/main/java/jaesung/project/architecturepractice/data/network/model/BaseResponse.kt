package jaesung.project.architecturepractice.data.network.model

import com.google.gson.annotations.SerializedName

data class BaseResponse<T>(
    @SerializedName("message") val message: String,
    @SerializedName("status") val status: Int,
    @SerializedName("data") val data: T
)
