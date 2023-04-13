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
            MusicFile("CronicPain Track 1","https://firebasestorage.googleapis.com/v0/b/canmnvas.appspot.com/o/01a04.mp3?alt=media&token=bbbcd4f9-2b59-4be2-90ff-da12fd9e2fdb"),
            MusicFile("CronicPain Track 2","https://firebasestorage.googleapis.com/v0/b/canmnvas.appspot.com/o/01a05.mp3?alt=media&token=868e94bc-fbdd-4e94-996c-5bac38a92c77"),
            MusicFile("CronicPain Track 3","https://firebasestorage.googleapis.com/v0/b/canmnvas.appspot.com/o/01a05.mp3?alt=media&token=868e94bc-fbdd-4e94-996c-5bac38a92c77"),
            MusicFile("CronicPain Track 4","https://firebasestorage.googleapis.com/v0/b/canmnvas.appspot.com/o/07%20Sonata%20in%20C%20Major%20K%20309.mp3?alt=media&token=ff7885fd-4722-46be-be22-1ace69ad97b4"),
            MusicFile("Insomnia Track 1","https://firebasestorage.googleapis.com/v0/b/canmnvas.appspot.com/o/13%20Mozart%20G%20Major%20Sonata%20K283%2C%20I.mp3?alt=media&token=7b0313cd-597a-4aec-8e1f-17d64c9f4809"),
            MusicFile("Insomnia Track 2","https://firebasestorage.googleapis.com/v0/b/canmnvas.appspot.com/o/07%20Sonata%20in%20C%20Major%20K%20309.mp3?alt=media&token=ff7885fd-4722-46be-be22-1ace69ad97b4"),
            MusicFile("Insomnia Track 3","https://firebasestorage.googleapis.com/v0/b/canmnvas.appspot.com/o/07%20Sonata%20in%20C%20Major%20K%20309.mp3?alt=media&token=ff7885fd-4722-46be-be22-1ace69ad97b4"),
            MusicFile("Insomnia Track 4","https://firebasestorage.googleapis.com/v0/b/canmnvas.appspot.com/o/07%20Sonata%20in%20C%20Major%20K%20309.mp3?alt=media&token=ff7885fd-4722-46be-be22-1ace69ad97b4"),
            MusicFile("Parkinson's Track 1","https://firebasestorage.googleapis.com/v0/b/canmnvas.appspot.com/o/07%20Sonata%20in%20C%20Major%20K%20309.mp3?alt=media&token=ff7885fd-4722-46be-be22-1ace69ad97b4"),
            MusicFile("Parkinson's Track 2","https://firebasestorage.googleapis.com/v0/b/canmnvas.appspot.com/o/07%20Sonata%20in%20C%20Major%20K%20309.mp3?alt=media&token=ff7885fd-4722-46be-be22-1ace69ad97b4"),
            MusicFile("Parkinson's Track 3","https://firebasestorage.googleapis.com/v0/b/canmnvas.appspot.com/o/07%20Sonata%20in%20C%20Major%20K%20309.mp3?alt=media&token=ff7885fd-4722-46be-be22-1ace69ad97b4"),
            MusicFile("Parkinson's Track 4","https://firebasestorage.googleapis.com/v0/b/canmnvas.appspot.com/o/07%20Sonata%20in%20C%20Major%20K%20309.mp3?alt=media&token=ff7885fd-4722-46be-be22-1ace69ad97b4"),
            MusicFile("Alzheimer's Track 1","https://firebasestorage.googleapis.com/v0/b/canmnvas.appspot.com/o/07%20Sonata%20in%20C%20Major%20K%20309.mp3?alt=media&token=ff7885fd-4722-46be-be22-1ace69ad97b4"),
            MusicFile("Alzheimer's Track 2","https://firebasestorage.googleapis.com/v0/b/canmnvas.appspot.com/o/07%20Sonata%20in%20C%20Major%20K%20309.mp3?alt=media&token=ff7885fd-4722-46be-be22-1ace69ad97b4"),
            MusicFile("Alzheimer's Track 3","https://firebasestorage.googleapis.com/v0/b/canmnvas.appspot.com/o/07%20Sonata%20in%20C%20Major%20K%20309.mp3?alt=media&token=ff7885fd-4722-46be-be22-1ace69ad97b4"),
            MusicFile("Alzheimer's Track 4","https://firebasestorage.googleapis.com/v0/b/canmnvas.appspot.com/o/07%20Sonata%20in%20C%20Major%20K%20309.mp3?alt=media&token=ff7885fd-4722-46be-be22-1ace69ad97b4")
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
