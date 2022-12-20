package com.example.myapplication.firebase

import android.content.ContentValues.TAG
import android.util.Log
import android.widget.Toast
import com.example.myapplication.R
import com.example.myapplication.model.Affirmation
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class AuthFuncs {
    private lateinit var auth: FirebaseAuth
    val db = Firebase.firestore

    fun loadAffirmations(): List<Affirmation> {
        return listOf<Affirmation>(
            Affirmation(R.string.affirmation1),
            Affirmation(R.string.affirmation2),
            Affirmation(R.string.affirmation3),
            Affirmation(R.string.affirmation4),
            Affirmation(R.string.affirmation5),
            Affirmation(R.string.affirmation6),
            Affirmation(R.string.affirmation7),
            Affirmation(R.string.affirmation8),
            Affirmation(R.string.affirmation9),
            Affirmation(R.string.affirmation10)
        )
    }

    fun getUserWithAuth(): FirebaseUser?{
        var userToReturn: FirebaseUser? = null

        val docRef = db.collection("cities").document("SF")
        docRef.get()
            .addOnSuccessListener { document ->
                if (document != null) {
                    Log.d(TAG, "DocumentSnapshot data: ${document.data}")
                } else {
                    Log.d(TAG, "No such document")
                }
            }
            .addOnFailureListener { exception ->
                Log.d(TAG, "get failed with ", exception)
            }
return userToReturn
    }


    fun returnAuth():String{

        return "hello from funnc"
    }



    fun createUserWithEmailandPassword(): FirebaseUser? {
        auth = Firebase.auth
        var userToReturn : FirebaseUser? = null

        auth.createUserWithEmailAndPassword("wweee","eeee").addOnCompleteListener { task ->

    if (task.isSuccessful) {
        // Sign in success, update UI with the signed-in user's information
        Log.d(TAG, "createUserWithEmail:success")
         userToReturn = auth.currentUser
//        return userToReturn
//        updateUI(user)
    }
    else {
        // If sign in fails, display a message to the user.
        Log.w(TAG, "createUserWithEmail:failure", task.exception)

        userToReturn = null
//        updateUI(null)
    }

}

return userToReturn
//        val userToReturn


    }

    fun signInEmail(email: String, pass:String): Boolean {
        var returnme: Boolean = false
        auth.signInWithEmailAndPassword(email, pass).addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d(TAG, "signInWithEmail:success")
                    val user = auth.currentUser
                    returnme = true
//                    updateUI(user)
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(TAG, "signInWithEmail:failure", task.exception)
//                    Toast.makeText(baseContext, "Authentication failed.",
//                        Toast.LENGTH_SHORT).show()
//                    updateUI(null)
                    returnme =  false

                }
            }
return returnme
    }
    }