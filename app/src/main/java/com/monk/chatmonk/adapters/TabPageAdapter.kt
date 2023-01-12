package com.monk.chatmonk.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.monk.chatmonk.fragments.chat.ChatFragment
import com.monk.chatmonk.fragments.headsup.HeadsUpFragment
import com.monk.chatmonk.fragments.profile.ProfileFragment

class TabPageAdapter(activity: FragmentActivity, private  val tabCount: Int) : FragmentStateAdapter(activity) {
    override fun getItemCount(): Int {
        return tabCount
    }

    override fun createFragment(position: Int): Fragment {
       return  when (position){
           0 -> ChatFragment()
           1 -> ProfileFragment()
           2 -> HeadsUpFragment()
           else -> ChatFragment ()
       }
    }
}