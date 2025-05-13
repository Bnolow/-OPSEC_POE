package com.example.financemanager

import android.content.Context
import android.content.SharedPreferences

data class User(val username: String, val password: String)

class SharedPrefManager(context: Context) {

    // Access SharedPreferences
    private val prefs: SharedPreferences = context.getSharedPreferences("user_prefs", Context.MODE_PRIVATE)

    // Save user credentials to SharedPreferences
    fun saveUser(user: User) {
        prefs.edit()
            .putString("username", user.username)
            .putString("password", user.password)
            .apply()  // Apply changes asynchronously
    }

    // Get user credentials from SharedPreferences
    fun getUser(): User? {
        val username = prefs.getString("username", null)
        val password = prefs.getString("password", null)

        // Return a User object if credentials exist, else null
        return if (username != null && password != null) {
            User(username, password)
        } else {
            null
        }
    }

    // Save login status
    fun setLoggedIn(loggedIn: Boolean) {
        prefs.edit().putBoolean("logged_in", loggedIn).apply()
    }

    // Get the login status
    fun isLoggedIn(): Boolean {
        return prefs.getBoolean("logged_in", false)
    }

    // Log out by clearing SharedPreferences
    fun logout() {
        prefs.edit().clear().apply()
    }
}
