package com.example.myapplication.ui.profiles.otherProfile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class OtherProfileViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is OtherProfile Fragment"
    }
    private val _eee = MutableLiveData<String>().apply {
        value = "This is OtherProfile Fragment 33333"
    }
    val text: LiveData<String> = _text
    val eeetext: LiveData<String> = _eee

}