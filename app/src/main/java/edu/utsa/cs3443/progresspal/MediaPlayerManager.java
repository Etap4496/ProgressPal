package edu.utsa.cs3443.progresspal;

import android.content.Context;
import android.media.MediaPlayer;

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
        MediaPlayer player = getInstance(context);
        if (!player.isPlaying()) {
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
