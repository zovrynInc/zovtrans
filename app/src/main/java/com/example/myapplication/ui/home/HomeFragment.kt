package com.example.myapplication.ui.home

import android.content.ContentValues
import android.content.ContentValues.TAG
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.adapter.ItemAdapter
import com.example.myapplication.data.Datasource
import com.example.myapplication.data.UserHandler
import com.example.myapplication.databinding.FragmentHomeBinding
import com.example.myapplication.model.UserObj
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.ktx.storage
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private lateinit var auth: FirebaseAuth
    val db = Firebase.firestore
    lateinit var storage: FirebaseStorage


    fun byteArrayToBitmap(data: ByteArray): Bitmap {
        return BitmapFactory.decodeByteArray(data, 0, data.size)
    }
    fun getPics(  ) {
        val storage = Firebase.storage
//
        val storageRef = storage.reference


//        val storageRef = storageInst.reference
        val pathReference = storageRef.child("test_img/IMG_5539 2.jpg")
        val ONE_MEGABYTE: Long = 1024 * 1024
//        pathReference.getBytes(ONE_MEGABYTE).addOnSuccessListener {
//            // Data for "images/island.jpg" is returned, use this as needed
//
//            Log.d("eeeeee",it.size.toString())
//        }.addOnFailureListener {
//            Log.d("exep",it.toString())
//
//            // Handle any errors
//        }
//        val ONE_MEGABYTE: Long = 1024 * 1024


//        GlobalScope.launch {
////            sortList()
//            // Modify UI
//            pathReference.getBytes(ONE_MEGABYTE).addOnSuccessListener {
//
//                Log.d("eeeeee",it.size.toString())
//
//                var bb =   byteArrayToBitmap(it)
//                Log.d("zzzzzzz","$bb")
//
//
//                // Data for "images/island.jpg" is returned, use this as needed
//            }.addOnFailureListener {
//                // Handle any errors
//            }
//
////                var ggg = UserHandler().getSingleUser("p2iaBDZSwHUb0VTJwDHqJRatCp23")
////            Log.d(ContentValues.TAG, "DocumentSnapshosssssst data: ${ggg}")
////                _text.value = ggg
//
//        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
//        val storageRef = storage.reference


        homeViewModel.getPics()

//        Log.d("mmm","this is ${auth}")
//        val textView: TextView = binding.textHome
//        homeViewModel.text.observe(viewLifecycleOwner) {
//            textView.text = Datasource().loadAffirmations().size.toString()

//            textView.text = it
//        }
        homeViewModel.picsDS.observe(viewLifecycleOwner) {
            Log.d("zaza",it.size.toString())
//            val myDataset = Datasource().loadAffirmations()

//           var bbb = byteArrayToBitmap(it)
//            val myDataset: List<Bitmap> = listOf(it)
//            myDataset.add
//        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
            val recyclerView: RecyclerView = binding.recyclerView//root.findViewById(R.id.recycler_view)
            val manager = GridLayoutManager(context, 2)

//        recyclerView.layoutManager = GridLayoutManager(this, 2)
            recyclerView.layoutManager = manager;

            recyclerView.adapter = ItemAdapter(this, it)
//            textView.text = Datasource().loadAffirmations().size.toString()
//
//            textView.text = it
        }
//        textView.text = Datasource().loadAffirmations().size.toString()
//        val myDataset = Datasource().loadAffirmations()
////        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
//        val recyclerView: RecyclerView = binding.recyclerView//root.findViewById(R.id.recycler_view)
//        val manager = GridLayoutManager(context, 2)
//
////        recyclerView.layoutManager = GridLayoutManager(this, 2)
//        recyclerView.layoutManager = manager;
//
//        recyclerView.adapter = ItemAdapter(this, myDataset)
//        recyclerView.adapter.or
        // Use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
//        recyclerView.setHasFixedSize(true)

        auth = Firebase.auth
//        Log.d("TAG", "xxxx  ${auth?.currentUser?.uid }")
//        Log.d("TAG","bbbbbgggggggggjhu" )
//        var bbb  = UserHandler().getSingleUser("p2iaBDZSwHUb0VTJwDHqJRatCp23")
////        Log.d("TAGsss","ccccccccc ${bbb?.uid}" )
//        Log.d("TAGsss","ccccccccc ${bbb?.uid}" )

//        Log.d(ContentValues.TAG, "ddddddddeee data: ${bbb}")

        var userToReturn: UserObj? = null
        Log.d(TAG, "yyyyayaayayaayayayayy")

//        val docRef = db.collection("Users").document("p2iaBDZSwHUb0VTJwDHqJRatCp23")
//        docRef.get()
//            .addOnSuccessListener { document ->
//                if (document != null) {
//                    Log.d(TAG, "DocumentSnapshot data: ${document.data}")
//                } else {
//                    Log.d(TAG, "No such document")
//                }
//            }
//            .addOnFailureListener { exception ->
//                Log.d(TAG, "get failed with ", exception)
//            }

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        auth = Firebase.auth

//        AuthFuncs().signInEmail("test1@gmail.com","aaaaaa")

    }


    override fun onStart() {
        super.onStart()

    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}