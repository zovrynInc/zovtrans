package com.example.myapplication.ui.home

import android.os.Bundle
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


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

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
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}