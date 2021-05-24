package com.emob.etraderdemo.ui.viewmodel

import androidx.lifecycle.viewModelScope
import com.emob.etraderdemo.core.base.BaseViewModel
import com.emob.etraderdemo.data.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val mainRepository: MainRepository,
) :   BaseViewModel() {



     fun fetchUsers() {
        viewModelScope.launch {
                mainRepository.getUsers().let {
                    if (it.isSuccessful && it != null ) {
                       onSuccess(
                           MainViewState.GetUser(
                               it.body()!!
                           )
                       )
                    } else  onError((it.errorBody().toString()))
                }
            }
        }
    }
