package com.example.myapplication.ui.messageList

import android.content.ContentValues
import android.graphics.Bitmap
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.UserHandler
import com.example.myapplication.model.MessageListObj
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class MessageListViewModel : ViewModel() {

    private var _text = MutableLiveData<String>().apply {
        value = "This is MessageListViewModel Fragment"
    }
    private val _eee = MutableLiveData<String>().apply {
        value = "This is MessageListViewModel Fragment 33333"
    }
    private val _messageListDataSet =MutableLiveData<List<MessageListObj>>().apply {
        value = mutableListOf()
    }

    fun login() {
        // Create a new coroutine to move the execution off the UI thread
        viewModelScope.launch(Dispatchers.IO) {
//            val jsonBody = "{ username: \"$username\", token: \"$token\"}"
//            loginRepository.makeLoginRequest(jsonBody)

            var bbbb = UserHandler().getSingleUser("p2iaBDZSwHUb0VTJwDHqJRatCp23")
//_text.value = "dkkdkdkd"
            Log.d("TAG", "eeeee is $bbbb")

        }
    }

    fun launchDataLoad() {

        val teststrArr: MutableList<String> = mutableListOf<String>("p2iaBDZSwHUb0VTJwDHqJRatCp23","djejeenejff")
        val returnArray = mutableListOf<MessageListObj>()

        viewModelScope.launch {
//            sortList()
            // Modify UI

            for (item : String in teststrArr ){

                var ggg = UserHandler().getSingleUser(item)

                var mlistObjtooAdd = ggg?.let { MessageListObj(it,it,it,it) }
                if (mlistObjtooAdd != null) {
                    returnArray.add(mlistObjtooAdd)
                }
                Log.d(ContentValues.TAG, "DocumentSnapshosssssst data: ${ggg}")

            }
//            var ggg = UserHandler().getSingleUser("p2iaBDZSwHUb0VTJwDHqJRatCp23")
            _messageListDataSet.value = returnArray
        }
    }
    suspend fun sortList() = withContext(Dispatchers.Default) {
        // Heavy work
    }
    val text: LiveData<String> = _text
    val eeetext: LiveData<String> = _eee
    val mListDataSet = _messageListDataSet
}