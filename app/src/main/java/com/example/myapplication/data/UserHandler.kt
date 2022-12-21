package com.example.myapplication.data

import android.content.ContentValues.TAG
import android.util.Log
import com.example.myapplication.R
import com.example.myapplication.model.Affirmation
import com.example.myapplication.model.UserObj
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
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

   suspend  fun getSingleUser(userID:String): String? {
        Log.d(TAG, "func calledd")
//       val docRef = db.collection("Users").document("p2iaBDZSwHUb0VTJwDHqJRatCp23")

//       db.collection("Users")
//           .get()
//           .addOnSuccessListener { document ->
//               if (document != null) {
//                   var ee = document
//                   Log.d(TAG, "DocumentSnapshot data: ${ee.documents[0].data}")
//               } else {
//                   Log.d(TAG, "No such document")
//               }
//           }
//           .addOnFailureListener { exception ->
//               Log.d(TAG, "get failed with ", exception)
//           }
//        var userToReturn: UserObj? = null

        val docRef = db.collection("Users").document(userID)
       var sss = docRef.get().await()
       var cccc = sss.data?.get("uid") as String
       Log.d(TAG, "No such document ${cccc}",)

       return "$cccc"
    }

     suspend fun getPlaces(type: String): List<DocumentSnapshot> {
        val querySnapshot = db.collection("Users")
//            .whereEqualTo("type", type)
            .get()
            .await()
        return querySnapshot.documents
    }

    suspend fun getMultipleUsers(type: String): List<DocumentSnapshot> {
        val querySnapshot = db.collection("Users")
//            .whereEqualTo("type", type)
            .get()
            .await()
        return querySnapshot.documents
    }
}