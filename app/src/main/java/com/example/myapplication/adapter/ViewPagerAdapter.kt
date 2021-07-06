package com.example.myapplication.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.myapplication.fragment.tabRiwayat.RiwayatFragment
import com.example.myapplication.fragment.tabRiwayat.RiwayatPenyawaanFrragment

class ViewPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                RiwayatFragment()
            }
            else -> {
                return RiwayatPenyawaanFrragment()
            }
        }
    }

    override fun getCount(): Int {
        return 2
    }

    override fun getPageTitle(position: Int): CharSequence {
        return when (position) {
            0 -> "Riwayat"
            else -> {
                return "Penyewaan"
            }
        }
    }
}