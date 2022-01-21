package com.cmd.cmd_app_android.view.fragments.home

import android.os.Bundle
import android.view.View
import thecmdteam.cmd_app_android.R
import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint
import thecmdteam.cmd_app_android.databinding.FragmentFollowingBinding

@AndroidEntryPoint
class FollowingFragment : Fragment(R.layout.fragment_following) {

    private var _binding: FragmentFollowingBinding? = null

    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        _binding = FragmentFollowingBinding.bind(view)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}