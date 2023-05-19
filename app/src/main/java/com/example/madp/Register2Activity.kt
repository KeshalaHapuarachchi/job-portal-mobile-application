package com.example.madp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.madp.databinding.ActivityRegister2Binding
import com.google.firebase.auth.FirebaseAuth

class Register2Activity : AppCompatActivity() {

    private lateinit var binding: ActivityRegister2Binding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRegister2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize Firebase Auth
        firebaseAuth = FirebaseAuth.getInstance()

        binding.button3.setOnClickListener {
            // Retrieve user input from EditText fields
            val uname = binding.editTextTextPersonName2.text.toString()
            val email = binding.editTextTextPersonName4.text.toString()
            val pass = binding.editTextTextPersonName.text.toString()
            val confirmPass = binding.editTextTextPersonName3.text.toString()

            // Retrieve data passed from previous activity as intent extras
            val fullName = intent.getStringExtra("full_name")
            val address = intent.getStringExtra("address")
            val age = intent.getStringExtra("age")
            val gender = intent.getStringExtra("gender")

            if (email.isNotEmpty() && pass.isNotEmpty() && confirmPass.isNotEmpty()) {
                if (pass == confirmPass) {
                    // Create user using Firebase Authentication
                    firebaseAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener {
                        if (it.isSuccessful) {
                            // User creation successful, navigate to ProfileActivity and pass user data as intent extras
                            val profileIntent = Intent(this, ProfileActivity::class.java)
                            profileIntent.putExtra("full_name", fullName)
                            profileIntent.putExtra("e_mail", email)
                            profileIntent.putExtra("address", address)
                            profileIntent.putExtra("age", age)
                            profileIntent.putExtra("gender", gender)
                            startActivity(profileIntent)
                        } else {
                            Toast.makeText(this, "Email already exists !", Toast.LENGTH_SHORT).show() // User creation failed, display error message
                        }
                    }
                } else {
                    Toast.makeText(this, "Password is not matching !", Toast.LENGTH_SHORT).show() // Display error message if password and confirm password do not match
                }
            } else {
                Toast.makeText(this, "Empty Fields Are not Allowed !", Toast.LENGTH_SHORT).show() // Display error message if any of the fields are empty
            }
        }
    }
}
