package com.example.webeteer.view.details.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.webeteer.R
import com.example.webeteer.databinding.RowBattersListBinding
import com.example.webeteer.view.summary.model.Player

class BattersListAdapter(private val context: Context, private val list: ArrayList<Player>) :
    RecyclerView.Adapter<BattersListAdapter.Holder>() {
    inner class Holder(binding: RowBattersListBinding) : RecyclerView.ViewHolder(binding.root) {
        private val itemBinding = binding
        fun bind(itemPosition: Int, data: Player) {
            itemBinding.data = data
            itemBinding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding: RowBattersListBinding =
            DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.row_batters_list, parent, false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(position, list[position])
    }

    override fun getItemCount(): Int = list.size

}