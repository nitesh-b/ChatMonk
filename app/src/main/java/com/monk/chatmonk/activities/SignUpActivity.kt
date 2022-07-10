package com.monk.chatmonk.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.monk.chatmonk.databinding.ActivitySignUpBinding

class SignUpActivity : BaseActivity() {

    lateinit var binder: ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binder = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binder.root)
    }
}