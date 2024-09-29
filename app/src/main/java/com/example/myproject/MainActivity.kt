package com.example.myproject

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var rvPirates: RecyclerView
    private val list = ArrayList<Pirate>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        supportActionBar?.setDisplayShowTitleEnabled(false)

        rvPirates = findViewById(R.id.rv_pirates)
        rvPirates.setHasFixedSize(true)

        list.addAll(getListPirates())
        showRecycleList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.about_page -> {
                val intent = Intent(this@MainActivity, AboutActivity::class.java)
                startActivity(intent)
            }
        }

        return super.onOptionsItemSelected(item)
    }

    private fun getListPirates(): ArrayList<Pirate> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val dataTitle = resources.getStringArray(R.array.data_title)
        val listPirate = ArrayList<Pirate>()

        for ( i in dataName.indices) {
            val pirate = Pirate(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1), dataTitle[i])
            listPirate.add(pirate)
        }
        return listPirate
    }

    private fun showRecycleList() {
        rvPirates.layoutManager = LinearLayoutManager(this)
        val listPirateAdapter = ListPirateAdapter(list)
        rvPirates.adapter = listPirateAdapter
    }

}