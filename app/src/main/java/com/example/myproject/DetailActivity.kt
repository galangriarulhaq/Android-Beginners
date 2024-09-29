package com.example.myproject

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class DetailActivity : AppCompatActivity() {

    companion object {
        const val KEY_PIRATE = "key_pirate"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        supportActionBar?.setDisplayShowTitleEnabled(false)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val imgPhoto: ImageView = findViewById(R.id.img_pirate)
        val tvName: TextView = findViewById(R.id.tv_name)
        val tvDescription: TextView = findViewById(R.id.tv_detail_description)
        val tvTitle: TextView = findViewById(R.id.tv_title)

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
            tvTitle.text = data.title
        }

        val btnShare: Button = findViewById(R.id.btn_action_share)

        btnShare.setOnClickListener {
            val message = "Nama Karakter : ${tvName.text}\nArtikel :\n\t${tvDescription.text}"
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_TEXT, message)

            intent.setPackage("com.whatsapp")

            try {
                startActivity(intent)
            } catch (e: Exception) {
                Toast.makeText(this, "WhatsApp tidak terinstall", Toast.LENGTH_SHORT).show()
            }
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }

}