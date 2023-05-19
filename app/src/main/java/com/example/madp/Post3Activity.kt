package com.example.madp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.madp.databinding.ActivityPost3Binding

class Post3Activity : AppCompatActivity() {

    private lateinit var binding: ActivityPost3Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPost3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // Retrieve data from intent extras
        val jobRole = intent.getStringExtra("jobRole")
        val salary = intent.getStringExtra("salary")
        val company = intent.getStringExtra("company")
        val address = intent.getStringExtra("address")
        val category = intent.getStringExtra("category")

        // Set the retrieved data to corresponding TextView fields
        binding.textView.text = jobRole
        binding.textView10.text = salary
        binding.textView12.text = company
        binding.textView13.text = address
        binding.textView14.text = category

        binding.button3.setOnClickListener {
            // Proceed to the edit activity and pass the data to it
            val intent = Intent(this, PostEditActivity::class.java)
            intent.putExtra("jobRole", jobRole)
            intent.putExtra("salary", salary)
            intent.putExtra("company", company)
            intent.putExtra("address", address)
            intent.putExtra("category", category)
            startActivity(intent)
        }

        binding.button2.setOnClickListener{
            // delete the data
            val sharedPreferences = getSharedPreferences("post_data", MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.remove("job_role")
            editor.remove("salary")
            editor.remove("company")
            editor.remove("address")
            editor.remove("category")
            editor.apply()

            Toast.makeText(this, "Job ad deleted successfully !", Toast.LENGTH_SHORT).show() // Display a toast message to indicate successful deletion

            // finish the activity and go back to the previous one
            finish()
            startActivity(Intent(this, Post3Activity::class.java)) // Finish the activity and go back to the previous one
        }

        binding.button4.setOnClickListener {
            startActivity(Intent(this, DashboardActivity::class.java)) // Go back to the dashboard activity
        }
    }
}
