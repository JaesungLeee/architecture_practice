package jaesung.project.architecturepractice.domain.repository

import jaesung.project.architecturepractice.data.network.model.NetworkResult
import jaesung.project.architecturepractice.domain.model.PlaceData
import kotlinx.coroutines.flow.Flow

interface PlaceRepository {

    fun getPlace(): Flow<NetworkResult<PlaceData>>
}