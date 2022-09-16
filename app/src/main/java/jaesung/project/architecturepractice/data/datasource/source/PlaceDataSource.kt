package jaesung.project.architecturepractice.data.datasource.source

import jaesung.project.architecturepractice.data.network.model.BaseResponse
import jaesung.project.architecturepractice.data.entity.PlaceResponseData
import retrofit2.Response

interface PlaceDataSource {

    suspend fun getPlace(): Response<BaseResponse<PlaceResponseData>>
}