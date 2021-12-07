package com.insureka.myapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.insureka.myapplication.databinding.ItemRatingBinding

class RatingAdapter(private val viewModel: MainViewModel) : RecyclerView.Adapter<RatingAdapter.ViewHolder>() {

    private val ratings = ArrayList<String>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemRatingBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val rating = ratings[position]
        holder.bind(rating, viewModel)
    }

    fun setData(idvList: List<String>) {
        val diffCallback = RatingDiffCallback(ratings, idvList)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        ratings.clear()
        ratings.addAll(idvList)
        diffResult.dispatchUpdatesTo(this)
    }

    override fun getItemCount(): Int {
        return ratings.size
    }

    inner class ViewHolder(val binding: ItemRatingBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: String, viewModel: MainViewModel) {
            binding.viewModel = viewModel
            binding.nameText.text = item
            binding.switchBtn.setOnCheckedChangeListener { compoundButton, b ->

            }
            binding.executePendingBindings()
        }
    }
}
