package com.monk.chatmonk.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.monk.chatmonk.R
import com.monk.chatmonk.viewmodels.ChatListViewModel

class ChatListFragment : Fragment() {

    companion object {
        fun newInstance() = ChatListFragment()
    }

    private lateinit var viewModel: ChatListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_chat_list, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ChatListViewModel::class.java)
    }

}