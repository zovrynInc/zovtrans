package com.example.myapplication.ui.home

import android.content.ContentValues
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.google.firebase.storage.ktx.storage
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {
    lateinit var storage: FirebaseStorage

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }

    private val _picsDataSet =MutableLiveData<List<Bitmap>>()
//    val text: LiveData<String> = _text



//     lateinit var storage: FirebaseStorage

    fun byteArrayToBitmap(data: ByteArray): Bitmap {
        return BitmapFactory.decodeByteArray(data, 0, data.size)
    }
    fun getPics(  ) {
        val storage = Firebase.storage

        val storageRef = storage.reference


//        val storageRef = storageInst.reference
        val pathReference = storageRef.child("test_img/IMG_5539 2.jpg")
        val ONE_MEGABYTE: Long = 1024 * 1024
            val namesholder = listOf<String>("IMG_5539 2.jpg","FC41032D-6D1C-4444-B25D-B6A98AB4FE70.JPG")

        viewModelScope.launch {
//            sortList()
            // Modify UI

            var returnarrr = mutableListOf<Bitmap>()

            for (item: String in namesholder) {

                var newpatth = storageRef.child("test_img/$item")
                // ...

                newpatth.getBytes(ONE_MEGABYTE).addOnSuccessListener {

                    Log.d("eeeeee",it.size.toString())
                    var bb =   byteArrayToBitmap(it)
//                Log.d("zzzzzzz","$bb")

                    returnarrr.add(bb)
                    //            var bbbb = listOf<Bitmap>(bb)
                    _picsDataSet.value = returnarrr
                    // Data for "images/island.jpg" is returned, use this as needed
                }.addOnFailureListener {
                    // Handle any errors
                }
            }
//            var bbbb = listOf<Bitmap>(bb)
            _picsDataSet.value = returnarrr

//                var ggg = UserHandler().getSingleUser("p2iaBDZSwHUb0VTJwDHqJRatCp23")
//            Log.d(ContentValues.TAG, "DocumentSnapshosssssst data: ${ggg}")
//                _text.value = ggg

        }
    }

    val text: LiveData<String> = _text
    val picsDS = _picsDataSet

}

