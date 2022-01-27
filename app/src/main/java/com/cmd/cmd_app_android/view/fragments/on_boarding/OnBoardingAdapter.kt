package com.cmd.cmd_app_android.view.fragments.on_boarding

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import thecmdteam.cmd_app_android.databinding.LayoutOnBoardingItemBinding

class OnBoardingAdapter (private val list: List<ViewPagerItem>) : RecyclerView.Adapter<OnBoardingAdapter.OnBoardingViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardingViewHolder {
        return OnBoardingViewHolder(
            LayoutOnBoardingItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: OnBoardingViewHolder, position: Int) {
        val item = list[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class OnBoardingViewHolder(
        private val binding: LayoutOnBoardingItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(viewPagerItem: ViewPagerItem) {
            binding.imageViewPager.setImageResource(viewPagerItem.imageResource)
            binding.title.text = viewPagerItem.title
        }
    }
}