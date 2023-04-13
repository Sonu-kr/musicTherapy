package com.example.musictherapy
import android.content.Intent
import android.media.MediaPlayer
import android.os.AsyncTask
import android.os.Bundle
import android.os.Environment
import android.view.View
import android.widget.*
import android.widget.AdapterView.OnItemClickListener
import androidx.appcompat.app.AppCompatActivity
import java.io.File

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnSubmit = findViewById<Button>(R.id.btnSubmit)


        val spinner = findViewById<Spinner>(R.id.ddGender)
        val genderOptions = arrayOf("Male", "Female")
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, genderOptions)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        val spinnerType = findViewById<Spinner>(R.id.ddtype)
        val Options = arrayOf("Mild", "Moderate","Severe")
        val aadapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, Options)
        aadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerType.adapter = aadapter

        btnSubmit.setOnClickListener {
            val intent = Intent(this,HomePage::class.java)
            startActivity(intent)
        }
    }
}
