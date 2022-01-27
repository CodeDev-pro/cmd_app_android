package com.cmd.cmd_app_android.view.utils

import com.cmd.cmd_app_android.view.fragments.on_boarding.ViewPagerItem
import thecmdteam.cmd_app_android.R

const val EMPTY = "empty"
const val NO_INTERNET_CONNECTION = "No Internet Connection, please switch on your mobile connection or wifi connection"
val viewPagerItems = listOf<ViewPagerItem>(
    ViewPagerItem(
        "A tech-based team for vast specializations", R.drawable.ic_workspace
    ),
    ViewPagerItem(
        "Getting mentors in this interactive community", R.drawable.ic_code_inspection
    ),
    ViewPagerItem(
        "Sharing and solving code related problems", R.drawable.ic_meeting
    )
)