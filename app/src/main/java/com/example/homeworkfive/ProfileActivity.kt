package com.example.homeworkfive

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.homeworkfive.databinding.ActivityLogInBinding
import com.example.homeworkfive.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {

    private lateinit var  binding: ActivityProfileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonBack.setOnClickListener {
            onBackPressed()
        }

    }
}