package com.trinitydigital.room.ui

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.trinitydigital.room.data.EtData
import kotlinx.android.synthetic.main.item_grid.view.*

class RvViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    fun bind(
        etData: EtData,
        listener: ItemRvListener
    ) {
        itemView.tv1.text = etData.etOne
        itemView.tv2.text = etData.etTwo
        itemView.tv3.text = etData.etThree
        itemView.tv4.text = etData.etFour

        itemView.btnDelete.setOnClickListener {
            listener.btnDeleteClicked(etData)
        }
    }
}