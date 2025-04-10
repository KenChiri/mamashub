package com.kabarak.kabarakmhis.pnc

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kabarak.kabarakmhis.R
import com.kabarak.kabarakmhis.pnc.data_class.Mother


class PostNatalCareMotherAdapter(
    private val mothers: List<Mother>,
    private val onMotherClick: (String) -> Unit // Lambda function to handle mother click
) : RecyclerView.Adapter<PostNatalCareMotherAdapter.MotherViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MotherViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_mother, parent, false) // view is a LinearLayout
        return MotherViewHolder(view)
    }

    override fun onBindViewHolder(holder: MotherViewHolder, position: Int) {
        val mother = mothers[position]
        holder.bind(mother)

        // Set click listener to pass the mother's ID
        holder.itemView.setOnClickListener {
            onMotherClick(mother.id) // Pass the mother's ID to the lambda function
        }
    }

    override fun getItemCount(): Int {
        return mothers.size
    }

    class MotherViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val generalConditionTextView: TextView = itemView.findViewById(R.id.tv_general_condition)
        private val visitDateTextView: TextView = itemView.findViewById(R.id.tv_visit_date)

        fun bind(mother: Mother) {
            generalConditionTextView.text = mother.generalCondition
            visitDateTextView.text = mother.visitDate
        }
    }
}
