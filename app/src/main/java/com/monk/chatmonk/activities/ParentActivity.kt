package com.monk.chatmonk.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.monk.chatmonk.databinding.ActivityParentBinding

class ParentActivity : BaseActivity() {

    lateinit var binder: ActivityParentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binder = ActivityParentBinding.inflate(layoutInflater)
        setContentView(binder.root) //R.layout.activity_parent
    }
}