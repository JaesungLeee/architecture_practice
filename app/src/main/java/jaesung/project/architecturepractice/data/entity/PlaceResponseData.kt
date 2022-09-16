package jaesung.project.architecturepractice.data.entity

import com.google.gson.annotations.SerializedName

data class PlaceResponseData(
    @SerializedName("place_tag") val placeTag: String,
    @SerializedName("place") val placeInfoList: List<PlaceEntity>
)
