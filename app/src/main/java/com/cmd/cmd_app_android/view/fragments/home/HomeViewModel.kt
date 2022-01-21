package com.cmd.cmd_app_android.view.fragments.home

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

@HiltViewModel
class HomeViewModel constructor(
    private val value: String
) : ViewModel() {

    private val _state = MutableStateFlow<String>("")
    val state = _state.asStateFlow()
}