package py.com.basicexampleandroid.data.helper

import okhttp3.ResponseBody
import py.com.basicexampleandroid.domain.Resource
import retrofit2.HttpException

suspend fun <T : Any> handleRequest(requestFunc: suspend () -> T): Resource<T> {
    return try {
        Resource.Success(requestFunc.invoke())
    } catch (e: HttpException) {
        val error = APIError.fromBytes((e.response()?.errorBody()) as ResponseBody)
        Resource.Error(
            error = error
        )
    } catch (e: Exception) {
        Resource.Error(
            error = APIError()
        )
    }
}