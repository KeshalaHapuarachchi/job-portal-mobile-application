package com.example.madp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.madp.databinding.ActivityPost1Binding

class Post1Activity : AppCompatActivity() {

    private lateinit var binding: ActivityPost1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPost1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button3.setOnClickListener {
            // Retrieve input values from the text fields
            val jobRole = binding.editTextTextPersonName2.text.toString()
            val salary = binding.editTextTextPersonName4.text.toString()
            val company = binding.editTextTextPersonName.text.toString()
            val address = binding.editTextTextPersonName3.text.toString()
            val category = binding.editTextTextPersonName10.text.toString()

            if (jobRole.isNotEmpty() && salary.isNotEmpty() && company.isNotEmpty() && address.isNotEmpty() && category.isNotEmpty()){
                // Proceed to the next activity if all fields are filled
                val intent = Intent(this, Post2Activity::class.java)
                intent.putExtra("jobRole", jobRole)
                intent.putExtra("salary", salary)
                intent.putExtra("company", company)
                intent.putExtra("address", address)
                intent.putExtra("category", category)
                startActivity(intent)
            }
            else {
                Toast.makeText(this, "Empty Fields Are not Allowed !", Toast.LENGTH_SHORT).show() // Display a toast message if any field is empty
            }
        }
    }
}
