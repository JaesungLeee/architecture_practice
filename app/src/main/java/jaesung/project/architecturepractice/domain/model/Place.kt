package jaesung.project.architecturepractice.domain.model

data class Place(
    val placeId: Long,
    val placeName: String,
    val placeAddress: String,
    val placeWeekTime: String,
    val placeWeekendTime: String,
    val placeImageUrl: String
)