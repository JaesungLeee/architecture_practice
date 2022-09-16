package jaesung.project.architecturepractice.data.network

import jaesung.project.architecturepractice.data.network.model.BaseResponse
import jaesung.project.architecturepractice.data.entity.PlaceResponseData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("place/location")
    suspend fun getPlace(
        @Query("locationCategory") locationCategory: String = "강릉"
    ): Response<BaseResponse<PlaceResponseData>>
}