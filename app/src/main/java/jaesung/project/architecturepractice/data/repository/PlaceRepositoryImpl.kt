package jaesung.project.architecturepractice.data.repository

import jaesung.project.architecturepractice.data.network.model.NetworkResult
import jaesung.project.architecturepractice.data.datasource.source.PlaceDataSource
import jaesung.project.architecturepractice.data.mapper.PlaceMapper.mapResponseDataToPlaceEntity
import jaesung.project.architecturepractice.domain.model.PlaceData
import jaesung.project.architecturepractice.domain.repository.PlaceRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import timber.log.Timber

class PlaceRepositoryImpl(private val dataSource: PlaceDataSource) : PlaceRepository {

    override fun getPlace(): Flow<NetworkResult<PlaceData>> = flow {
        try {
            val response = dataSource.getPlace()
            val body = response.body()

            Timber.e("$response")
            Timber.e("$body")

            if (response.isSuccessful && body != null) {
                Timber.e("A")
                Timber.e("$body")
                if (body.status == 200) {
                    Timber.e("200")
                    val mappedBody = mapResponseDataToPlaceEntity(body.data)
                    Timber.e("$mappedBody")
                    emit(NetworkResult.Success(code = body.status, mappedBody))
                }
//                } else if (body.status == 400) {
//                    Timber.e("400")
//                    emit(NetworkResult.Success(code = body.status))
//                }
            }
        } catch (e: HttpException) {
            Timber.e("C")
            emit(NetworkResult.Error(code = e.code(), message = e.message()))
        } catch (e: Throwable) {
            Timber.e("D")
            emit(NetworkResult.Exception(e))
        }
    }
}