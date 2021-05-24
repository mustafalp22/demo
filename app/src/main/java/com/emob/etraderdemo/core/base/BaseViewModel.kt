package com.emob.etraderdemo.core.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.emob.etraderdemo.core.common.toSingleEvent

abstract class BaseViewModel() : ViewModel(){

    private val mUiState = MutableLiveData<ViewState>()
    open val uiState: LiveData<ViewState> = mUiState.toSingleEvent()

    fun <T : Any> onSuccess(result: T) {
        mUiState.value = ViewState.HasData(result)
    }

    protected fun onError(error: String) {
        mUiState.value = ViewState.HasError(error)
    }
}