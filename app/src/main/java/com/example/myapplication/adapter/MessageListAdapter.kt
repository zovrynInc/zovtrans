package com.example.myapplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.model.Affirmation
import com.example.myapplication.model.MessageListObj
import com.example.myapplication.ui.messageList.MessageListFragment

class MessageListAdapter(
    private val context: MessageListFragment,
    private val dataset: List<MessageListObj>
) : RecyclerView.Adapter<MessageListAdapter.MessageListViewHolder>() {



    class MessageListViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.textView2)
//        val imgview: ImageView = view.findViewById(R.id.imageView)
val profileImageView: ImageView = view.findViewById(R.id.messageListImageView)

    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageListAdapter.MessageListViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.message_list_item, parent, false)

       return MessageListAdapter.MessageListViewHolder(adapterLayout)
    }


//    override fun getItemCount(): Int {
//        dataset.size
//  }
    override fun getItemCount() = dataset.size


    override fun onBindViewHolder(holder: MessageListViewHolder, position: Int) {
//        TODO("Not yet implemented")
        val item = dataset[position]
        holder.textView.text = item.lastChecked//context.resources.getString(item.stringResourceId)
//        holder.profileImageView.setImageBitmap()
    }
}