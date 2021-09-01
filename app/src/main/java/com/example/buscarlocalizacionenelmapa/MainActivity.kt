package com.example.buscarlocalizacionenelmapa

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    lateinit var localizacionEdit:EditText
    lateinit var botonMap:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        localizacionEdit = findViewById<EditText>(R.id.localizacionEdit)
        
        botonMap = findViewById<Button>(R.id.botonMap)

        botonMap.setOnClickListener {
            val mapsUri = Uri.parse("geo:0,0?q=${localizacionEdit.text.toString()}")
            val mapsIntent = Intent(Intent.ACTION_VIEW, mapsUri)
            mapsIntent.setPackage("com.google.android.apps.maps")
            startActivity(mapsIntent)
        }
    }
}