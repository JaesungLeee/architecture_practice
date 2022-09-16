package jaesung.project.architecturepractice.presentation.test1

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import jaesung.project.architecturepractice.databinding.ItemSampleBinding
import jaesung.project.architecturepractice.domain.model.Place

class Test1Adapter : ListAdapter<Place, Test1Adapter.HomeViewHolder>(DiffCallback()){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemSampleBinding.inflate(inflater, parent, false)
        return HomeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.bindItems(getItem(position))
    }

    class HomeViewHolder(private val binding: ItemSampleBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bindItems(item: Place) {
            binding.place = item
            binding.executePendingBindings()
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<Place>() {
        override fun areItemsTheSame(oldItem: Place, newItem: Place): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Place, newItem: Place): Boolean {
            return oldItem.placeId == newItem.placeId
        }
    }
}