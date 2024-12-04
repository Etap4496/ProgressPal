package edu.utsa.cs3443.progresspal.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.media.MediaPlayer;

import edu.utsa.cs3443.progresspal.R;
/**
 * The MediaPlayerManager controls the music playing in the app
 * @author Eli Tapia uxb422
 * @author Mathew Robillard gll855
 * @author Marc Jabian ibs065
 * @author Leslie Henley lbu591
 */
public class MediaPlayerManager {
    private static MediaPlayer mediaPlayer;
    private static MediaPlayer taskCompletePlayer;
    private static boolean isInitialized = false;

    /**
     * Media Player plays the music in a loop
     * @param context, the context passed to the media player (Context)
     * @return MediaPlayer, the media player playing the music
     */
    public static MediaPlayer getInstance(Context context) {
        if (mediaPlayer == null) {
            mediaPlayer = MediaPlayer.create(context, R.raw.bgmusic);
            mediaPlayer.setLooping(true); // Set music to loop
            isInitialized = true; // Flag to check initialization
        }
        return mediaPlayer;
    }

    /**
     * starts the music
     * @param context, the context passed to the shared preferences (Context)
     */
    public static void start(Context context) {
        // Check shared preferences for music state
        SharedPreferences preferences = context.getSharedPreferences("AppSettings", Context.MODE_PRIVATE);
        boolean isMusicEnabled = preferences.getBoolean("music_enabled", true);

        MediaPlayer player = getInstance(context);
        if (isMusicEnabled && !player.isPlaying()) {
            player.start();
        }
    }

    /**
     * pauses the music
     */
    public static void pause() {
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
        }
    }

    /**
     * plays a trumpet sound when a task is completed
     * @param context, the context passed to the shared preferences (Context)
     */
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