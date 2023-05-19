package com.example.madp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.madp.databinding.ActivityApplyJob2Binding

class ApplyJob2Activity : AppCompatActivity() {

    private lateinit var binding: ActivityApplyJob2Binding
    private val PICK_IMAGE_REQUEST = 1
    private lateinit var selectedImageUri: Uri

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityApplyJob2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set click listener for button16
        binding.button16.setOnClickListener {
            val intent = Intent(Intent.ACTION_GET_CONTENT)
            intent.type = "image/*"
            startActivityForResult(intent, PICK_IMAGE_REQUEST) // Start activity to pick an image
        }

        // Set click listener for button12
        binding.button12.setOnClickListener {
            binding.imageView.setImageURI(null) // Clear the image view
            binding.editTextTextPersonName15.text = "No file chosen" // Set the text to indicate no file is chosen
            selectedImageUri = Uri.EMPTY // Set the selected image URI to empty
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.data != null) {
            selectedImageUri = data.data!!
            binding.imageView.setImageURI(selectedImageUri) // Set the selected image to the image view
            binding.editTextTextPersonName15.text = selectedImageUri.toString() // Set the text to display the selected image URI
        }

        // Set click listener for button14
        binding.button14.setOnClickListener {
            val name = binding.editTextTextPersonName16.text.toString()
            val email = binding.editTextTextPersonName17.text.toString()
            val contact = binding.editTextTextPersonName18.text.toString()
            val cv = binding.editTextTextPersonName15.text.toString()

            if (name.isNotEmpty() && email.isNotEmpty() && contact.isNotEmpty() && cv.isNotEmpty()) {
                val intent = Intent(this, ApplyJob3Activity::class.java)
                intent.putExtra("name", name)
                intent.putExtra("email", email)
                intent.putExtra("contact", contact)
                intent.putExtra("cv", cv)

                if (selectedImageUri != Uri.EMPTY) {
                    startActivity(intent) // Start ApplyJob3Activity with the provided data
                } else {
                    Toast.makeText(this, "Upload the CV !", Toast.LENGTH_SHORT).show() // Show a toast message if no CV is uploaded
                }
            }
        }
    }
}