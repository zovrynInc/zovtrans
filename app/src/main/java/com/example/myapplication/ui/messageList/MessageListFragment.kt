package com.example.myapplication.ui.messageList

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.databinding.FragmentDashboardBinding
import com.example.myapplication.databinding.FragmentMessageListBinding
import com.example.myapplication.ui.messages.MessagesViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase



class MessageListFragment : Fragment() {

    private var _binding: FragmentMessageListBinding? = null

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
            ViewModelProvider(this).get(MessageListViewModel::class.java)

        _binding = FragmentMessageListBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textView2
//        val textView2: TextView = binding.textDashboard33
//
        dashboardViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
//        dashboardViewModel.eeetext.observe(viewLifecycleOwner) {
//            textView2.text = it
//        }
        auth = Firebase.auth
        Log.d("TAG", "sssss  ${auth.currentUser == null}")

//
//        auth.currentUser?.let { Log.d("TAG", it.uid) }
//        Log.d("TAG", "sssss")
//        val bbbbb = auth.currentUser == null
//        Log.d("TAG","$bbbbb" )

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}