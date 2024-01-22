package com.example.webeteer.view.details.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.webeteer.R
import com.example.webeteer.databinding.RowWicketFallsBinding
import com.example.webeteer.view.summary.model.Wicket

class WicketFallsAdapter(private val context: Context, private val list: ArrayList<Wicket>) :
    RecyclerView.Adapter<WicketFallsAdapter.Holder>() {
    inner class Holder(binding: RowWicketFallsBinding) : RecyclerView.ViewHolder(binding.root) {
        private val itemBinding = binding
        fun bind(itemPosition: Int, data: Wicket) {
            itemBinding.wicketNumber = (itemPosition + 1).toString()
            itemBinding.data = data
            itemBinding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding: RowWicketFallsBinding =
            DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.row_wicket_falls, parent, false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(position, list[position])
    }

    override fun getItemCount(): Int = list.size

}