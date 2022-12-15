package com.example.myapplication.ui.messageList

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class MessageListViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is MessageListViewModel Fragment"
    }
    private val _eee = MutableLiveData<String>().apply {
        value = "This is MessageListViewModel Fragment 33333"
    }
    val text: LiveData<String> = _text
    val eeetext: LiveData<String> = _eee

}