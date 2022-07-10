package com.monk.chatmonk.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.monk.chatmonk.R
import com.monk.chatmonk.viewmodels.PublicChatListViewModel

class PublicChatListFragment : Fragment() {

    companion object {
        fun newInstance() = PublicChatListFragment()
    }

    private lateinit var viewModel: PublicChatListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_public_chat_list, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(PublicChatListViewModel::class.java)
        // TODO: Use the ViewModel
    }

}