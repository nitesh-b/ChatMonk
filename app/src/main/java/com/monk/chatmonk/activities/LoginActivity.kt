package com.monk.chatmonk.activities

import android.app.Application
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.monk.chatmonk.databinding.ActivityMainBinding
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    //Firebaes AUthtication
    private lateinit var firebaseAuth : FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.apply {
            setContentView(root)
        }
    FirebaseApp.initializeApp(this)
        //Initialize authticator

        firebaseAuth = Firebase.auth
        binding.loginButton.setOnClickListener {
            loginValidation()
        }

    }

    override fun onStart() {
        super.onStart()
        val currentUser = firebaseAuth.currentUser
        currentUser?.let {
            startMainPage(currentUser!!)
        } ?: run {
            //Show login screen and allow user to login
        }
    }

    private fun loginValidation() {
        if (binding.userName.text.isNullOrEmpty()){
            binding.userName.error = "Enter username"
            return
        }
        if (binding.password.text.isNullOrEmpty()){
            binding.password.error = "Enter password"
            return
        }
        val username = binding.userName.text!!.toString()
        val password = binding.password.text!!.toString()
        firebaseLogin(username, password)
    }

    private fun firebaseLogin(username: String, password: String) {
        firebaseAuth.signInWithEmailAndPassword(username, password).addOnCompleteListener(this, OnCompleteListener { task ->
        if(task.isSuccessful){
            val currentUser = firebaseAuth.currentUser;
            startMainPage(currentUser!!)
        }

        })
    }

    private fun startMainPage(currentUser: FirebaseUser) {
        val intent = Intent(this, ParentActivity::class.java)
        startActivity(intent)
    }

    private fun signUpUser() {
        TODO("Not yet implemented")
    }

}