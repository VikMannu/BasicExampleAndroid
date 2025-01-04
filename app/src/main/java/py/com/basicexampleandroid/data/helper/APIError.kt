package py.com.basicexampleandroid.data.helper

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import okhttp3.ResponseBody

data class APIError(
    @SerializedName("success") val success: Boolean = false,
    @SerializedName("status_code") val statusCode: Int = 0,
    @SerializedName("status_message") val statusMessage: String = "No se pudo completar la solicitud",
) : Throwable() {
    companion object {
        fun fromBytes(body: ResponseBody?): APIError {
            return try {
                val json = String(body?.bytes() ?: byteArrayOf())
                Gson().fromJson(json, APIError::class.java)
            } catch (e: Exception) {
                APIError()
            }
        }
    }
}
