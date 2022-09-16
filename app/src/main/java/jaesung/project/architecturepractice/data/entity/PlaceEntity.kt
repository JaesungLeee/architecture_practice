package jaesung.project.architecturepractice.data.entity

import com.google.gson.annotations.SerializedName

data class PlaceEntity(
    @SerializedName("p_id") val placeId: Long,
    @SerializedName("p_name") val placeName: String,
    @SerializedName("p_addr") val placeAddress: String,
    @SerializedName("p_weekt") val placeWeekTime: String,
    @SerializedName("p_weekndt") val placeWeekendTime: String,
    @SerializedName("p_image") val placeImageUrl: String
)
