package jaesung.project.architecturepractice.data

import jaesung.project.architecturepractice.data.network.model.NetworkResult
import retrofit2.HttpException
import retrofit2.Response

suspend fun <T: Any> handleApi(
    execute: () -> Response<T>,
): NetworkResult<T> {

    return try {
        val response = execute()
        val body = response.body()
        if (response.isSuccessful && body != null) {
            NetworkResult.Success(response.code(), body)
        } else {
            NetworkResult.Error(code = response.code(), message = response.message())
        }
    } catch (e: HttpException) {
        NetworkResult.Error(code = e.code(), message = e.message())
    } catch (e: Throwable) {
        NetworkResult.Exception(e)
    }
}