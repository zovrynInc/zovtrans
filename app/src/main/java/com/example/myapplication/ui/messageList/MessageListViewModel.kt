package com.example.myapplication.ui.messageList

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.UserHandler
import com.example.myapplication.model.MessageListObj
import com.example.myapplication.model.MessageListRecyclerViewElement
import com.example.myapplication.model.UserObj
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class MessageListViewModel : ViewModel() {

    private var _text = MutableLiveData<String>().apply {
        value = "This is MessageListViewModel Fragment"
    }
    private val _msgListArr = MutableLiveData<MutableList<MessageListObj>  >().apply {
        value = mutableListOf()
    }
    private val _userObjArr = MutableLiveData< MutableList<UserObj> >().apply {
        value = mutableListOf()
    }
    private val _messageListDataSet =MutableLiveData<MutableList<MessageListObj>>().apply {
        value = mutableListOf()
    }

    fun login() {
        // Create a new coroutine to move the execution off the UI thread
        viewModelScope.launch(Dispatchers.IO) {
//            val jsonBody = "{ username: \"$username\", token: \"$token\"}"
//            loginRepository.makeLoginRequest(jsonBody)

            var bbbb = UserHandler().getSingleUserAndProfilePic("p2iaBDZSwHUb0VTJwDHqJRatCp23")
//_text.value = "dkkdkdkd"
            Log.d("TAG", "eeeee is $bbbb")

        }
    }

    private val db = Firebase.firestore





    fun launchDataLoad() {
        val testArr : MutableList<MessageListRecyclerViewElement> = mutableListOf()
        val teststrArr: MutableList<String> = mutableListOf<String>("p2iaBDZSwHUb0VTJwDHqJRatCp23","djejeenejff")
        val returnArray = mutableListOf<MessageListObj>()

        viewModelScope.launch {


            var odidi = UserHandler().getMessageList("p2iaBDZSwHUb0VTJwDHqJRatCp23") //.getMessageList("p2iaBDZSwHUb0VTJwDHqJRatCp23")
//            _messageListDataSet.value = bbb

//            Log.d(ContentValues.TAG, "DocumentSnapshosssssst data: ${odidi}")

            val kkkkkk = listOf<String>("dpdpdddpp","ddididi")
//            for (key:DocumentSnapshot in bbb){
//
//            }
//            sortList()
            // Modify UI

//            for (item : String in teststrArr ){
//
//                var ggg = UserHandler().getSingleUser(item)
//
//                var mlistObjtooAdd = ggg?.let { MessageListObj(it,it,it,it) }
//                if (mlistObjtooAdd != null) {
//                    returnArray.add(mlistObjtooAdd)
//                }
//                Log.d(ContentValues.TAG, "DocumentSnapshosssssst data: ${ggg}")
//
//            }
////            var ggg = UserHandler().getSingleUser("p2iaBDZSwHUb0VTJwDHqJRatCp23")
//            _messageListDataSet.value = returnArray


        }
    }
    suspend fun sortList() = withContext(Dispatchers.Default) {
        // Heavy work
    }
    val text: LiveData<String> = _text
    val eeetext: LiveData<MutableList<MessageListObj>> = _msgListArr
    val tmparr: LiveData<MutableList<UserObj>> = _userObjArr

    val mListDataSet = _messageListDataSet
}