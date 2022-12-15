package com.example.myapplication.ui.settings

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class SettingsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is settings Fragment"
    }
    private val _eee = MutableLiveData<String>().apply {
        value = "This is settings Fragment 33333"
    }
    val text: LiveData<String> = _text
    val eeetext: LiveData<String> = _eee

}