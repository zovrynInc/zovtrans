package com.example.myapplication.ui.messageList

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.adapter.MessageListAdapter
//import com.example.myapplication.adapter.MessageListAdapter
import com.example.myapplication.data.Datasource
import com.example.myapplication.data.UserHandler
import com.example.myapplication.databinding.FragmentMessageListBinding
import com.example.myapplication.model.MessageListObj
import com.example.myapplication.model.MessageListRecyclerViewElement
import com.example.myapplication.model.UserObj
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.*


class MessageListFragment : Fragment() {

    private var _binding: FragmentMessageListBinding? = null
    private var job: Job = Job()

//     val coroutineContext: CoroutineContext
//        get() = Dispatchers.Main + job
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private lateinit var auth: FirebaseAuth

    private suspend fun foo() {
        try {
            val places = UserHandler().getPlaces("...")
            Log.d(TAG, "Epplae: ", null)

        }
        catch (exception: Exception) {
            Log.w(TAG, "Error getting documents: ", exception)
        }
    }



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dashboardViewModel =
            ViewModelProvider(this).get(MessageListViewModel::class.java)

        _binding = FragmentMessageListBinding.inflate(inflater, container, false)
        val root: View = binding.root

//        val textView: TextView = binding.
//        val textView2: TextView = binding.textDashboard33
//
//
// _tmpnamess

        dashboardViewModel.tmparr.observe(viewLifecycleOwner) {
            var wwww = it
            for(varss:UserObj in it ){
                Log.d("TAG", "eeeee0000 is ${varss.uid}")
                Log.d("TAG", "eeeee022 is ${varss.userName}")

            }

        }



        dashboardViewModel.eeetext.observe(viewLifecycleOwner) {
//            var wwww = it
            Log.d("TAG", "messageListArrr is ${it}")

            for(mloToUse:MessageListObj in it ){
//                Log.d("TAG", "messageListArrr is ${it}")
//                Log.d("TAG", "mlo obj owner is ${mloToUse.uidToUse}")
//
//                Log.d("TAG", "mlo lastMsg is ${mloToUse.lastMsg}")

            }

        }


        dashboardViewModel.mListDataSet.observe(viewLifecycleOwner) {
//            textView.text = it
            Log.d("TAG", "eeeee1111 is $it")


//            val myDataset = it

            val testArr = listOf<MessageListRecyclerViewElement>()
            val myDataset = testArr
//    myDataset.
            val recyclerView: RecyclerView = binding.messageListRecyclerView//root.findViewById(R.id.recycler_view)
//        val manager = Manager
            recyclerView.layoutManager = LinearLayoutManager(context)



//        recyclerView.layoutManager = manager;

            recyclerView.adapter = MessageListAdapter(this,myDataset)
        }

        dashboardViewModel.launchDataLoad()

        var userToReturn: UserObj? = null


        return root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}