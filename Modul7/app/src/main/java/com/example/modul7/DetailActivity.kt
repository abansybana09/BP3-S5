package com.example.modul7

import android.os.Build
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_KAMPUS = "extra_kampus"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val imgDetailPhoto: ImageView = findViewById(R.id.img_detail_photo)
        val tvDetailName: TextView = findViewById(R.id.tv_detail_name)
        val tvDetailLokasi: TextView = findViewById(R.id.tv_detail_lokasi)
        val tvDetailSejarah: TextView = findViewById(R.id.tv_detail_sejarah)

        val kampus = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra(EXTRA_KAMPUS, Kampus::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra(EXTRA_KAMPUS)
        }

        if (kampus != null) {
            imgDetailPhoto.setImageResource(kampus.photo)
            tvDetailName.text = kampus.name
            tvDetailLokasi.text = kampus.lokasi
            tvDetailSejarah.text = kampus.sejarah
        }
    }
}