package com.example.madp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.madp.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Set up view binding
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize FirebaseAuth instance
        firebaseAuth = FirebaseAuth.getInstance()

        // Login button click
        binding.button3.setOnClickListener {
            val email = binding.editTextTextPersonName2.text.toString()
            val pass = binding.editTextTextPersonName.text.toString()

            if (email.isNotEmpty() && pass.isNotEmpty()) {
                // Sign in with email and password using FirebaseAuth
                firebaseAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener {
                    if (it.isSuccessful) {
                        startActivity(Intent(this, DashboardActivity::class.java)) // If login is successful, start DashboardActivity
                    } else {
                        Toast.makeText(this, "Incorrect email or password !", Toast.LENGTH_SHORT).show() // If login fails, show error message with a toast
                    }
                }
            } else {
                Toast.makeText(this, "Empty Fields Are not Allowed !", Toast.LENGTH_SHORT).show() // Show error message when email or password fields are empty
            }
        }

        binding.signuptextView.setOnClickListener {
            startActivity(Intent(this, Register1Activity::class.java)) // Start Register1Activity for user registration
        }
    }
}