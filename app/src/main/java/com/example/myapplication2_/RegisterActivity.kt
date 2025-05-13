
package com.example.myapplication2_

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.financemanager.SharedPrefManager
import com.example.financemanager.User

class RegisterActivity : AppCompatActivity() {
    private lateinit var sharedPrefManager: SharedPrefManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        sharedPrefManager = SharedPrefManager(this)

        val usernameEditText = findViewById<EditText>(R.id.usernameEditText)
        val passwordEditText = findViewById<EditText>(R.id.passwordEditText)
        val registerButton = findViewById<Button>(R.id.registerButton)

        registerButton.setOnClickListener {
            val username = usernameEditText.text.toString().trim()
            val password = passwordEditText.text.toString().trim()

            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please enter username and password", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            sharedPrefManager.saveUser(User(username, password))
            sharedPrefManager.setLoggedIn(true)

            Toast.makeText(this, "Registration successful", Toast.LENGTH_SHORT).show()

            startActivity(Intent(this, HomeActivity::class.java))
            finish()
        }
    }
}
