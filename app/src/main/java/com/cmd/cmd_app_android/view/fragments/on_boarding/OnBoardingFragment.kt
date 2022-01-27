package com.cmd.cmd_app_android.view.fragments.on_boarding

import android.animation.ObjectAnimator
import android.content.res.Resources
import android.os.Bundle
import android.transition.TransitionInflater
import android.view.View
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.cmd.cmd_app_android.view.activities.StarterActivity
import com.cmd.cmd_app_android.view.utils.animate
import com.cmd.cmd_app_android.view.utils.viewPagerItems
import dagger.hilt.android.AndroidEntryPoint
import thecmdteam.cmd_app_android.R
import thecmdteam.cmd_app_android.databinding.FragmentOnBoardingBinding

@AndroidEntryPoint
class OnBoardingFragment:Fragment(R.layout.fragment_on_boarding) {

    private var _binding: FragmentOnBoardingBinding? = null
    private val binding get() = _binding!!

    private lateinit var indicators: Array<ImageView>

    private var viewPagerAnimation : ObjectAnimator? = null
    private var indicatorsAnimation : ObjectAnimator? = null
    private lateinit var adapter: OnBoardingAdapter
    private var currentItem = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val animation = TransitionInflater.from(requireContext()).inflateTransition(
            android.R.transition.move
        )
        sharedElementEnterTransition = animation
        sharedElementReturnTransition = animation
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentOnBoardingBinding.bind(view)
        adapter = OnBoardingAdapter(viewPagerItems)
        binding.viewPager.adapter = adapter
        indicators = arrayOf(
            binding.firstIndicator, binding.secondIndicator, binding.thirdIndicator
        )
        binding.buttonNext.setOnClickListener {

        }
        binding.buttonSkip.setOnClickListener {
            findNavController().navigate(R.id.action_onBoardingFragment_to_signInFragment)
        }
        for(i in indicators) {
            i.setOnClickListener {
                binding.viewPager.setCurrentItem(indicators.indexOf(i), true)
            }
        }
        initAnimations()
        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                when(position) {
                    0 -> {
                        indicatorListener(0)
                        binding.buttonNext.text = resources.getString(R.string.next)
                        binding.buttonNext.setOnClickListener {
                            binding.viewPager.setCurrentItem(1, true)
                        }
                    }
                    1 -> {
                        indicatorListener(1)
                        binding.buttonNext.text = resources.getString(R.string.next)
                        binding.buttonNext.setOnClickListener {
                            binding.viewPager.setCurrentItem(2, true)
                        }
                    }
                    2 -> {
                        indicatorListener(2)
                        binding.buttonNext.text = resources.getString(R.string.sign_in)
                        binding.buttonNext.setOnClickListener {
                            findNavController().navigate(R.id.action_onBoardingFragment_to_signInFragment)
                        }
                    }
                }
            }
        })
        viewPagerAnimation?.start()
        indicatorsAnimation?.start()
    }

    private fun initAnimations() {
        viewPagerAnimation = ObjectAnimator
            .ofFloat(binding.viewPager, "alpha", 0.0f, 1f)
            .apply {
                duration = 1000
                startDelay = 500

            }

        indicatorsAnimation = ObjectAnimator
            .ofFloat(binding.indicators, "alpha", 0.0f, 1f)
            .apply {
                duration = 1000
                startDelay = 1500

            }
    }

    private fun indicatorListener(index: Int) {
        for (i in indicators.indices) {
            if(i == index) {
                indicators[i].setImageDrawable(
                    ContextCompat.getDrawable(requireContext(),
                        R.drawable.background_on_boarding_indicator_active
                    )
                )
            } else {
                indicators[i].setImageDrawable(
                    ContextCompat.getDrawable(requireContext(),
                        R.drawable.background_on_boarding_indicator_inactive
                    )
                )
            }
        }
    }

    override fun onStart() {
        super.onStart()
        (activity as StarterActivity).window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE)

    }

    override fun onPause() {
        super.onPause()
        viewPagerAnimation?.cancel()
        indicatorsAnimation?.cancel()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}