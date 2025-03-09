package org.example;

import java.io.File;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class SoundPlayer {
    public static void playAlarm() {
        try {
            File file = new File("src/main/resources/alarm.wav");
            if (!file.exists()) {
                System.out.println("Alarm sound file not found!");
                return;
            }

            String path = file.toURI().toString();
            Media sound = new Media(path);
            MediaPlayer mediaPlayer = new MediaPlayer(sound);
            mediaPlayer.setVolume(1.0);
            mediaPlayer.setOnReady(mediaPlayer::play);
            mediaPlayer.setOnError(() -> System.out.println("Error playing sound: " + mediaPlayer.getError()));

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error in SoundPlayer!");
        }
    }
}