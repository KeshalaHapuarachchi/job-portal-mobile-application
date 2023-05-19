package com.example.madp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.madp.databinding.ActivityApplyJob3Binding

class ApplyJob3Activity : AppCompatActivity() {

    private lateinit var binding: ActivityApplyJob3Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityApplyJob3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // Retrieve data from intent extras
        val name = intent.getStringExtra("name")
        val email = intent.getStringExtra("email")
        val contact = intent.getStringExtra("contact")
        val cv = intent.getStringExtra("cv")

        // Set the retrieved data to corresponding TextView fields
        binding.editTextTextPersonName16.text = name
        binding.editTextTextPersonName17.text = email
        binding.editTextTextPersonName18.text = contact
        binding.editTextTextPersonName15.text = cv

        // Set click listener for button15
        binding.button15.setOnClickListener {
            val intent = Intent(this, ApplyJobEditActivity::class.java)
            intent.putExtra("name", name)
            intent.putExtra("email", email)
            intent.putExtra("contact", contact)
            intent.putExtra("cv", cv)
            startActivity(intent) // Start ApplyJobEditActivity with the provided data
        }

        // Set click listener for button14
        binding.button14.setOnClickListener {
            Toast.makeText(this, "You applied the job successfully !", Toast.LENGTH_SHORT).show() // Show a toast message indicating successful job application
            startActivity(Intent(this, DashboardActivity::class.java)) // Start DashboardActivity
        }
    }
}