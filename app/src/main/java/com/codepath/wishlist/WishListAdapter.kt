package com.codepath.wishlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class WishListAdapter(private val dataSet: MutableList<WishList>) :
RecyclerView.Adapter<WishListAdapter.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nameTv: TextView
        val priceTv: TextView
        val urlTv: TextView


        init {
            // Define click listener for the ViewHolder's View.
            nameTv = view.findViewById(R.id.textView_name)
            priceTv = view.findViewById(R.id.textView_price)
            urlTv = view.findViewById(R.id.textView_url)
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.wish_list_item, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        val wl = dataSet[position]

        viewHolder.nameTv.text = wl.itemName
        viewHolder.priceTv.text = wl.price
        viewHolder.urlTv.text = wl.URL
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

}