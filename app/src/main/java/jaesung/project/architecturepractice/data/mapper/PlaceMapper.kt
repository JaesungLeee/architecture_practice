package jaesung.project.architecturepractice.data.mapper

import jaesung.project.architecturepractice.data.entity.PlaceResponseData
import jaesung.project.architecturepractice.domain.model.PlaceData
import jaesung.project.architecturepractice.domain.model.Place

object PlaceMapper {

    fun mapResponseDataToPlaceEntity(body: PlaceResponseData): PlaceData {
        return PlaceData(
            placeTag = body.placeTag,
            placeList = body.placeInfoList.map { place ->
                Place(
                    placeId = place.placeId,
                    placeName = place.placeName,
                    placeAddress = place.placeAddress,
                    placeWeekendTime = place.placeWeekendTime,
                    placeWeekTime = place.placeWeekTime,
                    placeImageUrl = place.placeImageUrl
                )
            }
        )

    }
}