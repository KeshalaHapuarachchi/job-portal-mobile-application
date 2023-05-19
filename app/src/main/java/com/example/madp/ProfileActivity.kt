package com.example.madp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.madp.databinding.ActivityProfileBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class ProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProfileBinding
    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance()

        // Retrieve data from intent extras
        val fullName = intent.getStringExtra("full_name")
        val email = intent.getStringExtra("e_mail")
        val address = intent.getStringExtra("address")
        val age = intent.getStringExtra("age")
        val gender = intent.getStringExtra("gender")

        // Set the retrieved data to corresponding TextView fields
        binding.editTextTextPersonName5.text = fullName
        binding.editTextTextPersonName7.text = email
        binding.editTextTextPersonName9.text = address
        binding.editTextTextPersonName11.text = age
        binding.editTextTextPersonName10.text = gender

        binding.button6.setOnClickListener {
            mAuth.signOut()
            startActivity(Intent(this, LoginActivity::class.java)) // Sign out the user and navigate to the LoginActivity
            finish()
        }

        binding.button4.setOnClickListener {
            val intent = Intent(this, EditActivity::class.java)
            intent.putExtra("full_name", fullName)
            intent.putExtra("e_mail", email)
            intent.putExtra("address", address)
            intent.putExtra("age", age)
            intent.putExtra("gender", gender)
            startActivity(intent) // Navigate to the EditActivity to edit user profile
        }

        binding.button5.setOnClickListener {
            val user = mAuth.currentUser

            user?.delete()?.addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    // Delete user's data from Firebase Realtime Database
                    val databaseRef = FirebaseDatabase.getInstance().getReference("Users")
                    databaseRef.child(user.uid).removeValue().addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            Toast.makeText(this, "User account deleted successfully !", Toast.LENGTH_SHORT).show() // Toast message to display the user account deleted
                            startActivity(Intent(this, MainActivity::class.java))
                            finish()
                        } else {
                            Toast.makeText(this, "Failed to delete user data !", Toast.LENGTH_SHORT).show() // Toast message to display fail to delete the user data
                        }
                    }
                } else {
                    Toast.makeText(this, "Failed to delete user account !", Toast.LENGTH_SHORT).show() // Toast message to display fail to delete the user account
                }
            }
        }
    }
}
