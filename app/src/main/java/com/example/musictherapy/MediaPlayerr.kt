package com.example.musictherapy

import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity

class MediaPlayerr : AppCompatActivity() {

    private var mediaPlayer: MediaPlayer? = null
    private lateinit var seekBar: SeekBar
    private lateinit var playPauseButton: Button
    private var handler: Handler? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_media_player)

        // Find views
        playPauseButton = findViewById(R.id.playPauseButton)
        seekBar = findViewById(R.id.seekBar)

        // Get music file path from intent
        val musicFilePath = intent.getStringExtra("musicFilepath")
        if (musicFilePath != null) {
            // Initialize the MediaPlayer with the music file path
            mediaPlayer = MediaPlayer().apply {
                setDataSource(musicFilePath)
                prepare()
            }

            // Setup the play/pause button
            playPauseButton.setOnClickListener {
                if (mediaPlayer?.isPlaying == true) {
                    mediaPlayer?.pause()
                    handler?.removeCallbacks(updateSeekBar)
                    playPauseButton.text = "Play"
                } else {
                    mediaPlayer?.start()
                    handler?.post(updateSeekBar)
                    playPauseButton.text = "Pause"
                }
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
