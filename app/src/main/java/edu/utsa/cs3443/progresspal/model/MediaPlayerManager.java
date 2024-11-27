package edu.utsa.cs3443.progresspal.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.media.MediaPlayer;

import edu.utsa.cs3443.progresspal.R;

public class MediaPlayerManager {
    private static MediaPlayer mediaPlayer;
    private static boolean isInitialized = false;

    public static MediaPlayer getInstance(Context context) {
        if (mediaPlayer == null) {
            mediaPlayer = MediaPlayer.create(context, R.raw.bgmusic);
            mediaPlayer.setLooping(true); // Set music to loop
            isInitialized = true; // Flag to check initialization
        }
        return mediaPlayer;
    }

    public static void start(Context context) {
        // Check shared preferences for music state
        SharedPreferences preferences = context.getSharedPreferences("AppSettings", Context.MODE_PRIVATE);
        boolean isMusicEnabled = preferences.getBoolean("music_enabled", true);

        MediaPlayer player = getInstance(context);
        if (isMusicEnabled && !player.isPlaying()) {
            player.start();
        }
    }

    public static void pause() {
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
        }
    }

    public static void release() {
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
            isInitialized = false;
        }
    }

    public static boolean isInitialized() {
        return isInitialized;
    }
}
