package jaesung.project.architecturepractice.data.datasource.remote

import jaesung.project.architecturepractice.data.datasource.source.PlaceDataSource
import jaesung.project.architecturepractice.data.network.model.BaseResponse
import jaesung.project.architecturepractice.data.entity.PlaceResponseData
import jaesung.project.architecturepractice.data.network.ApiService
import retrofit2.Response

class PlaceRemoteDataSourceImpl(private val apiService: ApiService) : PlaceDataSource {

    override suspend fun getPlace(): Response<BaseResponse<PlaceResponseData>> {
        return apiService.getPlace()
    }
}