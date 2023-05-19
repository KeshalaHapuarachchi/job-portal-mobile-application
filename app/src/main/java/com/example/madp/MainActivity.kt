package com.example.madp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.madp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Set up view binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button7.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java)) // Start LoginActivity when the button is clicked
        }

        binding.button2.setOnClickListener {
            startActivity(Intent(this, Register1Activity::class.java)) // Start Register1Activity when the button is clicked
        }
    }
}