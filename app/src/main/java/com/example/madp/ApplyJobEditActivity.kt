package com.example.madp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.madp.databinding.ActivityApplyJobEditBinding

class ApplyJobEditActivity : AppCompatActivity() {

    private lateinit var binding: ActivityApplyJobEditBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityApplyJobEditBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Retrieve data from intent extras
        val name = intent.getStringExtra("name")
        val email = intent.getStringExtra("email")
        val contact = intent.getStringExtra("contact")
        val cv = intent.getStringExtra("cv")

        // Set the retrieved data to corresponding EditText fields
        binding.editTextTextPersonName16.setText(name)
        binding.editTextTextPersonName17.setText(email)
        binding.editTextTextPersonName18.setText(contact)

        // Set click listener for button14
        binding.button14.setOnClickListener {
            val updatedname = binding.editTextTextPersonName16.text.toString()
            val updatedemail = binding.editTextTextPersonName17.text.toString()
            val updatedcontact = binding.editTextTextPersonName18.text.toString()

            if (updatedname.isNotEmpty() && updatedemail.isNotEmpty() && updatedcontact.isNotEmpty()) {
                // Create a new intent to pass the updated data back to the ProfileActivity
                val profileIntent = Intent(this, ApplyJob3Activity::class.java)
                profileIntent.putExtra("name", updatedname)
                profileIntent.putExtra("email", updatedemail)
                profileIntent.putExtra("contact", updatedcontact)
                profileIntent.putExtra("cv", cv)
                startActivity(profileIntent) // Start ApplyJob3Activity with the updated data

                Toast.makeText(this, "Your details updated successfully !", Toast.LENGTH_SHORT).show() // Show a toast message indicating successful update
            } else {
                Toast.makeText(this, "Empty Fields Are not Allowed !", Toast.LENGTH_SHORT).show() // Show a toast message indicating that empty fields are not allowed
            }
        }
    }
}