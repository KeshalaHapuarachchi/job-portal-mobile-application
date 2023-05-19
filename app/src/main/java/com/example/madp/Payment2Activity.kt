package com.example.madp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.madp.databinding.ActivityPayment2Binding

class Payment2Activity : AppCompatActivity() {

    private lateinit var binding: ActivityPayment2Binding
    private val PICK_IMAGE_REQUEST = 1
    private lateinit var selectedImageUri: Uri

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Set up view binding
        binding = ActivityPayment2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // Retrieve data from the previous activity
        val pmethod = intent.getStringExtra("pmethod")
        val total = intent.getStringExtra("total")
        val ads = intent.getStringExtra("ads")

        // Display the retrieved data in the appropriate fields
        binding.editTextTextPersonName8.text = pmethod
        binding.editTextTextPersonName5.text = total

        binding.button4.setOnClickListener {
            // Open a file picker to select an image
            val intent = Intent(Intent.ACTION_GET_CONTENT)
            intent.type = "image/*"
            startActivityForResult(intent, PICK_IMAGE_REQUEST)
        }

        // Clear the selected image and its corresponding text
        binding.button5.setOnClickListener {
            binding.imageView.setImageURI(null)
            binding.editTextTextPersonName4.text = "No file chosen"
            selectedImageUri = Uri.EMPTY
        }

        // Pass the data back to the previous activity for editing
        binding.button6.setOnClickListener {
            val pmethod = intent.getStringExtra("pmethod")
            val total = intent.getStringExtra("total")
            val ads = intent.getStringExtra("ads")

            val intent = Intent(this, EditPaymentActivity::class.java)
            intent.putExtra("pmethod", pmethod)
            intent.putExtra("total", total)
            intent.putExtra("ads", ads)

            startActivity(intent)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.data != null) {

            // Retrieve the selected image URI and display it
            selectedImageUri = data.data!!
            binding.imageView.setImageURI(selectedImageUri)
            binding.editTextTextPersonName4.text = selectedImageUri.toString()
        } else {
            Toast.makeText(this, "Upload the payment proof !", Toast.LENGTH_SHORT).show() // Display a toast message if no image is selected
        }

        binding.button3.setOnClickListener {
            if (selectedImageUri != Uri.EMPTY){
                startActivity(Intent(this, DashboardActivity::class.java)) // Proceed to the dashboard if a payment proof is uploaded
                Toast.makeText(this, "Payment Successful !", Toast.LENGTH_SHORT).show() // Display a toast message for the successful payment
            } else {
                Toast.makeText(this, "Upload the payment proof !", Toast.LENGTH_SHORT).show() // Display a toast message if no payment proof is uploaded
            }
        }
    }
}
