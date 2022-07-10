package com.monk.chatmonk.adapters

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class LoginSignUpViewPagerAdapter(
    private var fragmentList: ArrayList<Fragment>, activity: AppCompatActivity
) : FragmentStateAdapter(activity) {
    override fun getItemCount(): Int {
        return fragmentList.count();
    }

    override fun createFragment(position: Int): Fragment {
        return fragmentList.get(position)
    }

}