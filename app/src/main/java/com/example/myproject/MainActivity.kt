package com.example.myproject

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager

class MainActivity : AppCompatActivity() {

    private lateinit var rvPirates: RecyclerView
    private val list = ArrayList<Pirate>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvPirates = findViewById(R.id.rv_pirates)
        rvPirates.setHasFixedSize(true)

        list.addAll(getListPirates())
        showRecycleList()
    }

    private fun getListPirates(): ArrayList<Pirate> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listPirate = ArrayList<Pirate>()

        for ( i in dataName.indices) {
            val pirate = Pirate(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1))
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