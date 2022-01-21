package com.cmd.cmd_app_android.view.fragments.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.cmd.cmd_app_android.viewmodel.HomeViewModel
import com.google.android.material.tabs.TabLayoutMediator
import thecmdteam.cmd_app_android.R
import thecmdteam.cmd_app_android.databinding.FragmentHomeBinding

class HomeFragment : Fragment(R.layout.fragment_home) {

    private var _binding: FragmentHomeBinding? = null

    private val binding get() = _binding!!

    private val tabs = listOf("Following", "For You")

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        _binding = FragmentHomeBinding.bind(view)
        val adapter = HomeFragmentPagerAdapter(requireActivity().supportFragmentManager, lifecycle)
        binding.homeViewPager.adapter = adapter

        TabLayoutMediator(binding.tabLayout, binding.homeViewPager) { tab, position ->
            tab.text = tabs[position]
        }.attach()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}