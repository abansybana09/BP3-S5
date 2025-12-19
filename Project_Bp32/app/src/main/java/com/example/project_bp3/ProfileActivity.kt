package com.example.project_bp3

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val usernameEditText = findViewById<EditText>(R.id.username_edittext)
        val updateButton = findViewById<Button>(R.id.update_button)
        val deleteButton = findViewById<Button>(R.id.delete_button)

        val currentUsername = intent.getStringExtra("USERNAME")
        usernameEditText.setText(currentUsername)

        updateButton.setOnClickListener {
            val newUsername = usernameEditText.text.toString()
            if (newUsername.isNotEmpty()) {
                val resultIntent = Intent()
                resultIntent.putExtra("NEW_USERNAME", newUsername)
                setResult(Activity.RESULT_OK, resultIntent)
                finish()
            } else {
                Toast.makeText(this, "Username tidak boleh kosong", Toast.LENGTH_SHORT).show()
            }
        }

        deleteButton.setOnClickListener {
            // TODO: Implement actual delete logic (e.g., from database)
            val resultIntent = Intent()
            resultIntent.putExtra("DELETE_PROFILE", true)
            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        }
    }
}