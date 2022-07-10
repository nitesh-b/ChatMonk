package com.monk.chatmonk.activities

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.monk.chatmonk.adapters.LoginSignUpViewPagerAdapter
import com.monk.chatmonk.databinding.ActivityLoginBinding
import com.monk.chatmonk.fragments.LoginFragment
import com.monk.chatmonk.fragments.SignUpFragment
import com.monk.chatmonk.interfaces.ItemClickListener

class LoginActivity : BaseActivity(), ItemClickListener {

    lateinit var binding: ActivityLoginBinding
    lateinit var viewPager : ViewPager2
    var fragmentList = ArrayList<Fragment>()
    lateinit var viewPagerAdapter: LoginSignUpViewPagerAdapter

    //Firebase AUthtication
    private lateinit var firebaseAuth : FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        binding.apply {
            setContentView(root)
        }
    FirebaseApp.initializeApp(this)
        //Initialize authticator

        firebaseAuth = Firebase.auth

        viewPager = binding.loginViewPager
        fragmentList.add(LoginFragment.newInstance(this))
        fragmentList.add(SignUpFragment.newInstance(this))
        viewPagerAdapter = LoginSignUpViewPagerAdapter(fragmentList, this)
        viewPager.isUserInputEnabled = false
        viewPager.adapter = viewPagerAdapter


    }

    override fun onStart() {
        super.onStart()
        val currentUser = firebaseAuth.currentUser
        currentUser?.let {
            startMainPage(currentUser)
        } ?: run {
            //Show login screen and allow user to login
        }
    }

    override fun onItemClick(item: Any) {
        super.onItemClick(item)
        if(item is String){
            val stringRes = item
            if(stringRes == "SIGN_UP"){
                viewPager.currentItem = 1
            }
        }
    }


    private fun startMainPage(currentUser: FirebaseUser) {
        val intent = Intent(this, ParentActivity::class.java)
        startActivity(intent)
    }

    private fun signUpUser() {
        TODO("Not yet implemented")
    }

}