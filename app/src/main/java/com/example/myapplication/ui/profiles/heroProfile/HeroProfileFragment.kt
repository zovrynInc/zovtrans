package com.example.myapplication.ui.profiles.heroProfile

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.databinding.FragmentDashboardBinding
import com.example.myapplication.databinding.FragmentHeroProfileBinding
import com.example.myapplication.ui.messages.MessagesViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class HeroProfileFragment : Fragment() {

    private var _binding: FragmentHeroProfileBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private lateinit var auth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        activity?.title = "Your actionbar title";

        val dashboardViewModel =
            ViewModelProvider(this).get(HeroProfileViewModel::class.java)

        _binding = FragmentHeroProfileBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textView3
//        val textView2: TextView = binding.textDashboard33

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