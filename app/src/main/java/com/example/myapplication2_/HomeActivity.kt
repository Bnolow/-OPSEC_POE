package com.example.myapplication2_

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity() {

    private lateinit var sharedPrefManager: SharedPrefManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        // Initialize the shared preferences manager
        sharedPrefManager = SharedPrefManager(this)

        // Find the logout button in the layout
        val logoutButton = findViewById<Button>(R.id.logoutButton)

        // Optionally, display a welcome message if user is logged in
        val welcomeMessage = findViewById<TextView>(R.id.welcomeMessage)
        val user = sharedPrefManager.getUser()
        if (user != null) {
            welcomeMessage.text = "Welcome, ${user.username}!"
        } else {
            welcomeMessage.text = "Welcome!"
        }

        // Set the logout button click listener
        logoutButton.setOnClickListener {
            // Perform the logout action (clear shared preferences)
            sharedPrefManager.logout()

            // Redirect to the LoginActivity after logout
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }
}
