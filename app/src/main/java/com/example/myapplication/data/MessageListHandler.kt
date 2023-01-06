package com.example.myapplication.data

import android.content.ContentValues
import android.util.Log
import com.example.myapplication.model.MessageListDataObj
import com.example.myapplication.model.MessageListObj
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase

class MessageListHandler {


    fun convertFireStoreMessageListData(documentDataFromFireStore:  MutableMap<String, Any>): MessageListDataObj{
        var objToReturn = MessageListDataObj()

        for((key ,value)in documentDataFromFireStore){
            val uid = key
            val tempMap = value as Map<*, *>
            val lastChecked = tempMap["lastChecked"] as String
            val lastMessage = tempMap["lastMessage"] as String
            objToReturn = MessageListDataObj(key,lastMessage,lastChecked)
            Log.d(ContentValues.TAG, "objToReturn objToReturn: ${objToReturn.uid}")
        }
        return objToReturn
    }
//    private val db = Firebase.firestore
//
//
//    fun getMessageList(uidToLookUp:String): MutableList< MessageListObj?> {
//
//        val messageListToReturn: MutableList< MessageListObj?> = mutableListOf()
//        val docRef = db.collection("MessageList").document("${uidToLookUp}")
//        docRef.get()
//            .addOnSuccessListener { document ->
//                if (document != null) {
//                    val city = document.toObject<MessageListObj>()
//                    var ddodo = document.data
//                    var eee = ddodo?.values
//
//                    if (ddodo != null) {
//                        for((key, value) in ddodo){
//
//                            var vv = value as Map<String, String>
//                            Log.d(ContentValues.TAG, "DocumentSnapshot data2222: ${vv["lastMessage"]}")
//
//                            Log.d(ContentValues.TAG, "DocumentSnapshot data2222: ${key}")
//                            Log.d(ContentValues.TAG, "DocumentSnapshot data2222: ${value["lastChecked"]}")
//                            val newobj = MessageListObj(key,"dodood",value["lastMessage"],value["lastChecked"])
//                            messageListToReturn.add((newobj))
////                            println(value.age)
//                        }
//                    }
////                    Log.d(ContentValues.TAG, "DocumentSnapshot data2222: ${ddodo}")
////
////                    Log.d(ContentValues.TAG, "DocumentSnapshot data4444: ${eee}")
////                    val data = document.data
////                    val ooooooo = data?.values
////                    val oo = data?.get("65yohZoTfI2ZNzSmI9le") as Map<String,String>
////
////                    Log.d(ContentValues.TAG, "document  $ooooooo")
////
//////                    oo
//////                    for (ele:String in oo){
//////
//////                    }
//                    messageListToReturn.add(city)
////                    var mmapkey = data?.keys
//////                    var teempmo = MessageListObj()
//                } else {
//                    Log.d(ContentValues.TAG, "No such document")
//                }
//            }
//            .addOnFailureListener { exception ->
//                Log.d(ContentValues.TAG, "get failed with ", exception)
//            }
//
//        return messageListToReturn
//    }

}