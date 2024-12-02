package edu.utsa.cs3443.progresspal.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.media.MediaPlayer;

import edu.utsa.cs3443.progresspal.R;

public class MediaPlayerManager {
    private static MediaPlayer mediaPlayer;
    private static MediaPlayer taskCompletePlayer;
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
        if (taskCompletePlayer != null) {
            taskCompletePlayer.release();
            taskCompletePlayer = null;
        }
    }

    public static boolean isInitialized() {
        return isInitialized;
    }

    public static void playTaskCompleteSound(Context context) {
        // Check shared preferences for SFX state
        SharedPreferences preferences = context.getSharedPreferences("AppSettings", Context.MODE_PRIVATE);
        boolean isSfxEnabled = preferences.getBoolean("sfx_enabled", true);

        if (isSfxEnabled) {
            if (taskCompletePlayer == null) {
                taskCompletePlayer = MediaPlayer.create(context, R.raw.taskcomplete);
            } else {
                taskCompletePlayer.reset();
                taskCompletePlayer = MediaPlayer.create(context, R.raw.taskcomplete);
            }

            taskCompletePlayer.setOnCompletionListener(mp -> {
                mp.release();
                taskCompletePlayer = null; // Release resources after completion
            });

            taskCompletePlayer.start();
        }
    }
}