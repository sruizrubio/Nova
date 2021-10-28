package com.example.nova.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.nova.databinding.ItemWithStringBinding

class MyListAdapter(): ListAdapter<String, MyListAdapter.MyViewHolder>(DIFF_CALLBACK) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ItemWithStringBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.bind(getItem(position))
    }

    override fun getItemCount(): Int {
        return currentList.size
    }

    inner class MyViewHolder(val binding: ItemWithStringBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(item: String){
            binding.apply {
                myAdapterText.text = item
            }
        }
    }

    companion object {
        val DIFF_CALLBACK = object: DiffUtil.ItemCallback<String>() {

            override fun areItemsTheSame(oldItem: String,
                                         newItem: String): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: String,
                                            newItem: String): Boolean {
                return oldItem == newItem
            }
        }

    }
}