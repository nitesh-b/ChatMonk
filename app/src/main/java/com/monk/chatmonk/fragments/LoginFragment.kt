package com.monk.chatmonk.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.monk.chatmonk.R
import com.monk.chatmonk.activities.ParentActivity
import com.monk.chatmonk.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    lateinit var binder: FragmentLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance() = LoginFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
         binder = FragmentLoginBinding.bind(view)
        binder.loginButton.setOnClickListener {
            loginValidation()
        }
        binder.signUpButton.setOnClickListener {
            displaySignUpPage()
        }

    }

    private fun displaySignUpPage() {
    }

    private fun loginValidation() {
        if (binder.userName.text.isNullOrEmpty()){
            binder.userName.error = "Enter username"
            return
        }
        if (binder.password.text.isNullOrEmpty()){
            binder.password.error = "Enter password"
            return
        }
        val username = binder.userName.text!!.toString()
        val password = binder.password.text!!.toString()
        firebaseLogin(username, password)
    }

    private fun firebaseLogin(username: String, password: String) {
        activity?.let {
            FirebaseAuth.getInstance().signInWithEmailAndPassword(username, password).addOnCompleteListener(
                it, OnCompleteListener { task ->
                    if(task.isSuccessful){
                        val currentUser = FirebaseAuth.getInstance().currentUser;
                        startMainPage(currentUser!!)
                    }

                })
        }
    }

    private fun startMainPage(currentUser: FirebaseUser) {
        val intent = Intent(context, ParentActivity::class.java)
        startActivity(intent)
    }

}