package com.emob.etraderdemo.ui.viewmodel


sealed class MainViewState {
    class GetUser<T : Any>(val data: T) : MainViewState()

}
