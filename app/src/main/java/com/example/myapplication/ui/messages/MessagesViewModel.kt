package com.example.myapplication.ui.messages

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.R
import com.example.myapplication.model.Affirmation

class MessagesViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is messages Fragment"
    }
    private val _eee = MutableLiveData<String>().apply {
        value = "This is messages Fragment 33333"
    }


    val text: LiveData<String> = _text
    val eeetext: LiveData<String> = _eee

}