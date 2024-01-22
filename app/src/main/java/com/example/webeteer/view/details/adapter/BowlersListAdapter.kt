package com.example.webeteer.view.details.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.webeteer.R
import com.example.webeteer.databinding.RowBowlersListBinding
import com.example.webeteer.view.summary.model.Bowler

class BowlersListAdapter(private val context: Context, private val list: ArrayList<Bowler>) :
    RecyclerView.Adapter<BowlersListAdapter.Holder>() {
    inner class Holder(binding: RowBowlersListBinding) : RecyclerView.ViewHolder(binding.root) {
        private val itemBinding = binding
        fun bind(itemPosition: Int, data: Bowler) {
            itemBinding.data = data
            itemBinding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding: RowBowlersListBinding =
            DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.row_bowlers_list, parent, false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(position, list[position])
    }

    override fun getItemCount(): Int = list.size

}