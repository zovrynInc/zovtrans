package com.example.myapplication.adapter

import android.graphics.Bitmap
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.model.Affirmation
import com.example.myapplication.ui.home.HomeFragment


class ItemAdapter(
    private val context: HomeFragment,
    private val dataset: List<Bitmap>
) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder.
    // Each data item is just an Affirmation object.
    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.homeTextView)
        val imgview: ImageView = view.findViewById(R.id.home_image_view)

    }

    /**
     * Create new views (invoked by the layout manager)
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        // create a new view
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)

        return ItemViewHolder(adapterLayout)
    }

    /**
     * Replace the contents of a view (invoked by the layout manager)
     */
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
//        var  marker = getResources().getDrawable(R.drawable.restaurant);
//        val drawable22 = ResourcesCompat.getDrawable( R.drawable.crayjesuus_background, null)
//        holder.textView.text = context.resources.getString(item.stringResourceId)
//        holder.imgview.setImageResource(R.drawable.crayjesuus_background)
        holder.imgview.setImageBitmap(item)
//        ContextCompat.getDrawable(context, crayjesuus_background)

//        val drawable: Drawable = getResources().getDrawable(crayjesuus_background)

//        holder.imgview.setImageDrawable(R.drawable.crayjesuus_background);

    }

    /**
     * Return the size of your dataset (invoked by the layout manager)
     */
    override fun getItemCount() = dataset.size
}