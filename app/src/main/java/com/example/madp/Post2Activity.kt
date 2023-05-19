package com.example.madp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.madp.databinding.ActivityPost2Binding

class Post2Activity : AppCompatActivity() {

    private lateinit var binding: ActivityPost2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPost2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // Retrieve data from intent extras
        val jobRole = intent.getStringExtra("jobRole")
        val salary = intent.getStringExtra("salary")
        val company = intent.getStringExtra("company")
        val address = intent.getStringExtra("address")
        val category = intent.getStringExtra("category")

        // Set the retrieved data to corresponding TextView fields
        binding.editTextTextPersonName2.text = jobRole
        binding.editTextTextPersonName4.text = salary
        binding.editTextTextPersonName.text = company
        binding.editTextTextPersonName3.text = address
        binding.editTextTextPersonName11.text = category

        binding.button.setOnClickListener {
            // Proceed to the next activity and pass the data to it
            val intent = Intent(this, Post3Activity::class.java)
            intent.putExtra("jobRole", jobRole)
            intent.putExtra("salary", salary)
            intent.putExtra("company", company)
            intent.putExtra("address", address)
            intent.putExtra("category", category)
            startActivity(intent)

            Toast.makeText(this, "Job ad posted successfully !", Toast.LENGTH_SHORT).show() // Display a toast message to indicate successful job ad posting
        }
    }
}
