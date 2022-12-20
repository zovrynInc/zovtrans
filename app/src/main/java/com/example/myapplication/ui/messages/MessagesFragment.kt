package com.example.myapplication.ui.messages

import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.databinding.FragmentDashboardBinding
import com.example.myapplication.firebase.AuthFuncs
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MessagesFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private lateinit var auth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dashboardViewModel =
            ViewModelProvider(this).get(MessagesViewModel::class.java)

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textDashboard
        val textView2: TextView = binding.textDashboard33

        dashboardViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        dashboardViewModel.eeetext.observe(viewLifecycleOwner) {
            textView2.text = it
        }
        auth = Firebase.auth
        Log.d("eee", "sssss  ${auth.currentUser == null}")

//
//        auth.currentUser?.let { Log.d("TAG", it.uid) }
//        Log.d("TAG", "sssss")
//        val bbbbb = auth.currentUser == null
        Log.d("TAG","bbbbbgggggggggjhu" )
//    var bbb  = AuthFuncs().returnAuth()
//                Log.d("TAGsss","$bbb" )
//        Log.d(ContentValues.TAG, "ddddddddeee data: ${bbb}")

//
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}