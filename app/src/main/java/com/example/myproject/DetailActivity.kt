package com.example.myproject

import android.os.Build
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetailActivity : AppCompatActivity() {

    companion object {
        const val KEY_PIRATE = "key_pirate"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val imgPhoto: ImageView = findViewById(R.id.img_pirate)
        val tvName: TextView = findViewById(R.id.tv_name)
        val tvDescription: TextView = findViewById(R.id.tv_description)

        val data = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<Pirate>(KEY_PIRATE, Pirate::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Pirate>(KEY_PIRATE)
        }

        if (data != null) {
            imgPhoto.setImageResource(data.photo)
            tvName.text = data.name
            tvDescription.text = data.description
        }

    }
}