package com.example.project_bp3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class PanduanWudhuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_panduan_wudhu)

        val backButton = findViewById<ImageView>(R.id.button_back)
        backButton.setOnClickListener {
            finish()
        }

        val pengertianButton = findViewById<ImageView>(R.id.pengertian)
        pengertianButton.setOnClickListener {
            val intent = Intent(this, PengertianWudhuActivity::class.java)
            startActivity(intent)
        }

        val batalButton = findViewById<ImageView>(R.id.batal)
        batalButton.setOnClickListener {
            val intent = Intent(this, MembatalkanWudhuActivity::class.java)
            startActivity(intent)
        }

        val airButton = findViewById<ImageView>(R.id.air)
        airButton.setOnClickListener {
            val intent = Intent(this, AirYangBolehDipakaiActivity::class.java)
            startActivity(intent)
        }

        val hukumButton = findViewById<ImageView>(R.id.wajib) // Assuming 'wajib' is the id for 'kapan'
        hukumButton.setOnClickListener {
            val intent = Intent(this, HukumWudhuActivity::class.java)
            startActivity(intent)
        }

        val amalanButton = findViewById<ImageView>(R.id.amalan)
        amalanButton.setOnClickListener {
            val intent = Intent(this, SunnahWudhuActivity::class.java)
            startActivity(intent)
        }
    }
}
