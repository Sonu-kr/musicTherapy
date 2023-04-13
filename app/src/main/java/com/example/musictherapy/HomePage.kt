package com.example.musictherapy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.cardview.widget.CardView

class HomePage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)

        // use arrayadapter and define an array
        val arrayAdapter: ArrayAdapter<*>
        val users = arrayOf(
            "Anxiety and depression", "Autism", "Cancer", "Chronic pain", "Dementia and Alzheimer's disease", "Eating disorders", "Heart disease and stroke", "Insomnia and sleep disorders", "Parkinson's disease", "Post-traumatic stress disorder (PTSD)", "Substance abuse and addiction", "Traumatic brain injury (TBI)","Anxiety and depression", "Autism", "Cancer", "Chronic pain", "Dementia and Alzheimer's disease", "Eating disorders", "Heart disease and stroke", "Insomnia and sleep disorders", "Parkinson's disease", "Post-traumatic stress disorder (PTSD)", "Substance abuse and addiction", "Traumatic brain injury (TBI)"

        )

        // access the listView from xml file
        var mListView = findViewById<ListView>(R.id.userlist)
        var cdSleep = findViewById<CardView>(R.id.cdSleep)
        var cdMeditation = findViewById<CardView>(R.id.cdMeditation)
        var cdFocus = findViewById<CardView>(R.id.cdFocus)
        var cdRelex = findViewById<CardView>(R.id.cdRelex)

        cdMeditation.setOnClickListener {
            val intent = Intent(this,MediaPlayerr::class.java)
            val uri = "https://firebasestorage.googleapis.com/v0/b/canmnvas.appspot.com/o/SnapInsta.io%20-%2030%20Min%20Deep%20Sleep%20Music%20To%20Fall%20Asleep%20Instantly%20(64%20kbps).mp3?alt=media&token=e522207e-da54-4a51-b6bd-8c59b0666f6a";
            intent.putExtra("musicFilepath",uri)
            startActivity(intent)
        }
        cdFocus.setOnClickListener {
            val intent = Intent(this,MediaPlayerr::class.java)
            val uri = "https://firebasestorage.googleapis.com/v0/b/canmnvas.appspot.com/o/SnapInsta.io%20-%2015%20Minutes%20Study%20%26%20Focus%20Music%20_%20Mind%20Power%20for%20Deep%20Concentration%20(128%20kbps).mp3?alt=media&token=24f9b47c-32d3-49ea-8ab3-97fa7e8e49c8";
            intent.putExtra("musicFilepath",uri)
            startActivity(intent)
        }
        cdRelex.setOnClickListener {
            val intent = Intent(this,MediaPlayerr::class.java)
            val uri = "https://firebasestorage.googleapis.com/v0/b/canmnvas.appspot.com/o/SnapInsta.io%20-%2015%20Minutes%20Study%20%26%20Focus%20Music%20_%20Mind%20Power%20for%20Deep%20Concentration%20(128%20kbps).mp3?alt=media&token=24f9b47c-32d3-49ea-8ab3-97fa7e8e49c8";
            intent.putExtra("musicFilepath",uri)
            startActivity(intent)
        }
        cdSleep.setOnClickListener {
            val intent = Intent(this,MediaPlayerr::class.java)
            val uri = "https://firebasestorage.googleapis.com/v0/b/canmnvas.appspot.com/o/SnapInsta.io%20-%2015%20Minutes%20Study%20%26%20Focus%20Music%20_%20Mind%20Power%20for%20Deep%20Concentration%20(128%20kbps).mp3?alt=media&token=24f9b47c-32d3-49ea-8ab3-97fa7e8e49c8";
            intent.putExtra("musicFilepath",uri)
            startActivity(intent)
        }
        arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, users)
        mListView.adapter = arrayAdapter

        mListView.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            // handle item click event here
            val selectedItem = mListView.getItemAtPosition(position) as String
            val itemIdAtPos = mListView.getItemIdAtPosition(position)

            Toast.makeText(this,selectedItem,Toast.LENGTH_SHORT).show()
            Toast.makeText(this,itemIdAtPos.toString(),Toast.LENGTH_SHORT).show()

            val intent = Intent(this,MusicActivity::class.java)
            startActivity(intent)

        }
    }
}