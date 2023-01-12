package com.monk.chatmonk.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import com.monk.chatmonk.adapters.TabPageAdapter
import com.monk.chatmonk.databinding.ActivityParentBinding

class ParentActivity : BaseActivity() {

    lateinit var binder: ActivityParentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binder = ActivityParentBinding.inflate(layoutInflater)
        setContentView(binder.root) //R.layout.activity_parent

        setupTabbar()
    }

    private fun setupTabbar() {
        val adapter = TabPageAdapter(this, binder.tabLayout.tabCount)
binder.viewpager.isUserInputEnabled = false
        binder.viewpager.adapter = adapter
        binder.viewpager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                binder.tabLayout.selectTab(binder.tabLayout.getTabAt(position))
            }
        })
        binder.tabLayout.addOnTabSelectedListener(object : OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                tab?.position?.let { binder.viewpager.setCurrentItem(it, false) }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

        })
    }
}