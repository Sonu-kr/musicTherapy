package com.example.musictherapy

import android.annotation.SuppressLint
import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ListView
import android.widget.Toast
import com.example.musictherapy.MusicListAdapter

class MusicActivity : AppCompatActivity() {
    private var mediaPlayer: MediaPlayer? = null
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_music)

        val listView = findViewById<ListView>(R.id.listView)
        val musicFiles = listOf(
            MusicFile("Song 1", "https://firebasestorage.googleapis.com/v0/b/canmnvas.appspot.com/o/01%20Sonata%20in%20C%20K545%2C%20I.mp3?alt=media&token=027cee4f-2c98-48bd-a96d-959501693200"),
            MusicFile("Anxiety Track 1", "https://firebasestorage.googleapis.com/v0/b/canmnvas.appspot.com/o/y2mate.com%20-%20Om%20Namah%20Shivaya%20%20Krishna%20Das%20Live%20Songs%20With%20Lyrics.mp3?alt=media&token=2a9e8fba-e415-4a33-aaf7-af8232218a7a"),
            MusicFile("Anxiety Track 2","https://firebasestorage.googleapis.com/v0/b/canmnvas.appspot.com/o/01a01.mp3?alt=media&token=db65fc95-64ac-4ecb-b1ed-1df73aae52a6"),
            MusicFile("Anxiety Track 3","https://firebasestorage.googleapis.com/v0/b/canmnvas.appspot.com/o/01a02.mp3?alt=media&token=ed41b43a-a5bb-4b6f-95eb-8379113d8805"),
            MusicFile("Anxiety Track 4","https://firebasestorage.googleapis.com/v0/b/canmnvas.appspot.com/o/01a03.mp3?alt=media&token=d8409ef5-8db5-4200-b6c9-8e9f57c72db7"),
            MusicFile("CronicPain Track 1","https://firebasestorage.googleapis.com/v0/b/canmnvas.appspot.com/o/01a08.mp3?alt=media&token=8bcad66c-9b03-4698-afe8-e7223dd36274"),
            MusicFile("CronicPain Track 2","https://firebasestorage.googleapis.com/v0/b/canmnvas.appspot.com/o/01a09.mp3?alt=media&token=f528c477-c076-41d3-93e3-3b89baff78cc"),
            MusicFile("CronicPain Track 3","https://firebasestorage.googleapis.com/v0/b/canmnvas.appspot.com/o/01a10.mp3?alt=media&token=a61df0da-4ac8-42a1-bf5d-92a530f7f11f"),
            MusicFile("CronicPain Track 4","https://firebasestorage.googleapis.com/v0/b/canmnvas.appspot.com/o/01a11.mp3?alt=media&token=610cace3-a6c5-488b-a487-ef4b8efd251a"),
            MusicFile("Insomnia Track 1","https://firebasestorage.googleapis.com/v0/b/canmnvas.appspot.com/o/01a12.mp3?alt=media&token=50cf9c22-ab81-4fc3-b559-f29469399dea"),
            MusicFile("Insomnia Track 2","https://firebasestorage.googleapis.com/v0/b/canmnvas.appspot.com/o/01a13.mp3?alt=media&token=a6248d44-7e59-453a-a271-1a8735db7bac"),
            MusicFile("Insomnia Track 3","https://firebasestorage.googleapis.com/v0/b/canmnvas.appspot.com/o/01a14.mp3?alt=media&token=38424a3a-f98a-452b-8ada-24d5bd386a34"),
            MusicFile("Insomnia Track 4","https://firebasestorage.googleapis.com/v0/b/canmnvas.appspot.com/o/01a15.mp3?alt=media&token=53d87865-a56f-454b-9aa8-9df5c3bf1a24"),
            MusicFile("Parkinson's Track 1","https://firebasestorage.googleapis.com/v0/b/canmnvas.appspot.com/o/01a16.mp3?alt=media&token=3546882a-4a51-47f6-9999-212da8b61207"),
            MusicFile("Parkinson's Track 2","https://firebasestorage.googleapis.com/v0/b/canmnvas.appspot.com/o/01a16.mp3?alt=media&token=3546882a-4a51-47f6-9999-212da8b61207"),
            MusicFile("Parkinson's Track 3","https://firebasestorage.googleapis.com/v0/b/canmnvas.appspot.com/o/01a18.mp3?alt=media&token=69c61235-a50c-4e22-8923-04e53c1902b0"),
            MusicFile("Parkinson's Track 4","https://firebasestorage.googleapis.com/v0/b/canmnvas.appspot.com/o/01a19.mp3?alt=media&token=7f27ddb4-0f18-4b9a-99c8-e722b5861e25"),
            MusicFile("Alzheimer's Track 1","https://firebasestorage.googleapis.com/v0/b/canmnvas.appspot.com/o/01a20.mp3?alt=media&token=5aa9d300-b302-47fe-8ffb-d9a79b753ea1"),
            MusicFile("Alzheimer's Track 2","https://firebasestorage.googleapis.com/v0/b/canmnvas.appspot.com/o/01b01.mp3?alt=media&token=563f838c-ab08-417f-9608-a12f0731d5df"),
            MusicFile("Alzheimer's Track 3","https://firebasestorage.googleapis.com/v0/b/canmnvas.appspot.com/o/01b01.mp3?alt=media&token=563f838c-ab08-417f-9608-a12f0731d5df"),
            MusicFile("Alzheimer's Track 4","https://firebasestorage.googleapis.com/v0/b/canmnvas.appspot.com/o/01b01.mp3?alt=media&token=563f838c-ab08-417f-9608-a12f0731d5df")
        )
        val adapter = MusicListAdapter(this, musicFiles)
        listView.adapter = adapter
        listView.setOnItemClickListener { _, _, position, _ ->


            val musicFile = musicFiles[position]
            val intent = Intent(this,MediaPlayerr::class.java) // This is the activity which contains play pause button
            intent.putExtra("musicFilepath",musicFile.path)
            Log.d("Md",musicFile.path)
            startActivity(intent) // I have added it now
//            mediaPlayer?.stop()
//            mediaPlayer?.reset()
//            mediaPlayer = MediaPlayer().apply {
//                setDataSource(musicFile.path)
//                setOnPreparedListener {
//
//                    start()
//                }
//                setOnErrorListener { _, _, _ ->
//                    Toast.makeText(this@MusicActivity, "Error occurred while playing the song", Toast.LENGTH_SHORT).show()
//                    false
//                }
//                prepareAsync()
//            }
        }
    }

//    override fun onDestroy() {
//        mediaPlayer?.release()
//        super.onDestroy()
//    }
}
