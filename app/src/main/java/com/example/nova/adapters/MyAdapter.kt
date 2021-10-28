package com.example.nova.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.nova.R
import com.example.nova.databinding.ItemWithStringBinding

class MyAdapter(var list: MutableList<String>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    companion object{
        const val TYPE1 = 1
        const val TYPE2 = 2
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        when(viewType) {
            TYPE1->{
                val binding = ItemWithStringBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                )
                return MyViewHolder2(binding)
            }
            else->{
                val binding = ItemWithStringBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                )
                return MyViewHolder(binding)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (list[position]) {
            "2" -> {
                TYPE1
            }
            else -> {
                TYPE2
            }
        }
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is MyViewHolder->{
                holder.bind(list[position])
            }
            else->{
                (holder as? MyViewHolder2?)?.bind(list[position])
            }
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun refreshList(newList: List<String>){
        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()
    }

    inner class MyViewHolder(val binding: ItemWithStringBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(item: String){
            binding.apply {
                myAdapterText.text = item
            }
        }
    }

    inner class MyViewHolder2(val binding: ItemWithStringBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(item: String){
            binding.apply {
                myAdapterText.text = item
                myAdapterText.setTextColor(ContextCompat.getColor(myAdapterText.context, R.color.purple_200))
            }
        }
    }
}
