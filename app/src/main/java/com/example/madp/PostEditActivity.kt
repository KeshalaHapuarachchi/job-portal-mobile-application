package com.example.madp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.madp.databinding.ActivityPostEditBinding

class PostEditActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPostEditBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPostEditBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Retrieve data from intent extras
        val jobRole = intent.getStringExtra("jobRole")
        val salary = intent.getStringExtra("salary")
        val company = intent.getStringExtra("company")
        val address = intent.getStringExtra("address")
        val category = intent.getStringExtra("category")

        // Set the retrieved data to corresponding EditText fields
        binding.editTextTextPersonName2.setText(jobRole)
        binding.editTextTextPersonName4.setText(salary)
        binding.editTextTextPersonName.setText(company)
        binding.editTextTextPersonName3.setText(address)
        binding.editTextTextPersonName10.setText(category)

        binding.button3.setOnClickListener {
            // Retrieve the updated values from the EditText fields
            val updatedjobRole = binding.editTextTextPersonName2.text.toString()
            val updatedsalary = binding.editTextTextPersonName4.text.toString()
            val updatedcompany = binding.editTextTextPersonName.text.toString()
            val updatedaddress = binding.editTextTextPersonName3.text.toString()
            val updatedcategory = binding.editTextTextPersonName10.text.toString()

            if (updatedjobRole.isNotEmpty() && updatedsalary.isNotEmpty() && updatedcompany.isNotEmpty() && updatedaddress.isNotEmpty() && updatedcategory.isNotEmpty()) {
                // Create a new intent to pass the updated data back to the ProfileActivity
                val profileIntent = Intent(this, Post3Activity::class.java)
                profileIntent.putExtra("jobRole", updatedjobRole)
                profileIntent.putExtra("salary", updatedsalary)
                profileIntent.putExtra("company", updatedcompany)
                profileIntent.putExtra("address", updatedaddress)
                profileIntent.putExtra("category", updatedcategory)
                startActivity(profileIntent)

                Toast.makeText(this, "Job ad updated successfully !", Toast.LENGTH_SHORT).show() // Display a toast message to indicate successful update
            }
        }
    }
}