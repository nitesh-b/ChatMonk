package com.monk.chatmonk.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.monk.chatmonk.R
import com.monk.chatmonk.activities.LoginActivity
import com.monk.chatmonk.interfaces.ItemClickListener

class SignUpFragment(var itemClickListener: ItemClickListener) : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sign_up, container, false)
    }

    companion object {

        @JvmStatic
        fun newInstance(itemClickListener: ItemClickListener) = SignUpFragment(itemClickListener)
    }
}