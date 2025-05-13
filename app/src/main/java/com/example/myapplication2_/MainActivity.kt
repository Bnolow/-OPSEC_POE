package com.example.myapplication2_

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Apply padding for system bars
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // UI Elements
        val usernameEditText = findViewById<EditText>(R.id.Username)
        val passwordEditText = findViewById<EditText>(R.id.Password)
        val loginButton = findViewById<Button>(R.id.Login)
        val createAccountText = findViewById<TextView>(R.id.CreateAccount)

        // Handle login button click
        loginButton.setOnClickListener {
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()

            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please enter both username and password", Toast.LENGTH_SHORT).show()
            } else {
                // TODO: Replace with real login validation logic
                Toast.makeText(this, "Logging in as $username", Toast.LENGTH_SHORT).show()

                // Example: navigate to HomeActivity
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
            }
        }

        // Navigate to RegisterActivity when "Create one" is clicked
        createAccountText.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}
