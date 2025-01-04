package py.com.basicexampleandroid.presentation.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import py.com.basicexampleandroid.data.helper.APIError

open class BaseViewModel: ViewModel() {

    val isLoading: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>()
    }

    val error: MutableLiveData<APIError> by lazy {
        MutableLiveData<APIError>()
    }
}