package com.example.myapplication.ui.home

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.adapter.ItemAdapter
import com.example.myapplication.data.Datasource
import com.example.myapplication.databinding.FragmentHomeBinding
import com.example.myapplication.model.UserObj
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private lateinit var auth: FirebaseAuth
    val db = Firebase.firestore


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
//        Log.d("mmm","this is ${auth}")
//        val textView: TextView = binding.textHome
//        homeViewModel.text.observe(viewLifecycleOwner) {
//            textView.text = Datasource().loadAffirmations().size.toString()

//            textView.text = it
//        }

//        textView.text = Datasource().loadAffirmations().size.toString()
        val myDataset = Datasource().loadAffirmations()
//        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        val recyclerView: RecyclerView = binding.recyclerView//root.findViewById(R.id.recycler_view)
        val manager = GridLayoutManager(context, 2)

//        recyclerView.layoutManager = GridLayoutManager(this, 2)
        recyclerView.layoutManager = manager;

        recyclerView.adapter = ItemAdapter(this, myDataset)
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