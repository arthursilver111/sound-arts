package com.example.test;

import androidx.appcompat.app.AppCompatActivity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private MediaPlayer mediaBook;
    private MediaPlayer mediaCity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageButton buttonBook = findViewById(R.id.buttonBook);
        buttonBook.setOnClickListener(this);
        ImageButton buttonCity = findViewById(R.id.buttonCity);
        buttonCity.setOnClickListener(this);
        mediaBook = MediaPlayer.create(this, R.raw.book);
        mediaCity = MediaPlayer.create(this, R.raw.city);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.buttonBook) {
            soundPlayButton(mediaBook);
        }
        if (view.getId() == R.id.buttonCity) {
            soundPlayButton(mediaCity);
        }
    }

    private void soundPlayButton(MediaPlayer mediaPlayer) {
        if (mediaBook.isPlaying()) {
            mediaBook.pause();
            mediaBook.seekTo(0);
            mediaBook.setLooping(false);
        }
        if (mediaCity.isPlaying()) {
            mediaCity.pause();
            mediaCity.seekTo(0);
            mediaCity.setLooping(false);
        }
        mediaPlayer.start();
    }
}
