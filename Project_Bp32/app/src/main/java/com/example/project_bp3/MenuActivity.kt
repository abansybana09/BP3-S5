package com.example.project_bp3

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView

class MenuActivity : AppCompatActivity() {

    private lateinit var usernameTextView: TextView
    private val PROFILE_REQUEST_CODE = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val username = intent.getStringExtra("USERNAME")
        usernameTextView = findViewById<TextView>(R.id.username_textview)
        usernameTextView.text = username

        val exitButton = findViewById<ImageButton>(R.id.exit_button)
        exitButton.setOnClickListener {
            finish()
        }

        val usernameLayout = findViewById<RelativeLayout>(R.id.username_layout)
        usernameLayout.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)
            intent.putExtra("USERNAME", usernameTextView.text.toString())
            startActivityForResult(intent, PROFILE_REQUEST_CODE)
        }

        val beforeWudhuButton = findViewById<ImageButton>(R.id.before_wudhu_button)
        val learnWudhuButton = findViewById<ImageButton>(R.id.learn_wudhu_button)
        val afterWudhuButton = findViewById<ImageButton>(R.id.after_wudhu_button)
        val panduanWudhuButton = findViewById<ImageView>(R.id.panduan_wudhu_button)

        // Menambahkan listener untuk tombol "Do'a Sebelum Wudhu"
        beforeWudhuButton.setOnClickListener {
            val intent = Intent(this, DoaSebelumWudhuActivity::class.java)
            startActivity(intent)
        }

        // Menambahkan listener untuk tombol "Belajar Wudhu"
        learnWudhuButton.setOnClickListener {
            val intent = Intent(this, BelajarWudhuActivity::class.java)
            startActivity(intent)
        }

        // Menambahkan listener untuk tombol "Do'a Sesudah Wudhu"
        afterWudhuButton.setOnClickListener {
             val intent = Intent(this, DoaSesudahActivity::class.java)
             startActivity(intent)
        }

        panduanWudhuButton.setOnClickListener {
            val intent = Intent(this, PanduanWudhuActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == PROFILE_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            data?.let {
                if (it.getBooleanExtra("DELETE_PROFILE", false)) {
                    // Jika profil dihapus, kembali ke layar sebelumnya (misalnya login)
                    finish()
                } else {
                    val newUsername = it.getStringExtra("NEW_USERNAME")
                    if (newUsername != null) {
                        usernameTextView.text = newUsername
                    }
                }
            }
        }
    }
}