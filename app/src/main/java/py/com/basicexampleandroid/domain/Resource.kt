package py.com.basicexampleandroid.domain

import py.com.basicexampleandroid.data.helper.APIError

sealed class Resource<T>(val data: T? = null, val error: APIError? = null) {
    class Loading<T>(data: T? = null) : Resource<T>(data)
    class Success<T>(data: T?) : Resource<T>(data)
    class Error<T>(data: T? = null, error: APIError?) : Resource<T>(data, error)
}