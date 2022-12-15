package com.example.myapplication.ui.profiles.heroProfile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel



class HeroProfileViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is profile Fragment"
    }
    private val _eee = MutableLiveData<String>().apply {
        value = "This is profille Fragment 33333"
    }
    val text: LiveData<String> = _text
    val eeetext: LiveData<String> = _eee

}