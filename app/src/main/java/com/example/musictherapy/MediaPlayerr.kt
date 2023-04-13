package com.example.musictherapy
import android.annotation.SuppressLint
import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.widget.Button
import android.widget.ImageView
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity
import com.example.musictherapy.R

class MediaPlayerr : AppCompatActivity() {

    private var mediaPlayer: MediaPlayer? = null
    private lateinit var seekBar: SeekBar
    private var handler: Handler? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_media_player)

        // Find views
        val playButton = findViewById<ImageView>(R.id.playButton)
        val pauseButton = findViewById<ImageView>(R.id.pauseButton)
        seekBar = findViewById(R.id.seekBar)

        // Get music file path from intent
        val musicFilePath = intent.getStringExtra("musicFilepath")
        if (musicFilePath != null) {
            // Initialize the MediaPlayer with the music file path
            mediaPlayer = MediaPlayer().apply {
                setDataSource(musicFilePath)
                prepare()
            }

            // Setup the play button to play the media
            playButton.setOnClickListener {
                mediaPlayer?.start()
                handler?.post(updateSeekBar)
            }

            // Setup the pause button to pause the media
            pauseButton.setOnClickListener {
                mediaPlayer?.pause()
                handler?.removeCallbacks(updateSeekBar)
            }

            // Setup the SeekBar
            seekBar.max = mediaPlayer?.duration ?: 0
            handler = Handler()
            seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
                override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                    if (fromUser) {
                        mediaPlayer?.seekTo(progress)
                    }
                }

                override fun onStartTrackingTouch(seekBar: SeekBar?) {
                    handler?.removeCallbacks(updateSeekBar)
                }

                override fun onStopTrackingTouch(seekBar: SeekBar?) {
                    handler?.post(updateSeekBar)
                }
            })
        }
    }

    private val updateSeekBar = object : Runnable {
        override fun run() {
            val currentPosition = mediaPlayer?.currentPosition ?: 0
            seekBar.progress = currentPosition
            handler?.postDelayed(this, 100)
        }
    }

    override fun onDestroy() {
        this.mediaPlayer?.release()
        handler?.removeCallbacks(updateSeekBar)
        super.onDestroy()
    }
}
