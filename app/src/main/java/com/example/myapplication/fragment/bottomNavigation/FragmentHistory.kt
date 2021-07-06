package com.example.myapplication.fragment.bottomNavigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager
import com.example.myapplication.R
import com.example.myapplication.adapter.ViewPagerAdapter
import com.google.android.material.tabs.TabLayout

/**
 * A simple [Fragment] subclass.
 */
class FragmentHistory : Fragment(R.layout.fragment_history) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tabLayout = view.findViewById<TabLayout>(R.id.tabLayout)
        val viewPager = view.findViewById<ViewPager>(R.id.viewPager)

        val fragmentAdapter = activity?.supportFragmentManager?.let { ViewPagerAdapter(it) }
        viewPager.adapter = fragmentAdapter

        tabLayout.setupWithViewPager(viewPager)

    }

}
