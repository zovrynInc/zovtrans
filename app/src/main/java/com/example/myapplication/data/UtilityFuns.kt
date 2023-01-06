package com.example.myapplication.data

import android.graphics.Bitmap
import android.graphics.BitmapFactory


class UtilityFuns {

    fun makeEmptyBitMap(): Bitmap{
        val w: Int = 12
        val h: Int = 12

        val conf = Bitmap.Config.ARGB_8888 // see other conf types

        val bmp = Bitmap.createBitmap(w, h, conf) // this creates a MUTABLE bitmap
        return bmp
    }

     fun byteArrayToBitmap(data: ByteArray): Bitmap {
         return BitmapFactory.decodeByteArray(data, 0, data.size)
     }
}