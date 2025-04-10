package com.kabarak.kabarakmhis.pnc.aefi

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kabarak.kabarakmhis.R
import com.kabarak.kabarakmhis.pnc.data_class.AEFI

class AefiAdapter (
    private val aefis: List<AEFI>,
    private val onAefiClick: (String) -> Unit // Lambda function to handle aefi click
) : RecyclerView.Adapter<AefiAdapter.aefiViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): aefiViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_aefi, parent, false) // view is a LinearLayout
        return aefiViewHolder(view)
    }

    override fun onBindViewHolder(holder: aefiViewHolder, position: Int) {
        val aefi = aefis[position]
        holder.bind(aefi)

        // Set click listener to pass the aefi's ID
        holder.itemView.setOnClickListener {
            onAefiClick(aefi.id) // Pass the aefi's ID to the lambda function
        }
    }

    override fun getItemCount(): Int {
        return aefis.size
    }

    class aefiViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val descriptionTextView: TextView = itemView.findViewById(R.id.etDescribe)
        private val reportDateTextView: TextView = itemView.findViewById(R.id.tv_date)

        fun bind(aefi: AEFI) {
            descriptionTextView.text = aefi.description
            reportDateTextView.text = aefi.reportDate
        }
    }
}
