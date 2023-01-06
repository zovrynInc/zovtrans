package com.example.myapplication.data

import android.content.ContentValues
import android.content.ContentValues.TAG
import android.graphics.Bitmap
import android.util.Log
import com.example.myapplication.model.MessageListDataObj
import com.example.myapplication.model.MessageListObj
import com.example.myapplication.model.UserObj
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.tasks.await

class UserHandler {
    private val db = Firebase.firestore

    suspend fun expensiveComputation(res: MutableList<String>) {
        delay(1000L)
        res.add("word!")
    }

    fun givenAsyncCoroutine_whenStartIt_thenShouldExecuteItInTheAsyncWay() {
        //given
        val res = mutableListOf<String>()

        //when
        runBlocking {
            launch { expensiveComputation(res) }
            res.add("Hello,")
        }

        //then
//        assertEquals(res, listOf("Hello,", "word!"))
        Log.d(TAG, "No such document")

    }

     fun getSingleUserAndProfilePic(userID:String): UserObj {
//        Log.d(TAG, "func calledd  $userID",)

//       val docRef = db.collection("Users").document("p2iaBDZSwHUb0VTJwDHqJRatCp23")

//       db.collection("Users").document(userID)
//           .get()
//           .addOnSuccessListener { document ->
//               if (document != null) {
//                   var snapData = document.data
//                   Log.d(TAG, "DocumentSnapshot in getSingleUser data: ${snapData}")
//               } else {
//                   Log.d(TAG, "Null doc DocumentSnapshot in getSingleUser ")
//               }
//           }
//           .addOnFailureListener { exception ->
//               Log.d(TAG, "get failed with DocumentSnapshot in getSingleUser  ", exception)
//           }
//        var userToReturn: UserObj? = null

        val docRef = db.collection("Users").document(userID)


       var userObjToReturn = UserObj()



//       var sss = docRef.get().await()
//       val docRef = db.collection("cities").document("BJ")
       docRef.get().addOnSuccessListener { documentSnapshot ->
           val convertedUserObj = documentSnapshot.toObject<UserObj>()
           if(convertedUserObj != null){
               userObjToReturn = convertedUserObj//UserObj(uid2use,userNameToRead)
               Log.d(TAG, "convertted userobj username ${userObjToReturn?.userName ?: "oo"}",)
               var ooflf =  UserHandler().getSingleStorageItem("IMG_5539 2.jpg")
               Log.d(ContentValues.TAG, "gootta bitmaapp  $ooflf")


           }
//            userObjToReturn = city//UserObj(uid2use,userNameToRead)


       }
//       var uid2use = sss.data?.get("uid") as String
//       var userNameToRead = sss.data?.get("userName") as String

//       var userObjToReturn = UserObj(uid2use,userNameToRead)
//       Log.d(TAG, "No such document ${userObjToReturn}",)

       return userObjToReturn
    }

     suspend fun getPlaces(type: String): List<DocumentSnapshot> {
        val querySnapshot = db.collection("Users")
//            .whereEqualTo("type", type)
            .get()
            .await()
        return querySnapshot.documents
    }
    suspend fun getMessageList(uidToLookUp:String):String{

//        var messageListToReturn: MutableList< MessageListObj> = mutableListOf()
        var messageListToReturn = MessageListDataObj()
        var teempstr = "fake syr"
        var userNamesArr: MutableList< UserObj> = mutableListOf()

        val docRef = db.collection("MessageList").document("${uidToLookUp}")
        var fakemap: Bitmap = UtilityFuns().makeEmptyBitMap()
        var fakemessagelistdataobj = MessageListDataObj("www","www","www")
//        viewModelScope.launch {
        docRef.get()

            .addOnSuccessListener { document ->
                if (document != null) {
                    val city = document.toObject<MessageListObj>()
                    var documentData = document.data
                    var eee = documentData?.values

                    if (documentData != null) {
                        var convertedMLDO  = MessageListHandler().convertFireStoreMessageListData(documentData)
                        var uidme =   UserHandler().getSingleUserAndProfilePic(convertedMLDO.uid)

                        Log.d(ContentValues.TAG, "whats this documentData  : ${uidme.userName}")
//                        var ooflf =  UserHandler().getSingleStorageItem("IMG_5539 2.jpg")
//                                                        Log.d(ContentValues.TAG, "gootta bitmaapp  $ooflf")

//                            for((key, value) in documentData){
//                                Log.d(ContentValues.TAG, "whats this key  : $key  and whats value $value")
//
//                                val tempMap = value as Map<*, *>
//                                val tempUserObj = UserObj(tempMap["uid"] as? String ?: "none",tempMap["userName"] as? String  ?: "none")
////                                Log.d(ContentValues.TAG, "DocumentSnapshot data2222: ${tempUserObj["lastMessage"]}")
//
////                                Log.d(ContentValues.TAG, "DocumentSnapshot data2222: ${key}")
////                                Log.d(ContentValues.TAG, "DocumentSnapshot data2222: ${value["lastChecked"]}")
//                                val fakeMessageListObj = MessageListObj(tempUserObj,fakemap,fakemessagelistdataobj)
//                                messageListToReturn.add((fakeMessageListObj))
////                            userNamesArr.add(key)
////                            println(value.age)
//                            }
//                            Log.d(ContentValues.TAG, "whats this coounnt  : ${messageListToReturn.size}")

//                            var uidme =   UserHandler().getSingleUser(vv.uidToUse)
//
//                            for(vv:MessageListObj in messageListToReturn){
//                                if(vv.uidToUse != null){
//                                    var uidme =   UserHandler().getSingleUser(vv.uidToUse)
//
//                                    userNamesArr.add(uidme)
//                                    Log.d(ContentValues.TAG, "this is userobbj  : ${uidme}")
//
//
//                                }
//                                Log.d(ContentValues.TAG, "DocumentSnapshot datadododod  : ${userNamesArr.size}")
//                            }
//                            messageListToReturn.add(convertedMLDO)
                    }

                } else {


                    //Todo:Show some data no messageList or perhaps refresh

                    Log.d(ContentValues.TAG, "No such document")
                }

            }
            .addOnFailureListener { exception ->
                Log.d(ContentValues.TAG, "get failed with ", exception)
            }

//        }

        return teempstr

    }

     fun getSingleStorageItem(dataName:String): Bitmap{
        val storage = Firebase.storage
//   var returnarrr = mutableListOf<Bitmap>()
        var returnitem = UtilityFuns().makeEmptyBitMap()
        val storageRef = storage.reference
        val ONE_MEGABYTE: Long = 1024 * 1024
//        for (item: String in namesholder) {

            var newpatth = storageRef.child("test_img/$dataName")
            // ...

            newpatth.getBytes(ONE_MEGABYTE).addOnSuccessListener {

//                Log.d("eeeeee",it.size.toString())
                returnitem =   UtilityFuns().byteArrayToBitmap(it)
//                Log.d("zzzzzzz","$bb")

//                returnarrr.add(bb)
//                _picsDataSet.value = returnarrr
                var returnarrr = mutableListOf<Bitmap>()



                // Data for "images/island.jpg" is returned, use this as needed
            }.addOnFailureListener {
                // Handle any errors
            }
        return returnitem
//        }
    }

    suspend fun getMultipleUsers(type: String): List<DocumentSnapshot> {
        val querySnapshot = db.collection("Users")
//            .whereEqualTo("type", type)
            .get()
            .await()
        return querySnapshot.documents
    }
}